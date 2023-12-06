package use_case.recipe_detail;

import use_case.recipe_list.RecipeListOutputData;

public interface RecipeDetailOutputBoundary {
    void displayComment(RecipeListOutputData recipeListOutputData);

    void goBackToRecipeListView();
}
