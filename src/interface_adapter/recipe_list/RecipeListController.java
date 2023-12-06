package interface_adapter.recipe_list;

import entity.Recipe;
import use_case.recipe_list.RecipeListInputBoundary;
import use_case.recipe_list.RecipeListInputData;

public class RecipeListController {

    final RecipeListInputBoundary recipeListInteractor;

    public RecipeListController(RecipeListInputBoundary recipeListInteractor) {
        this.recipeListInteractor = recipeListInteractor;
    }

    public void execute() {

    }

    public void goBackToSearchForm() {
        recipeListInteractor.goBack();
    }

    public void displayRecipeDetail(Recipe recipe) {
        RecipeListInputData recipeListInputData = new RecipeListInputData(recipe);

        recipeListInteractor.displayRecipe(recipeListInputData);
    }
}
