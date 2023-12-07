package data_access;

import entity.Comment.Comment;
import entity.Comment.Comments;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TestCommentFileDataAccessObject {
    @Test
    public void testCreateCsv() throws IOException {
        // Create a new file called "test_comment.csv" in the root directory of the project.
        File csvFile = new File("test_comment.csv");

        CommentFileDataAccessObject commentFileDataAccessObject = new CommentFileDataAccessObject("test_comment.csv");

        // Assert that the file exists.
        assert csvFile.exists();

        // Delete the file after the test is done.
        csvFile.delete();
    }

    @Test
    public void testSaveComment() throws IOException {
        // Create a new file called "test_comment.csv" in the root directory of the project.
        File csvFile = new File("test_comment.csv");

        CommentFileDataAccessObject commentFileDataAccessObject = new CommentFileDataAccessObject("test_comment.csv");

        Comments comments = new Comments();
        comments.setId("test");
        comments.setTitle("test");
        comments.setComments(new ArrayList<>());
        comments.addComment(new Comment("testuser", "hello"));

        commentFileDataAccessObject.saveComments(comments);

        // Assert that the file exists.
        assert csvFile.exists();

        // Delete the file after the test is done.
        csvFile.delete();
    }

    @Test
    public void testFindById() throws IOException {
        // Create a new file called "test_comment.csv" in the root directory of the project.
        File csvFile = new File("test_comment.csv");

        CommentFileDataAccessObject commentFileDataAccessObject = new CommentFileDataAccessObject("test_comment.csv");

        Comments comments = new Comments();
        comments.setId("test");
        comments.setTitle("test");
        comments.setComments(new ArrayList<>());
        comments.addComment(new Comment("testuser", "hello"));

        commentFileDataAccessObject.saveComments(comments);

        commentFileDataAccessObject.findById("test");

        assert commentFileDataAccessObject.existsById("test");

        // Assert that the file exists.
        assert csvFile.exists();

        // Delete the file after the test is done.
        csvFile.delete();
    }
}
