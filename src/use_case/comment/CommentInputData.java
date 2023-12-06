package use_case.comment;

import entity.Comment.Comments;

public class CommentInputData {
    private Comments comments;
    private String user;
    private String newComment;

    public CommentInputData(Comments comments, String user, String newComment) {
        this.comments = comments;
        this.user = user;
        this.newComment = newComment;
    }

    public Comments getComments() {
        return comments;
    }

    public String getUser() {
        return user;
    }

    public String getNewComment() {
        return newComment;
    }
}
