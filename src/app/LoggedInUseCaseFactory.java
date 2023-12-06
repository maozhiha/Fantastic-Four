package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInController;
import interface_adapter.logged_in.LoggedInPresenter;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.search_form.SearchFormViewModel;
import use_case.logged_in.LoggedInInputBoundary;
import use_case.logged_in.LoggedInInteractor;
import use_case.logged_in.LoggedInOutputBoundary;
import view.LoggedInView;

public class LoggedInUseCaseFactory {

    public static LoggedInView createLoggedInView(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, LoggedInViewModel loggedInViewModel, SearchFormViewModel searchFormViewModel) {
        LoggedInController loggedInController = createLoggedInController(viewManagerModel, loginViewModel, loggedInViewModel, searchFormViewModel );

        return new LoggedInView(loggedInViewModel, loggedInController);
    }

    public static LoggedInController createLoggedInController(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, LoggedInViewModel loggedInViewModel, SearchFormViewModel searchFormViewModel) {
        LoggedInOutputBoundary loggedInOutputBoundary = new LoggedInPresenter(viewManagerModel, loginViewModel, loggedInViewModel, searchFormViewModel);
        LoggedInInputBoundary loggedInInputBoundary = new LoggedInInteractor(loggedInOutputBoundary);

        return new LoggedInController(loggedInInputBoundary);
    }
}
