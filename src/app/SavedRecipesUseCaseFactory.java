package app;

import data_access.SaveRecipeFileDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.saved_recipes.SavedRecipesController;
import interface_adapter.saved_recipes.SavedRecipesPresenter;
import interface_adapter.saved_recipes.SavedRecipesViewModel;
import use_case.saved_recipes.SavedRecipesInputBoundary;
import use_case.saved_recipes.SavedRecipesOutputBoundary;
import use_case.saved_recipes.SavedRecipesInteractor;
import view.SavedRecipesView;

public class SavedRecipesUseCaseFactory {
    private SavedRecipesUseCaseFactory(){}

    public static SavedRecipesView create(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel, SavedRecipesViewModel savedRecipesViewModel, SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject){
        SavedRecipesController savedRecipesController = createSavedRecipesController(viewManagerModel, loggedInViewModel, savedRecipesViewModel, saveRecipeFileDataAccessObject);
        return new SavedRecipesView(savedRecipesController, savedRecipesViewModel, loggedInViewModel);
    }
    private static SavedRecipesController createSavedRecipesController(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel, SavedRecipesViewModel savedRecipesViewModel, SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject){
        SavedRecipesOutputBoundary savedRecipesOutputBoundary = new SavedRecipesPresenter(viewManagerModel, loggedInViewModel, savedRecipesViewModel);
        SavedRecipesInputBoundary savedRecipesInputBoundary = new SavedRecipesInteractor(savedRecipesOutputBoundary, saveRecipeFileDataAccessObject);
        return new SavedRecipesController(savedRecipesInputBoundary);
    }
}
