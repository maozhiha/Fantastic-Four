package use_case.recipe_list;

import data_access.CommentFileDataAccessObject;
import entity.Comment.Comments;
import entity.Comment.CommentsFactory;
import entity.Recipe;

public class RecipeListInteractor implements RecipeListInputBoundary{
    final RecipeListOutputBoundary recipeListPresentator;

    final CommentFileDataAccessObject commentFileDataAccessObject;

    public RecipeListInteractor(RecipeListOutputBoundary outputBoundary, CommentFileDataAccessObject commentFileDataAccessObject) {
        this.recipeListPresentator = outputBoundary;
        this.commentFileDataAccessObject = commentFileDataAccessObject;
    }

    @Override
    public void goBack() {
        recipeListPresentator.goBackToSearchForm();
    }

    @Override
    public void loadComment(RecipeListInputData recipeListInputData) {
        // Get recipe from recipeListInputData
        // Use DAO to get comment for recipe
        // Prepare comment in recipeListOutputData
        // notify presentator to display comment with outputdata
        System.out.println("RecipeListInteractor: loadComment");
        Recipe recipe = recipeListInputData.getRecipe();
        String recipeId = recipe.getId();

        if(commentFileDataAccessObject.existsById(recipeId)) {
            Comments comments = commentFileDataAccessObject.findById(recipeId);
            recipeListPresentator.displayComment(new RecipeListOutputData(recipe.getLabel(), recipe.getId(), comments ));
        }else{
            Comments comments = CommentsFactory.createNewComments(recipeId, recipe.getLabel());
            recipeListPresentator.displayComment(new RecipeListOutputData(recipe.getLabel(), recipe.getId(), comments));
        }
    }
}
