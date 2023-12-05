package interface_adapter.comment;

import use_case.comment.CommentInputBoundary;

public class CommentController {
    final CommentInputBoundary commentInteractor;

    public CommentController(CommentInputBoundary commentInteractor) {
        this.commentInteractor = commentInteractor;
    }

    void loadComment() {
        commentInteractor.loadComment();
    }
}
