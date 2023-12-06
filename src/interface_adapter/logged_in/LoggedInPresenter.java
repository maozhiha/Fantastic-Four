package interface_adapter.logged_in;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.search_form.SearchFormViewModel;
import use_case.logged_in.LoggedInOutputBoundary;

public class LoggedInPresenter implements LoggedInOutputBoundary {

    private final ViewManagerModel viewManagerModel;

    private final LoginViewModel loginViewModel;

    private final LoggedInViewModel loggedInViewModel;

    private final SearchFormViewModel searchFormViewModel;

    public LoggedInPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, LoggedInViewModel loggedInViewModel, SearchFormViewModel searchFormViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.searchFormViewModel = searchFormViewModel;
    }

    @Override
    public void logOut() {
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setLoggedIn(false);
        loggedInState.setUsername("");

        viewManagerModel.setActiveView(loginViewModel.viewName);
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void goToSearch() {
        viewManagerModel.setActiveView(searchFormViewModel.viewName);
        viewManagerModel.firePropertyChanged();
    }
}
