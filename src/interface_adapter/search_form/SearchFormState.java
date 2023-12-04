package interface_adapter.search_form;

import org.json.JSONObject;

public class SearchFormState {

    private String keywords;
    private String dietSubString;
    private String healthSubString;
    private String mealTypeSubString;
    private String dishSubString;
    private String cuisineSubString;

    private JSONObject searchResult;

    private int arr_length;

    public JSONObject getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(JSONObject searchResult) {
        this.searchResult = searchResult;
    }

    public int getArr_length() {
        return arr_length;
    }

    public void setArr_length(int arr_length) {
        this.arr_length = arr_length;
    }

    public SearchFormState() {
        this.keywords = "";
        this.dietSubString = "";
        this.healthSubString = "";
        this.mealTypeSubString = "";
        this.dishSubString = "";
        this.cuisineSubString = "";
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDietSubString() {
        return dietSubString;
    }

    public void setDietSubString(String dietSubString) {
        this.dietSubString = dietSubString;
    }

    public String getHealthSubString() {
        return healthSubString;
    }

    public void setHealthSubString(String healthSubString) {
        this.healthSubString = healthSubString;
    }

    public String getMealTypeSubString() {
        return mealTypeSubString;
    }

    public void setMealTypeSubString(String mealTypeSubString) {
        this.mealTypeSubString = mealTypeSubString;
    }

    public String getDishSubString() {
        return dishSubString;
    }

    public void setDishSubString(String dishSubString) {
        this.dishSubString = dishSubString;
    }

    public String getCuisineSubString() {
        return cuisineSubString;
    }

    public void setCuisineSubString(String cuisineSubString) {
        this.cuisineSubString = cuisineSubString;
    }
}
