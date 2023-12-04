package view;

import interface_adapter.comment.CommentController;
import entity.Comment;

public class CommentView {
    private CommentController commentController;

    public CommentView(CommentController commentController) {
        this.commentController = commentController;
    }

    public void displayComments(int recipeId) {
        // Logic to display comments for a recipe
        // This method might interact with the CommentController to fetch comments
    }

    public void addCommentButtonClicked(String commentText, int recipeId, int userId) {
        Comment comment = new Comment(commentText, recipeId, userId);
        commentController.addComment(comment);
        // Update the view based on the success/failure of adding the comment
    }

    public void showSuccessMessage(String message) {
        // Logic to display success message in the UI
    }

    public void showErrorMessage(String message) {
        // Logic to display error message in the UI
    }

}
