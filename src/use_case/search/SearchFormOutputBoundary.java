package use_case.search;

public interface SearchFormOutputBoundary {

    void prepareSuccessView(SearchFormOutputData result);

    void prepareErrorView(String errorMessage);
}
