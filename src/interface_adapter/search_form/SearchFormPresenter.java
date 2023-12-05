package interface_adapter.search_form;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import use_case.search.SearchFormOutputBoundary;
import use_case.search.SearchFormOutputData;

public class SearchFormPresenter implements SearchFormOutputBoundary {

    //TODO: Navigate to result page(RecipeListView)

    private final ViewManagerModel viewManagerModel;

    private final SearchFormViewModel searchFormViewModel;

    private final RecipeListViewModel recipeListViewModel;


    public SearchFormPresenter(ViewManagerModel viewManagerModel, SearchFormViewModel searchFormViewModel, RecipeListViewModel recipeListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchFormViewModel = searchFormViewModel;
        this.recipeListViewModel = recipeListViewModel;
    }

    @Override
    public void prepareSuccessView(SearchFormOutputData result) {
        SearchFormState searchFormState = searchFormViewModel.getState();
        searchFormState.setSearchResult(result.getData());
        searchFormState.setArr_length(result.getArr_length());

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
    }
}
