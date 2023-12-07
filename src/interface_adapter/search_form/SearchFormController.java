package interface_adapter.search_form;

import org.json.*;
import use_case.search.SearchFormInputBoundary;
import use_case.search.SearchFormInputData;

import java.util.ArrayList;

public class SearchFormController {

    final SearchFormInputBoundary searchFormUseCaseInteractor;

    public SearchFormController(SearchFormInputBoundary searchFormUseCaseInteractor) {
        this.searchFormUseCaseInteractor = searchFormUseCaseInteractor;
    }

    private static String keywords;
    private static String dietSubString;
    private static String healthSubString;
    private static String mealTypeSubString;
    private static String dishSubString;
    private static String cuisineSubString;
    private static String userChoice;
    private static JSONObject data;
    private static int index;
    private static int arr_length;
    private static String hit;
    private static ArrayList<String> hitsArray = new ArrayList<>();
    public static void setindex(int index){
        SearchFormController.index = index;
    }
    public static void setUserChoice(String choice) {
        SearchFormController.userChoice = choice;
    }
    public static String getUserChoice() {
        return userChoice;
    }
    public static void setRecipeList(String hit){
        SearchFormController.hit = hit;
        SearchFormController.hitsArray.add(hit);
    }
    public static void setResultData(JSONObject data, int index, int arr_length){
        SearchFormController.data = data;
        SearchFormController.index = index;
        SearchFormController.arr_length = arr_length;
    }
    public static void setSearchData(String keywords, String diet, String health, String mealType, String dish, String cuisine) {
        SearchFormController.keywords = keywords;
        SearchFormController.dietSubString = diet;
        SearchFormController.healthSubString = health;
        SearchFormController.mealTypeSubString = mealType;
        SearchFormController.dishSubString = dish;
        SearchFormController.cuisineSubString = cuisine;
    }

    public static String getKeywords() {
        return keywords;
    }

    public static String getDietSubString() {
        return dietSubString;
    }

    public static String getHealthSubString() {
        return healthSubString;
    }

    public static String getMealTypeSubString(){
        return mealTypeSubString;
    }
    public static String getDishSubString(){
        return dishSubString;
    }

    public static String getCuisineSubString() {
        return cuisineSubString;
    }

    public static JSONObject getRecipeData() {
        return data;
    }

    public static int getArrLength() {
        return arr_length;
    }

    public static int getIndex() {
        return index;
    }
    public static ArrayList<String> gethit(){
        //for(int i=0; i<10; i++){
         //   return hitsArray.get(i);
        //}
        return hitsArray;
    }

    public void execute(String keywords, String diet, String health, String mealType, String dish, String cuisine) {
        SearchFormInputData searchFormInputData = new SearchFormInputData(
                keywords, diet, health, mealType, dish, cuisine);

        searchFormUseCaseInteractor.execute(searchFormInputData);
    }

    public void goBackToLoggedInView() {
        searchFormUseCaseInteractor.goBackToLoggedInView();
    }
}

