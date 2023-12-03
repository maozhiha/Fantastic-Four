package interface_adapter.weclome_user;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class WelcomeUserViewModel extends ViewModel {


    public static final String TITLE_LABEL = "Fantastic Four";
    public static final String GREETING_BUTTON_LABEL = "Hello";


    public WelcomeUserViewModel() {
        super("Welcome User");
    }

    @Override
    public void firePropertyChanged() {
        return;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        return;
    }
}
