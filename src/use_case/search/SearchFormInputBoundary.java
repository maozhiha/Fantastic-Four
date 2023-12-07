package use_case.search;

public interface SearchFormInputBoundary {
    void execute(SearchFormInputData searchFormInputData);
    void goBackToLoggedInView();
}
