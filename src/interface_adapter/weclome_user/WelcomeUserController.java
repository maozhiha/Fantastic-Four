package interface_adapter.weclome_user;

import use_case.welcome_user.WelcomeUserInputBoundary;

public class WelcomeUserController {
    final WelcomeUserInputBoundary welcomeUserUseCaseInteractor;

    public WelcomeUserController(WelcomeUserInputBoundary welcomeUserUseCaseInteractor) {
        this.welcomeUserUseCaseInteractor = welcomeUserUseCaseInteractor;
    }
}
