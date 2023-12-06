package interface_adapter.recipe_detail;

import entity.Recipe;

public class RecipeDetailState {
    private Recipe recipe;

    public RecipeDetailState() {
    }

    public RecipeDetailState(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
