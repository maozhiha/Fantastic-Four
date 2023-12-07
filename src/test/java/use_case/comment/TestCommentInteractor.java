package use_case.comment;

import data_access.CommentFileDataAccessObject;
import entity.Comment.Comment;
import entity.Comment.Comments;
import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentPresenter;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TestCommentInteractor {

    CommentInputBoundary commentInteractor;
    CommentOutputBoundary commentPresenter;
    CommentFileDataAccessObject commentFileDataAccessObject;

    ViewManagerModel viewManagerModel = new ViewManagerModel();
    RecipeDetailViewModel recipeDetailViewModel = new RecipeDetailViewModel();

    CommentViewModel commentViewModel = new CommentViewModel();


    public TestCommentInteractor() throws IOException {
        File csvFile = new File("test_comment.csv");

        this.commentPresenter = new CommentPresenter(viewManagerModel,recipeDetailViewModel,commentViewModel);

        this.commentFileDataAccessObject = new CommentFileDataAccessObject("test_comment.csv");

        this.commentInteractor = new CommentInteractor(commentPresenter, commentFileDataAccessObject);
    }

    @Test
    public void testGoBack() throws IOException {
        commentInteractor.goBackToRecipeDetail();
    }

    @Test
    public void testAddNewComment() throws IOException {
        Comments comments = new Comments();
        comments.setId("test");
        comments.setTitle("testtest");
        comments.setComments(new ArrayList<>());
        comments.addComment(new Comment("testuser", "hello"));
        CommentInputData commentInputData = new CommentInputData(comments, "testuser", "hello");
        commentInteractor.addNewComment(commentInputData);
    }


    @After
    public void tearDown() throws Exception {
        File csvFile = new File("test_comment.csv");
        csvFile.delete();
    }
}
