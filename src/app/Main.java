package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import interface_adapter.search_form.SearchFormViewModel;
import interface_adapter.weclome_user.WelcomeUserViewModel;
import view.ExampleView;
import view.RecipeListView;
import view.SearchFormView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // Create use_case.seach.Main application window
        JFrame application = new JFrame("Fantastic Four");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        //
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        //
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // Create View Model First
        // Before creating new view, we need to create their view model
        WelcomeUserViewModel welcomeUserViewModel = new WelcomeUserViewModel();
        SearchFormViewModel searchFormViewModel = new SearchFormViewModel();
        RecipeListViewModel recipeListViewModel = new RecipeListViewModel();

        //
        ExampleView exampleView = WelcomeUserUseCaseFactory.create(welcomeUserViewModel);
        SearchFormView searchFormView = SearchFormUseCaseFactory.create(viewManagerModel,searchFormViewModel, recipeListViewModel);
        RecipeListView recipeListView = RecipeListUseCaseFactory.createRecipeView(viewManagerModel, recipeListViewModel);

        views.add(exampleView, exampleView.viewName);
        views.add(searchFormView, searchFormView.viewName);
        views.add(recipeListView, recipeListView.viewName);

        viewManagerModel.setActiveView(searchFormView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}