package interface_adapter.saved_recipes;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SavedRecipesViewModel extends ViewModel {
    public final String viewName = "Saved Recipes View";
    private SavedRecipesState state = new SavedRecipesState();
    public SavedRecipesViewModel(){super("Saved Recipes View");}
    public SavedRecipesState getState(){return state;}
    public void setState(SavedRecipesState state){this.state=state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged(){support.firePropertyChange("state", null, this.state);}
    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }
}
