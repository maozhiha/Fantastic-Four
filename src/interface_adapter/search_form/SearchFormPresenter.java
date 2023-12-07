package interface_adapter.search_form;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import use_case.search.SearchFormOutputBoundary;
import use_case.search.SearchFormOutputData;

public class SearchFormPresenter implements SearchFormOutputBoundary {

    //TODO: Navigate to result page(RecipeListView)

    private final ViewManagerModel viewManagerModel;

    private final SearchFormViewModel searchFormViewModel;

    private final RecipeListViewModel recipeListViewModel;

    private final LoggedInViewModel loggedInViewModel;


    public SearchFormPresenter(ViewManagerModel viewManagerModel, SearchFormViewModel searchFormViewModel, RecipeListViewModel recipeListViewModel, LoggedInViewModel loggedInViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchFormViewModel = searchFormViewModel;
        this.recipeListViewModel = recipeListViewModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView(SearchFormOutputData result) {
        SearchFormState searchFormState = searchFormViewModel.getState();
        searchFormState.setSearchResult(result.getData());
        searchFormState.setArr_length(result.getArr_length());
        searchFormState.setSearchResultEmpty(false);

        System.out.println("Got result from SearchFormInteractor");
//        System.out.println(result.getData().toString());

        recipeListViewModel.setState(searchFormState);
        recipeListViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(recipeListViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareErrorView(String errorMessage) {
        System.out.println("No result from SearchFormInteractor");
        SearchFormState searchFormState = searchFormViewModel.getState();
        searchFormState.setSearchResultEmpty(true);

        searchFormViewModel.setState(searchFormState);
        searchFormViewModel.firePropertyChanged();
    }

    @Override
    public void goBackToLoggedInView() {
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
