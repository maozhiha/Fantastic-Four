package interface_adapter.comment;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import interface_adapter.search_form.SearchFormViewModel;
import use_case.comment.CommentOutputBoundary;
import use_case.comment.CommentOutputData;

public class CommentPresenter implements CommentOutputBoundary {

    private final ViewManagerModel viewManagerModel;

    private final RecipeListViewModel recipeListViewModel;
    private final CommentViewModel commentViewModel;

    public CommentPresenter(ViewManagerModel viewManagerModel, RecipeListViewModel recipeListViewModel, CommentViewModel commentViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recipeListViewModel = recipeListViewModel;
        this.commentViewModel = commentViewModel;
    }

    @Override
    public void prepareSuccessView(CommentOutputData result) {

        CommentState state = commentViewModel.getState();

        state.setComments(result.getComments());

        commentViewModel.setState(state);
        commentViewModel.firePropertyChanged();
    }

    @Override
    public void goBackToRecipeList() {
        viewManagerModel.setActiveView(recipeListViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
