package use_case.comment;

import entity.Comment;
import java.util.List;

public interface CommentDataAccessInterface {
    boolean addComment(Comment comment);
    List<Comment> getCommentsByRecipe(int recipeId);
}
