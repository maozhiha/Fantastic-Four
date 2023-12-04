package interface_adapter.comment;

import use_case.comment.ICommentInputBoundary;
import use_case.comment.CommentInputData;
import entity.Comment;

public class CommentController {
    private final ICommentInputBoundary commentInteractor;

    public CommentController(ICommentInputBoundary commentInteractor) {
        this.commentInteractor = commentInteractor;
    }

    public void addComment(Comment comment) {
        CommentInputData inputData = new CommentInputData(comment.getText(), comment.getRecipeId(), comment.getUserId());
        commentInteractor.addComment(inputData);
    }

}
