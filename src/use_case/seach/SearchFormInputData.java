package use_case.seach;

public class SearchFormInputData {
    private String keywords;
    private String dietSubString;
    private String healthSubString;
    private String mealTypeSubString;
    private String dishSubString;
    private String cuisineSubString;

    public SearchFormInputData(String keywords, String dietSubString, String healthSubString, String mealTypeSubString, String dishSubString, String cuisineSubString) {
        this.keywords = keywords;
        this.dietSubString = dietSubString;
        this.healthSubString = healthSubString;
        this.mealTypeSubString = mealTypeSubString;
        this.dishSubString = dishSubString;
        this.cuisineSubString = cuisineSubString;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getDietSubString() {
        return dietSubString;
    }

    public String getHealthSubString() {
        return healthSubString;
    }

    public String getMealTypeSubString() {
        return mealTypeSubString;
    }

    public String getDishSubString() {
        return dishSubString;
    }

    public String getCuisineSubString() {
        return cuisineSubString;
    }
}
