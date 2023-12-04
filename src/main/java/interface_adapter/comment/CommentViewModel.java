package interface_adapter.comment;

public class CommentViewModel {
    private boolean commentStatus;
    private String message;

    public boolean isCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(boolean commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
