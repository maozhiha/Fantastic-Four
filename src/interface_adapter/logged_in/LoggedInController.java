package interface_adapter.logged_in;

import use_case.logged_in.LoggedInInputBoundary;

public class LoggedInController {


    private final LoggedInInputBoundary loggedInInteractor;

    public LoggedInController(LoggedInInputBoundary loggedInInteractor) {
        this.loggedInInteractor = loggedInInteractor;
    }

    public void logOut() {
        loggedInInteractor.logOut();
    }

    public void goToSearch() {
        loggedInInteractor.goToSearch();
    }
}
