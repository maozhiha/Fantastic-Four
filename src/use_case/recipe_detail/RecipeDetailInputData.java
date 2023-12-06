package use_case.recipe_detail;

import entity.Recipe;

public class RecipeDetailInputData {
    private Recipe recipe;

    public RecipeDetailInputData(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
