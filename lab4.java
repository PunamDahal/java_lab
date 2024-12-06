
class InvalidStudentIDException extends Exception {
    public InvalidStudentIDException(String message) {
        super(message);
    }
}

public class lab4{
    public static void main(String[] args) {
        try {
            validateStudentID("CSIT2023");
            validateStudentID("INVALID-ID");
        } catch (InvalidStudentIDException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void validateStudentID(String studentID) throws InvalidStudentIDException {
        if (!studentID.startsWith("CSIT")) {
            throw new InvalidStudentIDException("Invalid Student ID: " + studentID);
        }
        System.out.println("Valid Student ID: " + studentID);
    }
}
