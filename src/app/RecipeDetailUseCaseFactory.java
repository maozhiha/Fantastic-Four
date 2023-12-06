package app;

import data_access.CommentFileDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.recipe_detail.RecipeDetailController;
import interface_adapter.recipe_detail.RecipeDetailPresenter;
import interface_adapter.recipe_list.RecipeListViewModel;
import interface_adapter.save_recipe.SaveRecipeController;
import use_case.recipe_detail.RecipeDetailInputBoundary;
import use_case.recipe_detail.RecipeDetailInteractor;
import use_case.recipe_detail.RecipeDetailOutputBoundary;
import view.RecipeDetailView;

public class RecipeDetailUseCaseFactory {

    private RecipeDetailUseCaseFactory() {
    }

    public static RecipeDetailView createRecipeDetailView(ViewManagerModel viewManagerModel, RecipeListViewModel recipeListViewModel, interface_adapter.recipe_detail.RecipeDetailViewModel recipeDetailViewModel, CommentViewModel commentViewModel, CommentFileDataAccessObject commentFileDataAccessObject, SaveRecipeController saveRecipeController) {
        RecipeDetailController recipeDetailController = createRecipeDetailController(viewManagerModel, recipeListViewModel, recipeDetailViewModel, commentViewModel, commentFileDataAccessObject);

        return new RecipeDetailView(recipeDetailController, recipeDetailViewModel, saveRecipeController);
    }

    private static RecipeDetailController createRecipeDetailController(ViewManagerModel viewManagerModel, RecipeListViewModel recipeListViewModel, interface_adapter.recipe_detail.RecipeDetailViewModel recipeDetailViewModel, CommentViewModel commentViewModel, CommentFileDataAccessObject commentFileDataAccessObject) {
        RecipeDetailOutputBoundary recipeDetailOutputBoundary = new RecipeDetailPresenter(viewManagerModel, recipeListViewModel, recipeDetailViewModel, commentViewModel);
        RecipeDetailInputBoundary recipeDetailInputBoundary = new RecipeDetailInteractor(recipeDetailOutputBoundary, commentFileDataAccessObject);

        return new RecipeDetailController(recipeDetailInputBoundary);
    }

}
