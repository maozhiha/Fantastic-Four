package use_case.recipe_detail;

import data_access.CommentFileDataAccessObject;
import entity.Comment.Comments;
import entity.Comment.CommentsFactory;
import entity.Recipe;
import use_case.recipe_list.RecipeListOutputData;

public class RecipeDetailInteractor implements RecipeDetailInputBoundary {

    final RecipeDetailOutputBoundary recipeDetailPresentator;

    final CommentFileDataAccessObject commentFileDataAccessObject;
    public RecipeDetailInteractor(RecipeDetailOutputBoundary recipeDetailPresentator, CommentFileDataAccessObject commentFileDataAccessObject) {
        this.recipeDetailPresentator = recipeDetailPresentator;
        this.commentFileDataAccessObject = commentFileDataAccessObject;
    }

    @Override
    public void comment(RecipeDetailInputData recipeDetailInputData) {
        Recipe recipe = recipeDetailInputData.getRecipe();
        String recipeId = recipe.getId();

        if(commentFileDataAccessObject.existsById(recipeId)) {
            Comments comments = commentFileDataAccessObject.findById(recipeId);
            recipeDetailPresentator.displayComment(new RecipeListOutputData(recipe,recipe.getLabel(), recipe.getId(), comments ));
        }else{
            Comments comments = CommentsFactory.createNewComments(recipeId, recipe.getLabel());
            recipeDetailPresentator.displayComment(new RecipeListOutputData(recipe,recipe.getLabel(), recipe.getId(), comments));
        }
    }

    @Override
    public void goBackToRecipeListView() {
        recipeDetailPresentator.goBackToRecipeListView();
    }
}
