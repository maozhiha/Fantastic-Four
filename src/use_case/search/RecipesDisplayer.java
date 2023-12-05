package use_case.search;

import interface_adapter.search_form.SearchFormController;
import org.json.*;
import view.*;

import java.util.*;

public class RecipesDisplayer {
    
    public static void DisplayRecipes() {
        // Retrieve data from the controller
        JSONObject data = SearchFormController.getRecipeData();
        int arr_length = SearchFormController.getArrLength();
        int index = SearchFormController.getIndex();

        RecipeList recipeList = new RecipeList(null);
        //if (arr_length == 1) {
        //    System.out.println(arr_length + " recipes was found.");
        //} else if (arr_length >= 100) {
        //    System.out.println("100 recipes or more than 100 recipes were found");
        //    arr_length = 100;
        //} else {
        //    System.out.println(arr_length + " recipes were found.");
        //}
        
        index = displayRecipeLabels(data, index, arr_length, recipeList);
        SearchFormController.setindex(index);
    }    

    //public static void DisplayRecipesFurther() {

    //    boolean findOtherRecipes = true;

    //    while (findOtherRecipes) {
    //        System.out.println("Input recipe number or\n\t(n)ext to display next 10 recipes\n\t(p)revious to display previous 10 recipes\n\t(q)uit to find other recipes");

    //        String select = Controller.getUserChoice();

    //        switch (select.toLowerCase()) {
    //            case "q":
    //                findOtherRecipes = false;
    //                break;
    //            case "n":
    //                index = displayRecipeLabels(data, index, arr_length, recipeList);
    //                break;
    //            case "p":
    //                index = index - 20;
    //                if (index < 0) {
    //                    index = 0;
    //                }
    //                index = displayRecipeLabels(data, index, arr_length, recipeList);
    //                break;
    //            default:
    //                int selection = Integer.parseInt(select);
    //                displayRecipeDetails(selection);
    //                break;
    //        }
    //    }
    //}

    public static int displayRecipeLabels(JSONObject data, int index, int arr_length, RecipeList recipeList) {
        //System.out.println();
        HitsCls hits = new HitsCls(data, index, arr_length);
        String[] hitsArray = hits.getHitsArray();
        ArrayList<String> recipes = new ArrayList<>();

        if (arr_length == 1) {
            recipes.add(arr_length + " recipes was found.");
        } else if (arr_length >= 100) {
            recipes.add("100 recipes or more than 100 recipes were found");
        } else {
            recipes.add(arr_length + " recipes were found.");
        }

        for (int i = 0; i < 10; i++) {
            if (hitsArray[i] != null) {
                //System.out.println(hitsArray[i]);
                SearchFormController.setRecipeList(hitsArray[i]);
                recipes.add(hitsArray[i]);
                index++;
            }
        }
        //System.out.println();
        // Update the RecipeList GUI with the recipes
        recipeList.updateRecipeList(recipes);
        return index;
    }

    //public static void displayRecipeDetails(int selectedIndex) {
    //    ArrayList<String> hitsArray = Controller.gethit();
    //    if (selectedIndex >= 0 && selectedIndex < hitsArray.size()) {
    //        String selectedRecipe = hitsArray.get(selectedIndex);
    //        // Assuming you want to print the details to the console for now
    //        System.out.println("Details for Recipe #" + (selectedIndex + 1) + ": " + selectedRecipe);
    //    } else {
    //        System.out.println("Invalid index. Please enter a valid recipe index.");
    //    }
    //}
}