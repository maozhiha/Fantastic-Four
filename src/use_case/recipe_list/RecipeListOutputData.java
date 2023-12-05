package use_case.recipe_list;

import entity.Comment.Comments;

public class RecipeListOutputData {
    String title;
    String id;
    Comments comments;

    public RecipeListOutputData(String title, String id, Comments comments) {
        this.title = title;
        this.id = id;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public Comments getComments() {
        return comments;
    }
}
