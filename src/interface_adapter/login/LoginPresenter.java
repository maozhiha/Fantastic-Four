package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

import javax.swing.*;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final SignupViewModel signupViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    // Flag to determine if the successful operation was a signup
    private boolean isSignupSuccess;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel,
                          SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
        this.isSignupSuccess = false; // Initialize the flag
    }
    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(response.getUsername());
        loggedInState.setLoggedIn(true);

        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

//    public void setIsSignupSuccess(boolean isSignupSuccess) {
//        this.isSignupSuccess = isSignupSuccess;
//    }

//    @Override
//    public void prepareSuccessView(LoginOutputData response) {
//        if (isSignupSuccess) {
//            // Logic to switch to the signup view
//            // Example:
//            SignupState signupState = signupViewModel.getState();
//            signupState.setUsername(response.getUsername());
//            this.signupViewModel.setState(signupState);
//            signupViewModel.firePropertyChanged();
//
//            this.viewManagerModel.setActiveView(signupViewModel.getViewName());
//        } else {
//            // Logic to switch to the logged-in view
//            LoggedInState loggedInState = loggedInViewModel.getState();
//            loggedInState.setUsername(response.getUsername());
//            this.loggedInViewModel.setState(loggedInState);
//            this.loggedInViewModel.firePropertyChanged();
//
//            this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
//        }
//        this.viewManagerModel.firePropertyChanged();
//    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
