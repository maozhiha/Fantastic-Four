package use_case.seach;

import interface_adapter.search.Controller;
import org.json.*;
import view.*;

import java.util.*;

public class RecipesDisplayer2 {
    public static void DisplayRecipes() {
        // Retrieve data from the controller
        JSONObject data = Controller.getRecipeData();
        int arr_length = Controller.getArrLength();
        int index = Controller.getIndex();
        String select = Controller.getUserChoice();

        RecipeList recipeList = new RecipeList(null);
        //index = displayRecipeLabels(data, index, arr_length, recipeList);
        //boolean findOtherRecipes = true;

        //while (findOtherRecipes) {
            //System.out.println("Input recipe number or\n\t(n)ext to display next 10 recipes\n\t(p)revious to display previous 10 recipes\n\t(q)uit to find other recipes");

        switch (select.toLowerCase()) {
            case "q":
                //findOtherRecipes = false;
                break;
            case "n":
                index = displayRecipeLabels(data, index, arr_length, recipeList);
                Controller.setindex(index);
                break;
            case "p":
                index = index - 20;
                if (index < 0) {
                    index = 0;
                }
                index = displayRecipeLabels(data, index, arr_length, recipeList);
                Controller.setindex(index);
                break;
            default:
                int selection = Integer.parseInt(select);
                if (selection > 0 && selection - 1 < index) {
                    currRecipeCls currRecipe = new currRecipeCls(data, selection - 1);
                    displayRecipeDict(currRecipe, recipeList);
                }
                //displayRecipeDetails(selection, recipeList);
                break;
        }
        //}
    }

    public static int displayRecipeLabels(JSONObject data, int index, int arr_length, RecipeList recipeList) {
        //System.out.println();
        HitsCls hits = new HitsCls(data, index, arr_length);
        String[] hitsArray = hits.getHitsArray();
        ArrayList<String> recipes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (hitsArray[i] != null) {
                System.out.println(hitsArray[i]);
                Controller.setRecipeList(hitsArray[i]);
                recipes.add(hitsArray[i]);
                index++;
            }
        }
        //System.out.println();
        // Update the RecipeList GUI with the recipes
        recipeList.updateRecipeList(recipes);
        return index;
    }

    //public static void displayRecipeDetails(int selectedIndex, RecipeList recipeList) {
    //    ArrayList<String> hitsArray = Controller.gethit();
    //    ArrayList<String> ingredient = new ArrayList<>();
    //    if (selectedIndex >= 0 && selectedIndex < hitsArray.size()) {
    //        String selectedRecipe = hitsArray.get(selectedIndex);
    //        ingredient.add("Details for Recipe #" + (selectedIndex + 1) + ": " + selectedRecipe);
    //        // Assuming you want to print the details to the console for now
    //        //System.out.println("Details for Recipe #" + (selectedIndex + 1) + ": " + selectedRecipe);
    //    } else {
    //        ingredient.add("Invalid index. Please enter a valid recipe index.");
    //        //System.out.println("Invalid index. Please enter a valid recipe index.");
    //    }
    //    recipeList.updateRecipeList(ingredient);
    //}

    public static void displayRecipeDict(currRecipeCls currRecipe, RecipeList recipeList) {
        ArrayList<String> ingredient = new ArrayList<>();
        ingredient.add("");
        ingredient.add("==========================================================================");
        ingredient.add(currRecipe.getcurrRecipeLabel() + ":");
        ingredient.add("--------------------------------------------------------------------------");
        
        JSONArray ingredientsLine = currRecipe.getingredientsLine();
        for (int i = 0; i < ingredientsLine.length(); i++) {
            ingredient.add(" - " + ingredientsLine.getString(i));
        }
        ingredient.add("");
        ingredient.add("Directions: " + currRecipe.getcurrRecipeUrl());
        ingredient.add("==========================================================================");
        ingredient.add("");
        recipeList.updateRecipeList(ingredient);
    }

}