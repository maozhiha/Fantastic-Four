package interface_adapter.comment;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import use_case.comment.CommentOutputBoundary;
import use_case.comment.CommentOutputData;

public class CommentPresenter implements CommentOutputBoundary {

    private final ViewManagerModel viewManagerModel;

    private final RecipeDetailViewModel recipeDetailViewModel;
    private final CommentViewModel commentViewModel;

    public CommentPresenter(ViewManagerModel viewManagerModel, RecipeDetailViewModel recipeDetailViewModel, CommentViewModel commentViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recipeDetailViewModel = recipeDetailViewModel;
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
    public void goBackToRecipeDetail() {
        viewManagerModel.setActiveView(recipeDetailViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
