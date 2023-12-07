package use_case.recipe_list;

import data_access.CommentFileDataAccessObject;
import entity.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import interface_adapter.recipe_list.RecipeListPresenter;
import interface_adapter.recipe_list.RecipeListViewModel;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestRecipeListInteractor {

    RecipeListInputBoundary recipeListInputBoundary;
    RecipeListOutputBoundary recipeListOutputBoundary;

    ViewManagerModel viewManagerModel = new ViewManagerModel();
    RecipeListViewModel recipeListViewModel = new RecipeListViewModel();
    RecipeDetailViewModel recipeDetailViewModel =   new RecipeDetailViewModel();
    CommentViewModel commentViewModel = new CommentViewModel();


    CommentFileDataAccessObject commentFileDataAccessObject;

    public TestRecipeListInteractor() throws IOException {
        commentFileDataAccessObject = new CommentFileDataAccessObject("test_comments.csv");
        recipeListOutputBoundary = new RecipeListPresenter( viewManagerModel, recipeDetailViewModel);
        recipeListInputBoundary = new RecipeListInteractor(recipeListOutputBoundary, commentFileDataAccessObject);
    }

    @Test
    public void testGoBack() throws IOException {
        recipeListInputBoundary.goBack();
    }

    @Test
    public void testDisplayRecipe() throws IOException {
        Recipe recipe = new Recipe();
        recipe.setUri("http://test.recipe");
        recipe.setLabel("test recipe");
        RecipeListInputData recipeListInputData = new RecipeListInputData(recipe);
        recipeListInputBoundary.displayRecipe(recipeListInputData);
    }

    @After
    public void tearDown() throws Exception {
        File csvFile = new File("test_comments.csv");
        csvFile.delete();
    }
}
