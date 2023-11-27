package fantastticfour.src.main.java.use_case.welcome_user;

import use_case.welcome_user.WelcomeUserInputBoundary;
import use_case.welcome_user.WelcomeuserOutputBoundary;


public class WelcomeUserInteractor implements WelcomeUserInputBoundary {

//    private WeclomeUserDataAccessInterface dataAccess;

    private WelcomeuserOutputBoundary outputBoundary;


    public WelcomeUserInteractor(WelcomeuserOutputBoundary outputBoundary) {
//        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }
}
