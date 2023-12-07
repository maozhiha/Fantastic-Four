package interface_adapter.saved_recipes;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.saved_recipes.IdCurrRecipeCls;
import use_case.saved_recipes.SavedRecipesOutputBoundary;
import use_case.saved_recipes.SavedRecipesOutputData;

import java.util.List;

public class SavedRecipesPresenter implements SavedRecipesOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LoggedInViewModel loggedInViewModel;
    private final SavedRecipesViewModel savedRecipesViewModel;
    public SavedRecipesPresenter(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel, SavedRecipesViewModel savedRecipesViewModel){
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.savedRecipesViewModel = savedRecipesViewModel;
    }

    public void goBackToLoggedIn(){
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    public void goToSavedRecipes(List<IdCurrRecipeCls> recipes){

        viewManagerModel.setActiveView(savedRecipesViewModel.viewName);
        viewManagerModel.firePropertyChanged();

    }
}
