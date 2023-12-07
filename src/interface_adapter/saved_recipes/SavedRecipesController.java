package interface_adapter.saved_recipes;

import use_case.saved_recipes.SavedRecipesInputBoundary;

public class SavedRecipesController {
    final SavedRecipesInputBoundary savedRecipesInteractor;
    public SavedRecipesController(SavedRecipesInputBoundary savedRecipesInputBoundary){
        this.savedRecipesInteractor = savedRecipesInputBoundary;
    }
    public void goBackToLoggedIn(){savedRecipesInteractor.goBackToLoggedIn();}

    public void displayRecipes(String username) {
        savedRecipesInteractor.displayRecipes(username);
    }
}
