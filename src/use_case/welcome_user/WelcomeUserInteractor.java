package use_case.welcome_user;


public class WelcomeUserInteractor implements WelcomeUserInputBoundary {

//    private WeclomeUserDataAccessInterface dataAccess;

    private WelcomeuserOutputBoundary outputBoundary;


    public WelcomeUserInteractor(WelcomeuserOutputBoundary outputBoundary) {
//        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }
}
