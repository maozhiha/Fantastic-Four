package interface_adapter.recipe_list;

import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentState;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.recipe_detail.RecipeDetailState;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import use_case.recipe_list.RecipeListOutputBoundary;
import use_case.recipe_list.RecipeListOutputData;
import view.SearchFormView;

public class RecipeListPresenter implements RecipeListOutputBoundary {

    private final ViewManagerModel viewManagerModel;


    private final RecipeDetailViewModel recipeDetailViewModel;

    public RecipeListPresenter(ViewManagerModel viewManagerModel, RecipeDetailViewModel recipeDetailViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recipeDetailViewModel = recipeDetailViewModel;
    }

    public void goBackToSearchForm() {
        viewManagerModel.setActiveView(SearchFormView.viewName);
        viewManagerModel.firePropertyChanged();
    }


    @Override
    public void displayRecipeDetail(RecipeListOutputData recipeListOutputData) {
        RecipeDetailState state = recipeDetailViewModel.getState();
        state.setRecipe(recipeListOutputData.getRecipe());

        recipeDetailViewModel.setState(state);
        recipeDetailViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(recipeDetailViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
