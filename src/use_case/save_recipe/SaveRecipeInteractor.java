package use_case.save_recipe;

import data_access.SaveRecipeFileDataAccessObject;

public class SaveRecipeInteractor implements SaveRecipeInputBoundary {
    private final SaveRecipeOutputBoundary saveRecipePresenter;
    private final SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject;

    public SaveRecipeInteractor(SaveRecipeOutputBoundary saveRecipePresenter, SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject) {
        this.saveRecipePresenter = saveRecipePresenter;
        this.saveRecipeFileDataAccessObject = saveRecipeFileDataAccessObject;
    }

    public void saveRecipe(SaveRecipeInputData saveRecipeInputData) {
        String userId = saveRecipeInputData.getUserId();
        String recipeId = saveRecipeInputData.getRecipeId();
        saveRecipeFileDataAccessObject.saveRecipeForUser(userId, recipeId);
        boolean isRecipeSaved = true;
        SaveRecipeOutputData saveRecipeOutputData = new SaveRecipeOutputData(isRecipeSaved);
        saveRecipePresenter.presentSaveRecipeResult(saveRecipeOutputData);
    }

}
