package useraccount;

import fantastticfour.src.main.java.interface_adapter.signup.SignupController;
import fantastticfour.src.main.java.interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class signupview {
}


class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final SignupController signupController;

    private final JButton signUp;
    private final JButton cancel;
    private final JButton clear;

    public SignupView(SignupViewModel signupViewModel, SignupController signupController, JButton signUp, JButton cancel, JButton clear) {
        this.signupViewModel = signupViewModel;
        this.signupController = signupController;
        this.signUp = signUp;
        this.cancel = cancel;
        this.clear = clear;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
