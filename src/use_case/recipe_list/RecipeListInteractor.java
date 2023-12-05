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

    @Override
    public void loadComment(RecipeListInputData recipeListInputData) {
        // Get recipe from recipeListInputData
        // Use DAO to get comment for recipe
        // Prepare comment in recipeListOutputData
        // notify presentator to display comment with outputdata
    }
}
