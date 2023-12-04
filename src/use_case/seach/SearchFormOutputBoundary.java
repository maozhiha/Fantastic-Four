package use_case.seach;

public interface SearchFormOutputBoundary {

    void prepareSuccessView(SearchFormOutputData result);

    void prepareErrorView(String errorMessage);
}
