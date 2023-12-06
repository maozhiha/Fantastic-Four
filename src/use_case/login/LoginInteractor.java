package use_case.login;

import entity.User;
import entity.UserFactory;

import java.time.LocalDateTime;

public class LoginInteractor implements LoginInputBoundary {
    final LoginUserDataAccessInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    final UserFactory userFactory;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary, UserFactory userFactory) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String pwd = userDataAccessObject.get(username).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                User user = userDataAccessObject.get(loginInputData.getUsername());

                LoginOutputData loginOutputData = new LoginOutputData(user.getName(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }

    @Override
    public void signUp(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            LocalDateTime now = LocalDateTime.now();
            User user = userFactory.create(loginInputData.getUsername(), loginInputData.getPassword(), now);
            userDataAccessObject.save(user);

            LoginOutputData loginOutputData = new LoginOutputData(user.getName(), false);
            loginPresenter.prepareSuccessView(loginOutputData);
            // Prepare View
        } else {
            loginPresenter.prepareFailView("User already exists.");
        }
    }
}