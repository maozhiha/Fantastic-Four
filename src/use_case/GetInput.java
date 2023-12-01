package use_case;

import interface_adapter.*;
import org.json.*;

public class GetInput {

    public static void searchRecipes(){
            //String keyWord, String dietLabels, String healthLabels, String mealType, String dishType, String cuisineType) {
        // Retrieve data from the controller
        String keyWord = Controller.getKeywords();
        String dietLabels = Controller.getDietSubString();
        String healthLabels = Controller.getHealthSubString();
        String mealType = Controller.getMealTypeSubString();
        String dishType = Controller.getDishSubString();
        String cuisineType = Controller.getCuisineSubString();
        System.out.println(keyWord);
        System.out.println(mealType);
        System.out.println(cuisineType);

        JSONObject data = null;
        boolean success = false;
        int index = 0;
        keyWord = keyWord.replaceAll("(?i) and ", "+");
        keyWord = keyWord.replaceAll("(?i) or ", ",");
        while (!success) {
            SearchCls SearchKeyword = new SearchCls(keyWord); //save keywords
            FilterCls FilterCriteria = new FilterCls(dietLabels, healthLabels, mealType, dishType, cuisineType); //save filter

            UrlCls UrlClass = new UrlCls(SearchKeyword, FilterCriteria); //pass keywords and filter into urlcls
            String Url = UrlClass.getUrl(); //get url
            System.out.println(Url);

            DataCls dataClass = new DataCls(Url);//pass url into datacl to get data
            data = dataClass.getData(); //get data
            int arr_length = dataClass.getArraylength(); //get how many recipes
            //System.out.print(arr_length);

            if (arr_length > 0) {
                success = true;
            } else {
                //System.out.println("no recipe was found according to your selected criteria");
                //System.out.println("");
                //System.out.print("");
                return;
            }
            Controller.setResultData(data, index, arr_length);
            System.out.println("11111");
            //RecipesDisplayer recipesDisplayer = new RecipesDisplayer();
            //System.out.println("222222");
            RecipesDisplayer.DisplayRecipes();
            //System.out.println("333333");
            //RecipesDisplayer.DisplayRecipes(data, index, arr_length, scanner);
        }

    }
    public static void getChoice(String input){

    }

}