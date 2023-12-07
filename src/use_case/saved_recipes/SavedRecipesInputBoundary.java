package use_case.saved_recipes;

public interface SavedRecipesInputBoundary {
    void goBackToLoggedIn();
    void displayRecipes(String username);
}
