package use_case.login;

import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestLoginInteractor {

    LoginInputBoundary loginInteractor;

    LoginOutputBoundary loginOutputBoundary;

    ViewManagerModel viewManagerModel = new ViewManagerModel();
    RecipeDetailViewModel recipeDetailViewModel = new RecipeDetailViewModel();

    CommentViewModel commentViewModel = new CommentViewModel();

    LoggedInViewModel loggedInViewModel = new LoggedInViewModel();

    LoginViewModel loginViewModel = new LoginViewModel();
    SignupViewModel signupViewModel = new SignupViewModel();

    LoginUserDataAccessInterface loginUserDataAccessInterface;

    public TestLoginInteractor() throws IOException {
        UserFactory userFactory = new CommonUserFactory();
        loginUserDataAccessInterface = new FileUserDataAccessObject("test_login.csv", userFactory);
        this.loginOutputBoundary = new LoginPresenter( viewManagerModel, loggedInViewModel, loginViewModel, signupViewModel);
        this.loginInteractor = new LoginInteractor(loginUserDataAccessInterface, loginOutputBoundary, userFactory);
    }

    @Test
    public void testSignup() throws IOException {
        LoginInputData loginInputData = new LoginInputData("testuser", "testpassword");
        loginInteractor.signUp(loginInputData);
    }

    @Test
    public void testLogin() throws IOException {
        LoginInputData loginInputData = new LoginInputData("testuser", "testpassword");
        loginInteractor.signUp(loginInputData);
        loginInteractor.execute(loginInputData);
    }

    @Test
    public void testExistUserSingin() throws IOException {
        LoginInputData loginInputData = new LoginInputData("testuser", "testpassword");
        loginInteractor.signUp(loginInputData);
        loginInteractor.signUp(loginInputData);
    }

    @Test
    public void testSigninToANotExistUser() throws IOException {
        LoginInputData loginInputData = new LoginInputData("testuser", "testpassword");
        loginInteractor.execute(loginInputData);
    }

    @Test
    public void testSinginWithWrongPassword() throws IOException {
        LoginInputData loginInputData = new LoginInputData("testuser", "testpassword");
        loginInteractor.signUp(loginInputData);
        loginInputData = new LoginInputData("testuser", "wrongpassword");
        loginInteractor.execute(loginInputData);
    }

    @After
    public void tearDown() throws Exception {
        // Delete test_login.csv
        File csvFile = new File("test_login.csv");
        csvFile.delete();
    }
}
