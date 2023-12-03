package app;

import interface_adapter.weclome_user.WelcomeUserController;
import interface_adapter.weclome_user.WelcomeUserPresentor;
import interface_adapter.weclome_user.WelcomeUserViewModel;
import use_case.welcome_user.WelcomeUserInputBoundary;
import use_case.welcome_user.WelcomeUserInteractor;
import use_case.welcome_user.WelcomeuserOutputBoundary;
import view.ExampleView;

public class WelcomeUserUseCaseFactory {

    /** Prevent instantiation. */
    private WelcomeUserUseCaseFactory() {}

    public static ExampleView create(WelcomeUserViewModel welcomeUserViewModel){

        WelcomeUserController welcomeUserController = createWelcomeUserController();

        return new ExampleView(welcomeUserViewModel,welcomeUserController);
    }

    public static WelcomeUserController createWelcomeUserController(){
        WelcomeuserOutputBoundary welcomeuserOutputBoundary = new WelcomeUserPresentor();

        WelcomeUserInputBoundary weclomeUserInteractor = new WelcomeUserInteractor(welcomeuserOutputBoundary);

        return new WelcomeUserController(weclomeUserInteractor);
    }
}
