package interface_adapter.recipe_list;

import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentViewModel;
import use_case.recipe_list.RecipeListOutputBoundary;
import view.SearchFormView;

public class RecipeListPresenter implements RecipeListOutputBoundary {

    private final ViewManagerModel viewManagerModel;

    private final CommentViewModel commentViewModel;

    public RecipeListPresenter(ViewManagerModel viewManagerModel, CommentViewModel commentViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.commentViewModel = commentViewModel;
    }

    public void goBackToSearchForm() {
        viewManagerModel.setActiveView(SearchFormView.viewName);
        viewManagerModel.firePropertyChanged();
    }
}
