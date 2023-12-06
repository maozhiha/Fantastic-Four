package use_case.recipe_list;

import entity.Recipe;

public class RecipeListInputData {
    Recipe recipe;

    public RecipeListInputData(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
