package use_case.search;

import org.json.JSONArray;
import org.json.JSONObject;

public interface currRecipeInterface {
    JSONObject getrecipeResponse();
    JSONObject getrecipe();
    JSONObject getcurrRecipe();
    String getcurrRecipeLabel();
    JSONArray getingredientsLine();
    String getcurrRecipeUrl();
}
