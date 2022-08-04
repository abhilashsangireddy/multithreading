import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserImporterJavaTest {

    private UserImporterJava userImporterJava;

    @Before
    public void setUp() {
        this.userImporterJava = new UserImporterJava();
    }

    @Test
    public void UserImporter_filterAndImportUsers_CustomInput() {
        Integer expectedNullEmailUsersCount = 2,
                expectedInvalidEmailUsersCount = 3,
                expectedNullUsersCount = 5,
                expectedDuplicateEmailUsersCount = 3,
                expectedDuplicateEmpNoUsersCount = 4,
                expectedCyclicUsersCount = 6;
        Integer actualCyclicUsersCount = 0,
                actualDuplicateEmpNoUserCount = 0,
                actualDuplicateEmailUserCount = 0,
                actualNullUserCount = 0,
                actualNullEmailUserCount = 0,
                actualInvalidEmailUserCount = 0;

        List<Pair<ImportUser, InvalidationType>> invalidUsers = userImporterJava.filterAndImportUsers(FAULTY_USERS);
        for (Pair<ImportUser, InvalidationType> invalidUser : invalidUsers) {
            switch (invalidUser.getValue()) {
                case NULL_EMAIL:
                    actualNullEmailUserCount++;
                    break;
                case INVALID_EMAIL:
                    actualInvalidEmailUserCount++;
                    break;
                case NULL_USER:
                    actualNullUserCount++;
                    break;
                case DUPLICATE_EMAIL:
                    actualDuplicateEmailUserCount++;
                    break;
                case DUPLICATE_EMP_NUMBER:
                    actualDuplicateEmpNoUserCount++;
                    break;
                case CYCLIC_REFERENCE:
                    actualCyclicUsersCount++;
                    break;
                default:
                    throw new AssertionError("Null/Unknown Invalidation Type found");
            }

        }
        Assert.assertEquals("Total number of null email users doesn't match", expectedNullEmailUsersCount, actualNullEmailUserCount);
        Assert.assertEquals("Total number of invalid email users doesn't match", expectedInvalidEmailUsersCount, actualInvalidEmailUserCount);
        Assert.assertEquals("Total number of null users doesn't match", expectedNullUsersCount, actualNullUserCount);
        Assert.assertEquals("Total number of duplicate email users doesn't match", expectedDuplicateEmailUsersCount, actualDuplicateEmailUserCount);
        Assert.assertEquals("Total number of duplicate employee numbered users doesn't match", expectedDuplicateEmpNoUsersCount, actualDuplicateEmpNoUserCount);
        Assert.assertEquals("Total number of users contributing to cyclic hierarchies doesn't match", expectedCyclicUsersCount, actualCyclicUsersCount);
    }

    @Test
    public void UserImporter_filterAndImportUsers_GivenInput(){
        ImportUser[] users = ImportUser.IMPORT_USERS;
        List<Pair<ImportUser, InvalidationType>> invalidUsers = userImporterJava.filterAndImportUsers(users);
        System.out.println(invalidUsers.size());
        Assert.assertEquals("Total number of invalid users doesn't match for the given input", 9L, invalidUsers.size());
    }
    static final ImportUser[] FAULTY_USERS = {
            null,
            new ImportUser("Big", "Boss", null, null, null),
            new ImportUser("Efren", "Pencil", "EPencil@example.com", 9, null),
            null,
            null,
            new ImportUser("Vinnie", "Stetson", "VStetson@example.com", 1, "JDaughtery@example.com"),
            new ImportUser("Duplicate", "Efren", "EPencil@example.com", 9, null),
            null,
            new ImportUser("Mary", "Tijerina", "MTijerina@example.com", 9, "HGraboski@example.com"),
            new ImportUser("Tijerina", "Mary", "MTijerina@example.com", 9, "HGraboski@example.com"),
            new ImportUser("Shawnta", "Lam", null, null, "bb@example.com"),
            new ImportUser("Mary Tijerina", "", "MTijerina@example.com", 9, "HGraboski@example.com"),
            new ImportUser("Shawnta", "Lam", "SAbhilashEmail@", null, "bb@example.com"),
            new ImportUser("Shawnta", "Lam", "SAbhilashEm", null, "bb@example.com"),
            new ImportUser("Shawnta", "Lam", "SAbhilashEm.com", null, "bb@example.com"),

            new ImportUser("Shawnta", "Lam", "abc@test.com", null, "bcd@test.com"),
            new ImportUser("Shawnta", "Lam", "bcd@test.com", null, "cde@test.com"),
            new ImportUser("Shawnta", "Lam", "cde@test.com", null, "def@test.com"),
            new ImportUser("Shawnta", "Lam", "def@test.com", null, "abc@test.com"),

            new ImportUser("Shawnta", "Lam", "efg@test.com", null, "fgh@test.com"),
            new ImportUser("Shawnta", "Lam", "fgh@test.com", null, "efg@test.com"),
            null
    };
}
