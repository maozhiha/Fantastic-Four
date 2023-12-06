package app;

import data_access.CommentFileDataAccessObject;
import data_access.SaveRecipeFileDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import interface_adapter.save_recipe.SaveRecipeController;
import interface_adapter.search_form.SearchFormViewModel;
import interface_adapter.weclome_user.WelcomeUserViewModel;
import use_case.save_recipe.SaveRecipeInputBoundary;
import use_case.save_recipe.SaveRecipeInteractor;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
        interface_adapter.recipe_detail.RecipeDetailViewModel recipeDetailViewModel = new interface_adapter.recipe_detail.RecipeDetailViewModel();
        CommentViewModel commentViewModel = new CommentViewModel();

        CommentFileDataAccessObject commentDataAccessObject;
        SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject;
        try {
            commentDataAccessObject = new CommentFileDataAccessObject("./comments.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            saveRecipeFileDataAccessObject = new SaveRecipeFileDataAccessObject("./saved_recipes.csv");
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        SaveRecipeInputBoundary saveRecipeInputBoundary = new SaveRecipeInteractor(saveRecipeFileDataAccessObject);
        SaveRecipeController saveRecipeController = new SaveRecipeController(saveRecipeInputBoundary);

        //
        ExampleView exampleView = WelcomeUserUseCaseFactory.create(welcomeUserViewModel);
        SearchFormView searchFormView = SearchFormUseCaseFactory.create(viewManagerModel,searchFormViewModel, recipeListViewModel);
        RecipeListView recipeListView = RecipeListUseCaseFactory.createRecipeView(viewManagerModel, recipeListViewModel,recipeDetailViewModel, commentDataAccessObject);
        RecipeDetailView recipeDetailView = RecipeDetailUseCaseFactory.createRecipeDetailView(viewManagerModel, recipeListViewModel, recipeDetailViewModel, commentViewModel, commentDataAccessObject, saveRecipeController);
        CommentView commentView = CommentUseCaseFactory.create(viewManagerModel, recipeDetailViewModel, commentViewModel, commentDataAccessObject);



        views.add(exampleView, exampleView.viewName);
        views.add(searchFormView, searchFormView.viewName);
        views.add(recipeListView, recipeListView.viewName);
        views.add(recipeDetailView, recipeDetailView.viewName);
        views.add(commentView, commentView.viewName);


        viewManagerModel.setActiveView(searchFormView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}