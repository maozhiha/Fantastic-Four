package use_case.logged_in;

import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.logged_in.LoggedInPresenter;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import interface_adapter.search_form.SearchFormViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.Test;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;

public class TestLoggedInInteractor {

    LoggedInInputBoundary logedInInteractor;

    LoggedInOutputBoundary loggedInPresenter;

    ViewManagerModel viewManagerModel = new ViewManagerModel();
    RecipeDetailViewModel recipeDetailViewModel = new RecipeDetailViewModel();

    CommentViewModel commentViewModel = new CommentViewModel();

    LoggedInViewModel loggedInViewModel = new LoggedInViewModel();

    SearchFormViewModel searchFormViewModel = new SearchFormViewModel();

    LoginViewModel loginViewModel = new LoginViewModel();
    SignupViewModel signupViewModel = new SignupViewModel();

    LoginUserDataAccessInterface loginUserDataAccessInterface;

    public TestLoggedInInteractor() {
        this.loggedInPresenter = new LoggedInPresenter(viewManagerModel, loginViewModel, loggedInViewModel, searchFormViewModel);
        this.logedInInteractor = new LoggedInInteractor(loggedInPresenter);
    }

    @Test
    public void testLogOut() {
        logedInInteractor.logOut();
    }

    @Test
    public void goToSearch() {
        logedInInteractor.goToSearch();
    }
}
