package interface_adapter.comment;

import entity.Comment.Comments;
import use_case.comment.CommentInputBoundary;
import use_case.comment.CommentInputData;

public class CommentController {
    final CommentInputBoundary commentInteractor;

    public CommentController(CommentInputBoundary commentInteractor) {
        this.commentInteractor = commentInteractor;
    }

    public void loadComment() {
        commentInteractor.loadComment();
    }

    public void addNewComment(Comments comments, String user, String newComment) {
        // Pack the data into a InputData
        CommentInputData commentInputData = new CommentInputData(comments, user, newComment);
        commentInteractor.addNewComment(commentInputData);
    }

    public void goBackToRecipeDetail() {
        commentInteractor.goBackToRecipeDetail();
    }
}
