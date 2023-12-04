package interface_adapter.search_form;

import interface_adapter.ViewManagerModel;
import use_case.seach.SearchFormOutputBoundary;
import use_case.seach.SearchFormOutputData;

public class SearchFormPresenter implements SearchFormOutputBoundary {

    //TODO: Navigate to result page(RecipeListView)

    private final ViewManagerModel viewManagerModel;

    // private final ReipeListViewModel reipeListViewModel;


    public SearchFormPresenter(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(SearchFormOutputData result) {
        System.out.println("Got result from SearchFormInteractor");
//        System.out.println(result.getData().toString());
    }

    @Override
    public void prepareErrorView(String errorMessage) {
        System.out.println("No result from SearchFormInteractor");
    }
}
