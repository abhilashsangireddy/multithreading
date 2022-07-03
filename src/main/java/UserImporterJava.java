import com.google.common.collect.Lists;
import javafx.util.Pair;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserImporterJava {

    private static final Pattern EMAIL_PATTERN_MATCHER = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    /**
     * Returns a list of pairs of invalid users and their corresponding Invalidation type. This method filters
     * the array of {@link ImportUser} before importing them to Small Improvements.
     * This method divides the huge set of Users into batches of maximum size
     * 10 and processes these batches on a fixed thread pool with 10 threads.
     * The users are filtered on various criteria as per business requirements.
     *
     * @param users array of users to be imported.
     * @return a list of pairs of invalid users and their corresponding {@link InvalidationType}
     */
    public List<Pair<ImportUser, InvalidationType>> filterAndImportUsers(ImportUser[] users) {
        List<ImportUser> userList = new LinkedList<>(Arrays.asList(users));

        List<Pair<ImportUser, InvalidationType>> invalidUsers = new Vector<>();

        Map<String, Boolean> emailMap = new ConcurrentHashMap<>();
        Map<Integer, Boolean> employeeNumberMap = new ConcurrentHashMap<>();
        HierarchyGraph hierarchyGraph = new HierarchyGraph();

        List<List<ImportUser>> smallerUserLists = Lists.partition(userList, 10);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (List<ImportUser> choppedUserList : smallerUserLists) {
            Runnable runnable = () -> {
                try {
                    Iterator<ImportUser> i = choppedUserList.iterator();
                    for (ImportUser user : choppedUserList) {
                        if (user == null) {
                            invalidUsers.add(new Pair<>(null, InvalidationType.NULL_USER));
                            continue;
                        }
                        validateEmail(user, invalidUsers, emailMap);
                        validateEmployeeNumber(user, invalidUsers, employeeNumberMap);
                        hierarchyGraph.checkAndAddEdge(user.getManagerEmail(), user.getEmail());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            executor.execute(runnable);
        }
        try {
            executor.shutdown();
            executor.awaitTermination(10L, TimeUnit.SECONDS);
            invalidateCyclicReferenceUsers(hierarchyGraph, userList, invalidUsers);
            for (Pair<ImportUser, InvalidationType> invalidUser : invalidUsers) {
                userList.remove(invalidUser.getKey());
            }
            //Final method call to import Validated users into the system.
            importUsersToSmallImprovements(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invalidUsers;
    }

    private void importUsersToSmallImprovements(List<ImportUser> userList) {
    }

    /**
     * A directed graph is created while iterating through the users, and it is used to
     * detect the users that are contributing to cyclic references.
     * This method works well in a case where the hierarchies are forming forests
     * (multiple disjoint graphs) instead of a single graph.
     *
     * @param hierarchyGraph Directed graph created while iterating users.
     * @param users          List of input users.
     * @param invalidUsers   Concurrent list of invalid users.
     */
    private void invalidateCyclicReferenceUsers(HierarchyGraph hierarchyGraph, List<ImportUser> users,
                                                List<Pair<ImportUser, InvalidationType>> invalidUsers) {
        if (hierarchyGraph.containsCycle()) {
            Set<String> cyclicReferenceParticipants = hierarchyGraph.getCycles();
            users.stream().filter(Objects::nonNull).filter(user -> cyclicReferenceParticipants.contains(user.getEmail())).forEach(entry -> invalidUsers.add(new Pair<>(entry, InvalidationType.CYCLIC_REFERENCE)));
        }
    }

    /**
     * This method  a concurrent list of invalid users which is being prepared while
     * filtering out the users in case of a duplicate employee number. This method leaves out the first
     * user corresponding to the duplicate number as it can be imported properly if it passes other conditions.
     *
     * @param employeeNumberMap ConcurrentMap which stores the information if a certain employee number is duplicated or not.
     * @param user              The user on which employee number validation is being done.
     * @param invalidUsers      Concurrent list of invalid users.
     */
    private void validateEmployeeNumber(ImportUser user, List<Pair<ImportUser, InvalidationType>> invalidUsers,
                                        Map<Integer, Boolean> employeeNumberMap) {
        if (user.getEmployeeNumber() != null) {
            if (employeeNumberMap.containsKey(user.getEmployeeNumber())) {
                employeeNumberMap.replace(user.getEmployeeNumber(), true);
                invalidUsers.add(new Pair<>(user, InvalidationType.DUPLICATE_EMP_NUMBER));
            } else {
                employeeNumberMap.put(user.getEmployeeNumber(), false);
            }
        }
    }

    /**
     * This method  a concurrent list of invalid users which is being prepared while
     * filtering out the users in case of a duplicate email. This method leaves out the first
     * user corresponding to the duplicate email as it can be imported properly if it passes other conditions.
     *
     * @param emailMap     ConcurrentMap which stores the information if a certain email is duplicated or not.
     * @param user         The user on which employee number validation is being done.
     * @param invalidUsers Concurrent list of invalid users.
     */
    private void validateEmail(ImportUser user, List<Pair<ImportUser, InvalidationType>> invalidUsers, Map<String, Boolean> emailMap) {
        if (user.getEmail() == null) {
            invalidUsers.add(new Pair<>(user, InvalidationType.NULL_EMAIL));
            return;
        }
        Matcher matcher = EMAIL_PATTERN_MATCHER.matcher(user.getEmail());
        if (!matcher.matches()) {
            invalidUsers.add(new Pair<>(user, InvalidationType.INVALID_EMAIL));
            return;
        }
        if (emailMap.containsKey(user.getEmail())) {
            emailMap.replace(user.getEmail(), true);
            invalidUsers.add(new Pair<>(user, InvalidationType.DUPLICATE_EMAIL));
        } else {
            emailMap.put(user.getEmail(), false);
        }
    }
}
