package app;

import data_access.CommentFileDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import interface_adapter.search_form.SearchFormViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.Before;
import org.junit.Test;
import view.*;

public class TestUseCaseFactory {

    ViewManagerModel viewManagerModel;
    CommentViewModel commentViewModel;
    LoginViewModel loginViewModel;
    LoggedInViewModel loggedInViewModel;
    SearchFormViewModel searchFormViewModel;
    RecipeListViewModel recipeListViewModel;
    RecipeDetailViewModel recipeDetailViewModel;
    SignupViewModel singupViewModel;

    CommentFileDataAccessObject commentFileDataAccessObject;


    public TestUseCaseFactory() {
        this.viewManagerModel = new ViewManagerModel();
        this.commentViewModel = new CommentViewModel();
        this.loginViewModel = new LoginViewModel();
        this.loggedInViewModel = new LoggedInViewModel();
        this.searchFormViewModel = new SearchFormViewModel();
        this.recipeListViewModel = new RecipeListViewModel();
        this.recipeDetailViewModel = new RecipeDetailViewModel();
        this.singupViewModel = new SignupViewModel();
    }

    @Test
    public void testCommentUseCaseFactory() {
        CommentView commentView = CommentUseCaseFactory.create(viewManagerModel, recipeDetailViewModel, commentViewModel, loggedInViewModel, null);
        assert (commentView.viewName).equals("Comment View");
    }

    @Test
    public void testLoggedInUseCaseFactory() {
        LoggedInView loggedInView = LoggedInUseCaseFactory.createLoggedInView(viewManagerModel, loginViewModel, loggedInViewModel, searchFormViewModel);
        assert (loggedInView.viewName).equals("logged in");
    }

    @Test
    public void testLoginUseCaseFactory() {
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, null, null, null);
        assert (loginView.viewName).equals("log in");
    }

    @Test
    public void testRecipeDetailUseCaseFactory() {
        RecipeDetailView recipeDetailView = RecipeDetailUseCaseFactory.createRecipeDetailView(viewManagerModel, recipeListViewModel, recipeDetailViewModel, commentViewModel, null, null, loggedInViewModel);
        assert (recipeDetailView.viewName).equals("Recipe Detail View");
    }

    @Test
    public void testRecipeListUseCaseFactory() {
        RecipeListView recipeListView = RecipeListUseCaseFactory.createRecipeView(viewManagerModel, recipeListViewModel, recipeDetailViewModel, null);
        assert (recipeListView.viewName).equals("Recipe List View");
    }

    @Test
    public void testSearchFormUseCaseFactory() {
        SearchFormView searchFormView = SearchFormUseCaseFactory.create(viewManagerModel, searchFormViewModel, recipeListViewModel, loggedInViewModel);
        assert (searchFormView.viewName).equals("Search Form View");
    }

}
