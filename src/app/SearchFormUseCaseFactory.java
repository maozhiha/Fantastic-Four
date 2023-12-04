package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_form.SearchFormController;
import interface_adapter.search_form.SearchFormPresenter;
import interface_adapter.search_form.SearchFormViewModel;
import use_case.search.SearchFormInputBoundary;
import use_case.search.SearchFormInteractor;
import use_case.search.SearchFormOutputBoundary;
import view.SearchFormView;

public class SearchFormUseCaseFactory {

    private SearchFormUseCaseFactory() {
    }

    public static SearchFormView create(ViewManagerModel viewManagerModel,SearchFormViewModel searchFormViewModel) {
        SearchFormController searchFormController = createSearchFormController(viewManagerModel);

        return new SearchFormView(searchFormViewModel, searchFormController);
    }

    public static SearchFormController createSearchFormController(ViewManagerModel viewManagerModel){
        SearchFormOutputBoundary searchFormOutputBoundary = new SearchFormPresenter(viewManagerModel);
        SearchFormInputBoundary searchFormInputBoundary = new SearchFormInteractor(searchFormOutputBoundary);

        return new SearchFormController(searchFormInputBoundary);
    }
}
