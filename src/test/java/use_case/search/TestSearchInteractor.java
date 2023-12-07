package use_case.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import interface_adapter.search_form.SearchFormPresenter;
import interface_adapter.search_form.SearchFormViewModel;
import org.junit.Test;

public class TestSearchInteractor {
    SearchFormInputBoundary searchFormInputBoundary;
    SearchFormOutputBoundary searchFormOutputBoundary;

    ViewManagerModel viewManagerModel = new ViewManagerModel();
    RecipeListViewModel recipeListViewModel = new RecipeListViewModel();
    LoggedInViewModel loggedInViewModel =   new LoggedInViewModel();
    SearchFormViewModel searchFormViewModel = new SearchFormViewModel();


    public TestSearchInteractor() {
        searchFormOutputBoundary = new SearchFormPresenter( viewManagerModel,searchFormViewModel, recipeListViewModel, loggedInViewModel);
        searchFormInputBoundary = new SearchFormInteractor(searchFormOutputBoundary);
    }

    @Test
    public void testSearch() {
        SearchFormInputData searchFormInputData = new SearchFormInputData("pizza","","","","","");
        searchFormInputBoundary.execute(searchFormInputData);
    }

    @Test
    public void testGoBackToLoggedInView() {
        searchFormInputBoundary.goBackToLoggedInView();
    }
}
