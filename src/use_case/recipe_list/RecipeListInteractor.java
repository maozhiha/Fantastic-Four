package use_case.recipe_list;

public class RecipeListInteractor implements RecipeListInputBoundary{
    final RecipeListOutputBoundary recipeListPresentator;

    public RecipeListInteractor(RecipeListOutputBoundary outputBoundary) {
        this.recipeListPresentator = outputBoundary;
    }

    @Override
    public void goBack() {
        recipeListPresentator.goBackToSearchForm();
    }
}
