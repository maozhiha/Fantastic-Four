import org.json.JSONObject;

import java.util.Scanner;


public class GetInput {

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

            UrlCls UrlClass = new UrlCls(SearchKeyword, FilterCriteria); //pass keywords and filter into urlcls
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

            RecipesDisplayer.DisplayRecipes(data, index, arr_length, scanner);
        }

    }

}