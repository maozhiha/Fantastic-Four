package use_case.comment;

public class CommentInteractor implements ICommentInputBoundary {
    private final ICommentOutputBoundary outputBoundary;
    private final CommentDataAccessInterface commentDao;

    public CommentInteractor(ICommentOutputBoundary outputBoundary, CommentDataAccessInterface commentDao) {
        this.outputBoundary = outputBoundary;
        this.commentDao = commentDao;
    }

    @Override
    public void addComment(CommentInputData inputData) {
        // Convert inputData to Comment entity and add logic
        CommentOutputData outputData = new CommentOutputData();
        // Set output data based on operation results
        outputBoundary.presentComment(outputData);
    }

    // Other methods as needed
}
