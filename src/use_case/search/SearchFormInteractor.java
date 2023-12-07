package use_case.search;

import org.json.JSONObject;

public class SearchFormInteractor implements SearchFormInputBoundary{

    final SearchFormOutputBoundary searchFormPresenter;

    public SearchFormInteractor(SearchFormOutputBoundary searchFormPresenter) {
        this.searchFormPresenter = searchFormPresenter;
    }

    @Override
    public void execute(SearchFormInputData searchFormInputData) {
        // TODO Auto-generated method stub
        String keyWord = searchFormInputData.getKeywords();
        String dietLabels = searchFormInputData.getDietSubString();
        String healthLabels = searchFormInputData.getHealthSubString();
        String mealType = searchFormInputData.getMealTypeSubString();
        String dishType = searchFormInputData.getDishSubString();
        String cuisineType = searchFormInputData.getCuisineSubString();

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
                System.out.println("no recipe was found according to your selected criteria");
                //System.out.println("");
                //System.out.print("");
                searchFormPresenter.prepareErrorView("no recipe was found according to your selected criteria");
                return;
            }

            SearchFormOutputData searchFormOutputData = new SearchFormOutputData(data, arr_length);
            searchFormPresenter.prepareSuccessView(searchFormOutputData);


//
//            SearchFormController.setResultData(data, index, arr_length);
//            //System.out.println("11111");
//            //RecipesDisplayer recipesDisplayer = new RecipesDisplayer();
//            //System.out.println("222222");
//            RecipesDisplayer.DisplayRecipes();
//            //System.out.println("333333");
//            //RecipesDisplayer.DisplayRecipes(data, index, arr_length, scanner);
        }
    }

    @Override
    public void goBackToLoggedInView() {
        // TODO Auto-generated method stub
        searchFormPresenter.goBackToLoggedInView();
    }
}
