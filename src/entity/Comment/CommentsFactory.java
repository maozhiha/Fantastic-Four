package entity.Comment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CommentsFactory {

    public static Comments createNewComments(String id, String title) {
        Comments comments = new Comments();
        comments.setId(id);
        comments.setTitle(title);
        comments.setComments(new ArrayList<>());
        return comments;
    }

    public static Comments createCommentsFromCsvString(String id, String title, String commentsInBase64) {

        Comments comments = new Comments();
        comments.setId(id);
        comments.setTitle(title);
        ObjectMapper objectMapper = new ObjectMapper();

        // Decode stored comments from base64 into json
        byte[] decodedBytes = Base64.getDecoder().decode(commentsInBase64);
        String decodedString = new String(decodedBytes);

        try {
            List<Comment> listOfComment = objectMapper.readValue(decodedString, new TypeReference<List<Comment>>() {});
            // Accessing deserialized List of Comment objects
            comments.setComments(listOfComment);
        }catch (IOException e){
            e.printStackTrace();
        }

        return comments;
    }
}
