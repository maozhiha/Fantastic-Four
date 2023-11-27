package fantastticfour.src.main.java.view;

import interface_adapter.weclome_user.WelcomeUserController;
import interface_adapter.weclome_user.WelcomeUserViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/*
This is an example view just to make sure CLEAN architecture is working
It has no real usage and can be deleted later
 */
public class ExampleView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Example View";

    private final WelcomeUserViewModel welcomeUserViewModel;

    private final WelcomeUserController welcomeUserController;

    private final JButton welcomeButton;


    public ExampleView(WelcomeUserViewModel welcomeUserViewModel, WelcomeUserController welcomeUserController) {
        this.welcomeUserViewModel = welcomeUserViewModel;
        this.welcomeUserController = welcomeUserController;

        welcomeUserViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(WelcomeUserViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        welcomeButton = new JButton(WelcomeUserViewModel.GREETING_BUTTON_LABEL);
        buttons.add(welcomeButton);

        welcomeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Button WeclomeButton is pressed");
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        return;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "not implemented yet.");
    }
}
