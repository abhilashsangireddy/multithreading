/**
 * A simple enum class to represent the reason that caused a certain user to be filtered
 * out during {@link UserImporterJava#filterAndImportUsers(ImportUser[])}
 */
public enum InvalidationType {
    NULL_EMAIL("The email provided is null"),
    INVALID_EMAIL("This user is assigned a invalid email"),
    DUPLICATE_EMAIL("This user is assigned a duplicate email"),
    DUPLICATE_EMP_NUMBER("This user is assigned a duplicate employee number"),
    NULL_USER("The user object is null"),
    CYCLIC_REFERENCE("This user is a participant in a cyclic hierarchy");

    private final String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    InvalidationType(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
