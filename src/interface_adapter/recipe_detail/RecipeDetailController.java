package interface_adapter.recipe_detail;

import entity.Recipe;
import use_case.recipe_detail.RecipeDetailInputBoundary;
import use_case.recipe_detail.RecipeDetailInputData;
import use_case.recipe_list.RecipeListInputBoundary;

public class RecipeDetailController {
    final RecipeDetailInputBoundary recipeDetailInteractor;

    public RecipeDetailController(RecipeDetailInputBoundary recipeDetailInputBoundary) {
        this.recipeDetailInteractor = recipeDetailInputBoundary;
    }

    public void comment(Recipe recipe) {
        RecipeDetailInputData recipeDetailInputData = new RecipeDetailInputData(recipe);
        recipeDetailInteractor.comment(recipeDetailInputData);
    }

    public void goBackToRecipeListView() {
        recipeDetailInteractor.goBackToRecipeListView();
    }
}
