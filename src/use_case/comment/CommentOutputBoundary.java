package use_case.comment;

import use_case.search.SearchFormOutputData;

public interface CommentOutputBoundary {
    void prepareSuccessView(CommentOutputData result);
}
