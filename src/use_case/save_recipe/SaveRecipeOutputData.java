package use_case.save_recipe;

public class SaveRecipeOutputData {
    private final boolean isRecipeSaved;
    public SaveRecipeOutputData(boolean isRecipeSaved){
        this.isRecipeSaved = isRecipeSaved;
    }
    public boolean isRecipeSaved(){
        return isRecipeSaved;
    }
}
