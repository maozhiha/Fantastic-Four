package use_case.login;

public interface LoginInputBoundary {
    void execute(LoginInputData loginInputData);

    void signUp(LoginInputData loginInputData);
}
