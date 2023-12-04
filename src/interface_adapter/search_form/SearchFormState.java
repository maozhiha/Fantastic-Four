package interface_adapter.search_form;

public class SearchFormState {

    String keywords;
    String dietSubString;
    String healthSubString;
    String mealTypeSubString;
    String dishSubString;
    String cuisineSubString;



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
