package entity.Comment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Comments {

    public Comments() {
    }

    private String id;
    private String title;
    private List<Comment> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getCommentsInBase64() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String commentsAsJson = objectMapper.writeValueAsString(comments);

        // Encode comments as base64
        return java.util.Base64.getEncoder().encodeToString(commentsAsJson.getBytes());
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
