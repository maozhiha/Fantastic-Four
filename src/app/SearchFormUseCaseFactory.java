package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_list.RecipeListViewModel;
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

    public static SearchFormView create(ViewManagerModel viewManagerModel,SearchFormViewModel searchFormViewModel, RecipeListViewModel recipeListViewModel) {
        SearchFormController searchFormController = createSearchFormController(viewManagerModel, searchFormViewModel, recipeListViewModel);

        return new SearchFormView(searchFormViewModel, searchFormController);
    }

    public static SearchFormController createSearchFormController(ViewManagerModel viewManagerModel, SearchFormViewModel searchFormViewModel, RecipeListViewModel recipeListViewModel){
        SearchFormOutputBoundary searchFormOutputBoundary = new SearchFormPresenter(viewManagerModel, searchFormViewModel, recipeListViewModel);
        SearchFormInputBoundary searchFormInputBoundary = new SearchFormInteractor(searchFormOutputBoundary);

        return new SearchFormController(searchFormInputBoundary);
    }
}
