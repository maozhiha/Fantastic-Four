package interface_adapter;

import org.json.*;
import java.util.ArrayList;

public class Controller {
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
        Controller.index = index;
    }
    public static void setUserChoice(String choice) {
        Controller.userChoice = choice;
    }
    public static String getUserChoice() {
        return userChoice;
    }
    public static void setRecipeList(String hit){
        Controller.hit = hit;
        Controller.hitsArray.add(hit);
    }
    public static void setResultData(JSONObject data, int index, int arr_length){
        Controller.data = data;
        Controller.index = index;
        Controller.arr_length = arr_length;
    }
    public static void setSearchData(String keywords, String diet, String health, String mealType, String dish, String cuisine) {
        Controller.keywords = keywords;
        Controller.dietSubString = diet;
        Controller.healthSubString = health;
        Controller.mealTypeSubString = mealType;
        Controller.dishSubString = dish;
        Controller.cuisineSubString = cuisine;
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
}

