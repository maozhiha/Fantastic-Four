package app;
import data_access.FileUserDataAccessObject;
import data_access.CommentFileDataAccessObject;
import data_access.SaveRecipeFileDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import interface_adapter.save_recipe.SaveRecipeController;
import interface_adapter.saved_recipes.SavedRecipesViewModel;
import interface_adapter.search_form.SearchFormViewModel;
import interface_adapter.signup.SignupViewModel;
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
//        WelcomeUserViewModel welcomeUserViewModel = new WelcomeUserViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();

        SearchFormViewModel searchFormViewModel = new SearchFormViewModel();
        RecipeListViewModel recipeListViewModel = new RecipeListViewModel();
        RecipeDetailViewModel recipeDetailViewModel = new RecipeDetailViewModel();
        CommentViewModel commentViewModel = new CommentViewModel();
        SavedRecipesViewModel savedRecipesViewModel = new SavedRecipesViewModel();

        CommentFileDataAccessObject commentDataAccessObject;
        SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject;
        try {
            commentDataAccessObject = new CommentFileDataAccessObject("./comments.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
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
        //ExampleView exampleView = WelcomeUserUseCaseFactory.create(welcomeUserViewModel);
        SearchFormView searchFormView = SearchFormUseCaseFactory.create(viewManagerModel,searchFormViewModel, recipeListViewModel, loggedInViewModel);
        RecipeListView recipeListView = RecipeListUseCaseFactory.createRecipeView(viewManagerModel, recipeListViewModel,recipeDetailViewModel, commentDataAccessObject);
        //RecipeDetailView recipeDetailView = RecipeDetailUseCaseFactory.createRecipeDetailView(viewManagerModel, recipeListViewModel, recipeDetailViewModel, commentViewModel, commentDataAccessObject);
        CommentView commentView = CommentUseCaseFactory.create(viewManagerModel, recipeDetailViewModel, commentViewModel, loggedInViewModel,  commentDataAccessObject);
        SignupView signupView = SignupUseCaseFactory.create(clearViewModel, viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        RecipeDetailView recipeDetailView = RecipeDetailUseCaseFactory.createRecipeDetailView(viewManagerModel, recipeListViewModel, recipeDetailViewModel, commentViewModel, commentDataAccessObject, saveRecipeController, loggedInViewModel);
        //CommentView commentView = CommentUseCaseFactory.create(viewManagerModel, recipeDetailViewModel, commentViewModel, commentDataAccessObject);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject, signupViewModel, signupView );
        views.add(loginView, loginView.viewName);


        //views.add(exampleView, exampleView.viewName);
        LoggedInView loggedInView = LoggedInUseCaseFactory.createLoggedInView(viewManagerModel, loginViewModel, loggedInViewModel, searchFormViewModel, savedRecipesViewModel);
        views.add(loggedInView, loggedInView.viewName);

        SavedRecipesView savedRecipesView = SavedRecipesUseCaseFactory.create(viewManagerModel, loggedInViewModel, savedRecipesViewModel, saveRecipeFileDataAccessObject);
        views.add(savedRecipesView, savedRecipesView.viewName);


        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();


//        views.add(exampleView, exampleView.viewName);
        views.add(searchFormView, searchFormView.viewName);
        views.add(recipeListView, recipeListView.viewName);
        views.add(recipeDetailView, recipeDetailView.viewName);
        views.add(commentView, commentView.viewName);



        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}