package app;

import data_access.CommentFileDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_list.RecipeListController;
import interface_adapter.recipe_list.RecipeListPresenter;
import interface_adapter.recipe_list.RecipeListViewModel;
import use_case.recipe_list.RecipeListInputBoundary;
import use_case.recipe_list.RecipeListInteractor;
import use_case.recipe_list.RecipeListOutputBoundary;
import view.RecipeListView;

public class RecipeListUseCaseFactory {
    private RecipeListUseCaseFactory() {
    }

    public static RecipeListView createRecipeView(ViewManagerModel viewManagerModel, RecipeListViewModel recipeListViewModel, interface_adapter.recipe_detail.RecipeDetailViewModel recipeDetailViewModel, CommentFileDataAccessObject commentFileDataAccessObject) {
        RecipeListController recipeListController = createRecipeListController(viewManagerModel, recipeListViewModel,recipeDetailViewModel, commentFileDataAccessObject);

        return new RecipeListView(recipeListController, recipeListViewModel);
    }

    public static RecipeListController createRecipeListController(ViewManagerModel viewManagerModel, RecipeListViewModel recipeListViewModel, interface_adapter.recipe_detail.RecipeDetailViewModel recipeDetailViewModel, CommentFileDataAccessObject commentFileDataAccessObject) {
        RecipeListOutputBoundary recipeListOutputBoundary = new RecipeListPresenter(viewManagerModel, recipeDetailViewModel);
        RecipeListInputBoundary recipeListInputBoundary = new RecipeListInteractor(recipeListOutputBoundary, commentFileDataAccessObject);

        return new RecipeListController(recipeListInputBoundary);
    }
}
