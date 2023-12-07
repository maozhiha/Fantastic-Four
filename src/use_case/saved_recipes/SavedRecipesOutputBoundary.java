package use_case.saved_recipes;

import java.util.List;

public interface SavedRecipesOutputBoundary {
    void goBackToLoggedIn();
    void goToSavedRecipes(List<IdCurrRecipeCls> recipeObjs);
}
