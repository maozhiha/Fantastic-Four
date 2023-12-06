package interface_adapter.recipe_detail;

import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentState;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import use_case.recipe_detail.RecipeDetailOutputBoundary;
import use_case.recipe_list.RecipeListOutputData;

public class RecipeDetailPresenter implements RecipeDetailOutputBoundary {
    private final ViewManagerModel viewManagerModel;

    private final CommentViewModel commentViewModel;

    private final RecipeListViewModel recipeListViewModel;

    private final RecipeDetailViewModel recipeDetailViewModel;

    public RecipeDetailPresenter(ViewManagerModel viewManagerModel, RecipeListViewModel recipeListViewModel, RecipeDetailViewModel recipeDetailViewModel, CommentViewModel commentViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recipeListViewModel = recipeListViewModel;
        this.commentViewModel = commentViewModel;
        this.recipeDetailViewModel = recipeDetailViewModel;
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

    @Override
    public void goBackToRecipeListView() {
        viewManagerModel.setActiveView(recipeListViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
