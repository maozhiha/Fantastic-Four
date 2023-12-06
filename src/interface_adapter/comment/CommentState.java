package interface_adapter.comment;

import entity.Comment.Comments;

public class CommentState {
    private Comments comments;


    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }
}
