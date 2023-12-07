package use_case.saved_recipes;

import entity.Recipe;
import data_access.SaveRecipeFileDataAccessObject;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SavedRecipesInteractor implements SavedRecipesInputBoundary{
    final SavedRecipesOutputBoundary savedRecipesPresentor;
    final SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject;
    public SavedRecipesInteractor(SavedRecipesOutputBoundary savedRecipesPresentor, SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject){
        this.savedRecipesPresentor = savedRecipesPresentor;
        this.saveRecipeFileDataAccessObject = saveRecipeFileDataAccessObject;
    }

    public void goBackToLoggedIn(){savedRecipesPresentor.goBackToLoggedIn();}

    public void displayRecipes(String username){
        List<String> recipeIds = saveRecipeFileDataAccessObject.getSavedRecipesForUser(username);
        List<IdCurrRecipeCls> recipeObjs = new ArrayList<>();


        for (String recipeId: recipeIds){
            IdUrlCls idUrlCls = new IdUrlCls(recipeId);
            String url = idUrlCls.getUrl();
            IdDataCls idDataCls = new IdDataCls(url);
            JSONObject data = idDataCls.getData();
            IdCurrRecipeCls idCurrRecipeCls = new IdCurrRecipeCls(data);
            recipeObjs.add(idCurrRecipeCls);

        }

        savedRecipesPresentor.goToSavedRecipes(recipeObjs);

    }
}
