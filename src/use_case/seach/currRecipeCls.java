package use_case.seach;

import org.json.JSONArray;
import org.json.JSONObject;

public class currRecipeCls implements currRecipeInterface{
    JSONObject recipeResponse;
    JSONObject recipe;
    JSONObject currRecipe;
    String currRecipeLabel;
    JSONArray ingredientsLine;
    String currRecipeUrl;

    public currRecipeCls(JSONObject data, int selection) {
        recipeResponse = data.getJSONArray("hits").getJSONObject(selection);
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
