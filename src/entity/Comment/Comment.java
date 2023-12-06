package entity.Comment;

public class Comment {
    private String user;
    private String comment;

    public Comment() {
    }

    public Comment(String user, String comment) {
        this.user = user;
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }
}
