package use_case.saved_recipes;

import entity.Recipe;
import data_access.SaveRecipeFileDataAccessObject;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SavedRecipesInteractor implements SavedRecipesInputBoundary{
    final SavedRecipesOutputBoundary savedRecipesPresenter;
    final SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject;
    public SavedRecipesInteractor(SavedRecipesOutputBoundary savedRecipesPresentor, SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject){
        this.savedRecipesPresenter = savedRecipesPresentor;
        this.saveRecipeFileDataAccessObject = saveRecipeFileDataAccessObject;
    }

    public void goBackToLoggedIn(){savedRecipesPresenter.goBackToLoggedIn();}

    public void displayRecipes(String username){
        List<String> recipeIds = saveRecipeFileDataAccessObject.getSavedRecipesForUser(username);
        List<IdCurrRecipeCls> recipeObjs = new ArrayList<>();

        if (recipeIds.isEmpty()){
            System.out.println(username+"'s recipeIds is empty");
        }
        else{
            for (String id:recipeIds){
                System.out.println(id);
            }
        }
        for (String recipeId: recipeIds){
            IdUrlCls idUrlCls = new IdUrlCls(recipeId);
            String url = idUrlCls.getUrl();
            IdDataCls idDataCls = new IdDataCls(url);
            JSONObject data = idDataCls.getData();
            IdCurrRecipeCls idCurrRecipeCls = new IdCurrRecipeCls(data);
            recipeObjs.add(idCurrRecipeCls);
            System.out.println(recipeId);
            System.out.println(url);
            System.out.println(idCurrRecipeCls.currRecipeLabel);
        }

        savedRecipesPresenter.goToSavedRecipes(recipeObjs);

    }
}
