package use_case.save_recipe;

public class SaveRecipeInputData {
    private final String userId;
    private final String recipeId;

    public SaveRecipeInputData(String userId, String recipeId){
        this.userId = userId;
        this.recipeId = recipeId;
    }

    public String getUserId(){
        return userId;
    }

    public String getRecipeId(){
        return recipeId;
    }
}
