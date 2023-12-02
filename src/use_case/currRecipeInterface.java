package use_case;

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
