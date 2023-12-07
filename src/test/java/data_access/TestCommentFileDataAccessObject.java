package data_access;

import entity.Comment.Comment;
import org.junit.Test;

import java.io.IOException;

public class TestCommentFileDataAccessObject {
    @Test
    public void testSave() throws IOException {
        CommentFileDataAccessObject commentFileDataAccessObject = new CommentFileDataAccessObject("test_comment.csv");

    }
}
