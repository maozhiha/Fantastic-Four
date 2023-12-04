package interface_adapter.comment;

import use_case.comment.ICommentOutputBoundary;
import use_case.comment.CommentOutputData;
import view.CommentView;

public class CommentPresenter implements ICommentOutputBoundary {
    private final CommentView commentView;

    public CommentPresenter(CommentView commentView) {
        this.commentView = commentView;
    }

    @Override
    public void presentComment(CommentOutputData outputData) {
        // Update the comment view directly based on the outputData
        if (outputData.isSuccess()) {
            commentView.showSuccessMessage(outputData.getMessage());
        } else {
            commentView.showErrorMessage(outputData.getMessage());
        }
        // Add additional UI update logic as needed
    }

}
