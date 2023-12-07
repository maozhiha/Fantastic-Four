package use_case.recipe_list;

import entity.Comment.Comments;
import entity.Recipe;

public class RecipeListOutputData {

    Recipe recipe;

    public RecipeListOutputData(Recipe recipe, String title, String id, Comments comments) {
        this.recipe = recipe;
        this.title = title;
        this.id = id;
        this.comments = comments;
    }

    String title;
    String id;
    Comments comments;


    public Comments getComments() {
        return comments;
    }

    public Recipe getRecipe() {
        return recipe;
    }

}
