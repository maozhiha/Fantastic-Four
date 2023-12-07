package use_case.save_recipe;

import data_access.SaveRecipeFileDataAccessObject;

public class SaveRecipeInteractor implements SaveRecipeInputBoundary {
    private final SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject;

    public SaveRecipeInteractor(SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject) {
        this.saveRecipeFileDataAccessObject = saveRecipeFileDataAccessObject;
    }

    public void saveRecipe(SaveRecipeInputData saveRecipeInputData) {
        String userId = saveRecipeInputData.getUserId();
        String recipeId = saveRecipeInputData.getRecipeId();
        try{
            saveRecipeFileDataAccessObject.saveRecipeForUser(userId, recipeId);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("error in saving recipes");
        }
    }

}
