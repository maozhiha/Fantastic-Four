package fantastticfour.src.main.java.interface_adapter.login;

import fantastticfour.src.main.java.use_case.login.LoginInputBoundary;
import fantastticfour.src.main.java.use_case.login.LoginInputData;

public class LoginController {

    final LoginInputBoundary loginUseCaseInteractor;
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }


    public void execute(String username, String password) {
        LoginInputData loginInputData = new LoginInputData(
                username, password);

        loginUseCaseInteractor.execute(loginInputData);
    }
}
