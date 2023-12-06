package use_case.comment;

import data_access.CommentFileDataAccessObject;
import entity.Comment.Comment;
import entity.Comment.Comments;

public class CommentInteractor implements CommentInputBoundary{


    final CommentOutputBoundary commentPresenter;
    final CommentFileDataAccessObject commentFileDataAccessObject;


    public CommentInteractor(CommentOutputBoundary commentPresenter, CommentFileDataAccessObject commentFileDataAccessObject) {
        this.commentPresenter = commentPresenter;
        this.commentFileDataAccessObject = commentFileDataAccessObject;
    }

    public void loadComment() {
    }

    public void addNewComment(CommentInputData commentInputData) {
        Comments comments = commentInputData.getComments();
        String user = commentInputData.getUser();
        String newComment = commentInputData.getNewComment();

        comments.addComment(new Comment(user, newComment));

        commentFileDataAccessObject.saveComments(comments);
        CommentOutputData commentOutputData = new CommentOutputData(comments);

        commentPresenter.prepareSuccessView(commentOutputData);
    }

    @Override
    public void goBackToRecipeDetail() {
        commentPresenter.goBackToRecipeDetail();
    }
}
