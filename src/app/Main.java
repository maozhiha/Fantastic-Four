package app;
import data_access.FileUserDataAccessObject;
import data_access.CommentFileDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.comment.CommentViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.recipe_list.RecipeListViewModel;
import interface_adapter.search_form.SearchFormViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.weclome_user.WelcomeUserViewModel;
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
        interface_adapter.recipe_detail.RecipeDetailViewModel recipeDetailViewModel = new interface_adapter.recipe_detail.RecipeDetailViewModel();
        CommentViewModel commentViewModel = new CommentViewModel();

        CommentFileDataAccessObject commentDataAccessObject;
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

        //
//        ExampleView exampleView = WelcomeUserUseCaseFactory.create(welcomeUserViewModel);
        SearchFormView searchFormView = SearchFormUseCaseFactory.create(viewManagerModel,searchFormViewModel, recipeListViewModel);
        RecipeListView recipeListView = RecipeListUseCaseFactory.createRecipeView(viewManagerModel, recipeListViewModel,recipeDetailViewModel, commentDataAccessObject);
        RecipeDetailView recipeDetailView = RecipeDetailUseCaseFactory.createRecipeDetailView(viewManagerModel, recipeListViewModel, recipeDetailViewModel, commentViewModel, commentDataAccessObject);
        CommentView commentView = CommentUseCaseFactory.create(viewManagerModel, recipeDetailViewModel, commentViewModel, commentDataAccessObject);
        SignupView signupView = SignupUseCaseFactory.create(clearViewModel, viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject, userDataAccessObject);
        views.add(signupView, signupView.viewName);


        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject, signupViewModel, signupView );
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
        views.add(loggedInView, loggedInView.viewName);


        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();


//        views.add(exampleView, exampleView.viewName);
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