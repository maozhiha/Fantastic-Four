package use_case.signup;

import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestSignUp {
    SignupInputBoundary signupInputBoundary;
    SignupOutputBoundary signupOutputBoundary;

    SignupUserDataAccessInterface signupUserDataAccessInterface;

    ViewManagerModel viewManagerModel = new ViewManagerModel();

    SignupViewModel signupViewModel = new SignupViewModel();

    LoginViewModel loginViewModel = new LoginViewModel();

    public TestSignUp() throws IOException {
        UserFactory userFactory = new CommonUserFactory();
        signupUserDataAccessInterface = new FileUserDataAccessObject("test_users.csv", userFactory);
        signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        signupInputBoundary = new SignupInteractor(signupUserDataAccessInterface, signupOutputBoundary, userFactory);
    }

    @Test
    public void testSignup() {
        SignupInputData signupInputData = new SignupInputData("test", "test", "test");
        signupInputBoundary.execute(signupInputData);
    }

    @After
    public void tearDown() throws Exception {
        File file = new File("test_users.csv");
        file.delete();
    }
}
