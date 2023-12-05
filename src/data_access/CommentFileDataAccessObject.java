package data_access;

import entity.Comment.Comment;
import entity.Comment.Comments;
import entity.Comment.CommentsFactory;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommentFileDataAccessObject {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Comments> commentsMap = new HashMap<>();

    public CommentFileDataAccessObject(String csvPath) throws IOException {
        csvFile = new File(csvPath);
        headers.put("id", 0);
        headers.put("title", 1);
        headers.put("comments", 2);

        if (csvFile.length() == 0) {
            // If csvFile is empty, create a new file with the headers.
            save();
        }else{
            // Otherwise, read existing comment from csv file
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("id,title,comments");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String id = String.valueOf(col[headers.get("id")]);
                    String title = String.valueOf(col[headers.get("title")]);
                    String commentsInBase64 = String.valueOf(col[headers.get("comments")]);
                    Comments comments = CommentsFactory.createCommentsFromCsvString(id, title, commentsInBase64);
                    commentsMap.put(id, comments);
                }
            }
        }
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Comments comments : commentsMap.values()) {
                String line = String.format("%s,%s,%s",
                        comments.getId(), comments.getTitle(), comments.getCommentsInBase64());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveComments(Comments comments) {
        commentsMap.put(comments.getId(), comments);
        save();
    }

    public boolean existsById(String id) {
        return commentsMap.containsKey(id);
    }

    public Comments findById(String id) {
        return commentsMap.get(id);
    }
}
