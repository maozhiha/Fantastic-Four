package interface_adapter.recipe_list;

import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentState;
import interface_adapter.comment.CommentViewModel;
import use_case.recipe_list.RecipeListOutputBoundary;
import use_case.recipe_list.RecipeListOutputData;
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

    @Override
    public void displayComment(RecipeListOutputData recipeListOutputData) {
        CommentState state = commentViewModel.getState();
        state.setComments(recipeListOutputData.getComments());

        commentViewModel.setState(state);
        commentViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(commentViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
