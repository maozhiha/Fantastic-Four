package use_case.recipe_detail;

import data_access.CommentFileDataAccessObject;
import entity.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.recipe_detail.RecipeDetailPresenter;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestRecipeDetail {
    RecipeDetailInputBoundary recipeDetailInputBoundary;
    RecipeDetailOutputBoundary recipeDetailOutputBoundary;

    ViewManagerModel viewManagerModel = new ViewManagerModel();
    RecipeListViewModel recipeListViewModel = new RecipeListViewModel();
    RecipeDetailViewModel recipeDetailViewModel =   new RecipeDetailViewModel();
    CommentViewModel commentViewModel = new CommentViewModel();


    CommentFileDataAccessObject commentFileDataAccessObject;
    public TestRecipeDetail() throws IOException {
        commentFileDataAccessObject = new CommentFileDataAccessObject("test_comments.csv");
        recipeDetailOutputBoundary = new RecipeDetailPresenter( viewManagerModel, recipeListViewModel, recipeDetailViewModel, commentViewModel);
        recipeDetailInputBoundary = new RecipeDetailInteractor(recipeDetailOutputBoundary, commentFileDataAccessObject);
    }

    @Test
    public void testComment() throws IOException {
        Recipe recipe = new Recipe();
        recipe.setUri("http://test.recipe");
        recipe.setLabel("test recipe");
        RecipeDetailInputData recipeDetailInputData = new RecipeDetailInputData(recipe);
        recipeDetailInputBoundary.comment(recipeDetailInputData);
    }

    @Test
    public void testGoBackToRecipeListView() throws IOException {
        recipeDetailInputBoundary.goBackToRecipeListView();
    }

    @After
    public void tearDown() throws Exception {
        File csvFile = new File("test_comments.csv");
        csvFile.delete();
    }
}
