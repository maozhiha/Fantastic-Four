package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.weclome_user.WelcomeUserViewModel;
import fantastticfour.src.main.java.view.ExampleView;
import fantastticfour.src.main.java.view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // Create Main application window
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

        //
        ExampleView exampleView = WelcomeUserUseCaseFactory.create(welcomeUserViewModel);
        views.add(exampleView, exampleView.viewName);

        viewManagerModel.setActiveView(exampleView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}