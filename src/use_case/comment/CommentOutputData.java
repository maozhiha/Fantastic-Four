package use_case.comment;

import entity.Comment.Comments;

public class CommentOutputData {
    private Comments comments;

    public CommentOutputData(Comments comments) {
        this.comments = comments;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }
}
