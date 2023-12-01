package use_case;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;


public class RecipeFinder {

    public static void main(String[] args) {
        boolean endprogram = false;
        Scanner scanner = new Scanner(System.in);
        while (!endprogram) {
            System.out.println("Find recipe? (yes/no):");
            System.out.print("\t>> ");
            String command = scanner.nextLine();
            System.out.println();
            if (command.equalsIgnoreCase("yes")) {
                searchRecipes(scanner);
            } else {
                endprogram=true;
            }
        }
        System.out.println("Thank you for using this App");
        System.out.println();
        scanner.close();
    }

    public static void searchRecipes(Scanner scanner) {
        JSONObject data = null;
        boolean success = false;
        int index = 0;
        while (!success) {
            System.out.println("enter keyword(s).  Use 'and' if multiple keywords.");
            System.out.print("\t>> ");
            String keyWord = scanner.nextLine();
            keyWord = keyWord.replaceAll("(?i) and ", "+");
            keyWord = keyWord.replaceAll("(?i) or ", ",");

            System.out.println("Enter diet labels (comma-separated):");
            System.out.println("      Check valid inputs from https://developer.edamam.com/edamam-docs-recipe-api");
            System.out.print("\t>> ");
            String dietLabels = scanner.nextLine();
           // System.out.println(dietLabels);

            System.out.println("Enter health labels (comma-separated):");
            System.out.println("      Check valid inputs from https://developer.edamam.com/edamam-docs-recipe-api");
            System.out.print("\t>> ");
            String healthLabels = scanner.nextLine();

            System.out.println("Enter meal type:");
            System.out.println("      Check valid inputs from https://developer.edamam.com/edamam-docs-recipe-api");
            System.out.print("\t>> ");
            String mealType = scanner.nextLine();

            System.out.println("Enter dish type:");
            System.out.println("      Check valid inputs from https://developer.edamam.com/edamam-docs-recipe-api");
            System.out.print("\t>> ");
            String dishType = scanner.nextLine();

            System.out.println("Enter cuisine type:");
            System.out.println("      Check valid inputs from https://developer.edamam.com/edamam-docs-recipe-api");
            System.out.print("\t>> ");
            String cuisineType = scanner.nextLine();

            SearchCls SearchKeyword = new SearchCls(keyWord); //save keywords
            FilterCls FilterCriteria = new FilterCls(dietLabels, healthLabels, mealType, dishType, cuisineType); //save filter

            UrlCls UrlClass = new UrlCls (SearchKeyword, FilterCriteria); //pass keywords and filter into urlcls
            String Url = UrlClass.getUrl(); //get url
            System.out.println(Url);

            DataCls dataClass = new DataCls(Url);//pass url into datacl to get data
            data = dataClass.getData(); //get data
            int arr_length = dataClass.getArraylength(); //get how many recipes

            if (arr_length > 0) {
                success = true;
            } else {
                System.out.println("no recipe was found according to your selected criteria");
                System.out.println("");
                System.out.print("");
                return;
            }

            if (arr_length == 1) {
                System.out.println(arr_length + " recipes was found.");
            } else if (arr_length >= 100) {
                System.out.println("100 recipes or more than 100 recipes were found");
                arr_length = 100;
            } else {
                System.out.println(arr_length + " recipes were found.");
            }

            index = displayRecipeLabels(data, index, arr_length); // to separate the info

            boolean findotherreceipes = false;
            while (!findotherreceipes) {
                System.out.println(" input recipe number or \n       (n)ext to display next 10 recipes or \n       (p)revious to display previous 10 recipes or \n       (q)uit to find other recipes");
                String select = selectFromIndex(index, scanner);
                if (select == "q") {
                    findotherreceipes=true;
                } else if (select == "n") {
                    index = displayRecipeLabels(data, index, arr_length);
                } else if (select == "p") {
                    index = index - 20;
                    if (index < 0) {
                        index = 0;
                    }
                    index = displayRecipeLabels(data, index, arr_length);
                } else {
                    int selection = Integer.parseInt(select);
                    currRecipeCls currRecipe = new currRecipeCls(data, selection);
                    displayRecipeDict(currRecipe);
                }
            }
        }
    }


    public static int displayRecipeLabels(JSONObject data, int index, int arr_length) {
        System.out.println();
        HitsCls hits = new HitsCls(data, index, arr_length);
        String[] hitsArray = hits.getHitsArray();
        for (int i = 0; i < 10; i++) {
            if (hitsArray[i] != null) {
                System.out.println(hitsArray[i]);
                index++;
            }
        }
        System.out.println();
        return index;
    }

    public static String selectFromIndex(int maxIndex, Scanner scanner) {
        String select = "-1";
        while (select.equals("-1") || Integer.parseInt(select) <= 0 || Integer.parseInt(select) > maxIndex) {
            System.out.print("\t>> ");
            select = scanner.nextLine();
            if (select.equalsIgnoreCase("q")) {
                return "q";
            } else if (select.equalsIgnoreCase("n")) {
                return "n";
            } else if (select.equalsIgnoreCase("p")) {
                return "p";
            } else {
                try {
                    select = Integer.toString(Integer.parseInt(select));
                } catch (NumberFormatException e) {
                    System.out.println("Input must be an integer!");
                    select = "-1";
                }
            }
        }
        return Integer.toString(Integer.parseInt(select) - 1);
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