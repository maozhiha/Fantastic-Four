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
    public void displayRecipe(RecipeListInputData recipeListInputData) {
        System.out.println("RecipeListInteractor: loadComment");
        Recipe recipe = recipeListInputData.getRecipe();
        String recipeId = recipe.getId();

        if(commentFileDataAccessObject.existsById(recipeId)) {
            Comments comments = commentFileDataAccessObject.findById(recipeId);
            recipeListPresentator.displayRecipeDetail(new RecipeListOutputData(recipe,recipe.getLabel(), recipe.getId(), comments ));
        }else{
            Comments comments = CommentsFactory.createNewComments(recipeId, recipe.getLabel());
            recipeListPresentator.displayRecipeDetail(new RecipeListOutputData(recipe,recipe.getLabel(), recipe.getId(), comments));
        }
    }
}
