package use_case.comment;

public class CommentOutputData {
    private boolean success;  // Indicates if the operation was successful
    private String message;   // Additional information or error message

    public CommentOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CommentOutputData() {

    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

}
