package use_case.saved_recipes;

import entity.Recipe;
import org.json.JSONArray;
import org.json.JSONObject;

public class IdCurrRecipeCls {
    JSONObject recipeResponse;
    JSONObject recipe;
    JSONObject currRecipe;
    String currRecipeLabel;
    JSONArray ingredientsLine;
    String currRecipeUrl;

    public IdCurrRecipeCls(JSONObject data) {
        recipeResponse = data.getJSONArray("hits").getJSONObject(0);
        recipe = recipeResponse.getJSONObject("recipe");
        currRecipe = new JSONObject();
        currRecipe.put("ingredients_line", recipe.getJSONArray("ingredientLines"));
        currRecipe.put("ingredients", recipe.getJSONArray("ingredients"));
        currRecipe.put("label", recipe.getString("label"));
        currRecipe.put("url", recipe.getString("url"));
        currRecipe.put("uri", recipe.getString("uri"));
        currRecipeLabel = currRecipe.getString("label");
        ingredientsLine = currRecipe.getJSONArray("ingredients_line");
        currRecipeUrl = currRecipe.getString("url");
    }

    public JSONObject getrecipeResponse() {
        return recipeResponse;
    }

    public JSONObject getrecipe() {
        return recipe;
    }

    public JSONObject getcurrRecipe() {
        return currRecipe;
    }

    public String getcurrRecipeLabel() {
        return currRecipeLabel;
    }

    public JSONArray getingredientsLine() {
        return ingredientsLine;
    }

    public String getcurrRecipeUrl() {
        return currRecipeUrl;
    }
}
