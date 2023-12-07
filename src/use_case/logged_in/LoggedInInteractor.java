package use_case.logged_in;

public class LoggedInInteractor implements LoggedInInputBoundary {

    private final LoggedInOutputBoundary loggedInPresenter;

    public LoggedInInteractor(LoggedInOutputBoundary loggedInPresenter) {
        this.loggedInPresenter = loggedInPresenter;
    }

    @Override
    public void logOut() {
        loggedInPresenter.logOut();
    }

    @Override
    public void goToSearch() {
        loggedInPresenter.goToSearch();
    }
    public void goToSavedRecipes(){loggedInPresenter.goToSavedRecipes();}
}
