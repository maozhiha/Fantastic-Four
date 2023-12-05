package interface_adapter.recipe_list;

import use_case.recipe_list.RecipeListInputBoundary;

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

    public void displayComment(){
        return;
    }
}
