package interface_adapter.recipe_list;

import interface_adapter.ViewModel;
import interface_adapter.search_form.SearchFormState;
import view.SearchFormView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RecipeListViewModel extends ViewModel {

    private SearchFormState state;

    public SearchFormState getState() {
        return state;
    }

    public void setState(SearchFormState state) {
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

    public RecipeListViewModel() {
        super("Recipe List View");
    }


}
