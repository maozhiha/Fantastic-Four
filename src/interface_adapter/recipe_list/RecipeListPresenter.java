package interface_adapter.recipe_list;

import interface_adapter.ViewManagerModel;
import use_case.recipe_list.RecipeListOutputBoundary;
import view.SearchFormView;

public class RecipeListPresenter implements RecipeListOutputBoundary {

    private final ViewManagerModel viewManagerModel;

    public RecipeListPresenter(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    public void goBackToSearchForm() {
        viewManagerModel.setActiveView(SearchFormView.viewName);
        viewManagerModel.firePropertyChanged();
    }
}
