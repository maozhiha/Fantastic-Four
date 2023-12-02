package use_case;

import org.json.JSONArray;
import org.json.JSONObject;


public class CurrentRecipeDisplayer {

    public static void CurrentRecipe(JSONObject data, int selection) {
                    currRecipeCls currRecipe = new currRecipeCls(data, selection);
                    displayRecipeDict(currRecipe);
                }

    public static void displayRecipeDict(currRecipeCls currRecipe) {
        System.out.println();
        System.out.println("==========================================================================");
        System.out.println(currRecipe.getcurrRecipeLabel() + ":");
        System.out.println("--------------------------------------------------------------------------");
        JSONArray ingredientsLine = currRecipe.getingredientsLine();
        for (int i = 0; i < ingredientsLine.length(); i++) {
            System.out.println(" - " + ingredientsLine.getString(i));
        }
        System.out.println();
        System.out.println("Directions: " + currRecipe.getcurrRecipeUrl());
        System.out.println("==========================================================================");
        System.out.print("");
    }
}