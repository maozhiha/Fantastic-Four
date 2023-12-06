package interface_adapter.recipe_detail;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RecipeDetailViewModel extends ViewModel {

    private RecipeDetailState state = new RecipeDetailState();

    public RecipeDetailViewModel() {
        super("Recipe Detail View");
    }

    public RecipeDetailState getState() {
        return state;
    }

    public void setState(RecipeDetailState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
