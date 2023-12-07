package interface_adapter.search_form;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchFormViewModel extends ViewModel {

    public final String viewName = "Search Form View";

    public static final String[] dietSelection = {"balanced",
            "high-fiber",
            "high-protein",
            "low-carb",
            "low-fat",
            "low-sodium"};

    public static final String[] healthSelection = {"alcohol-cocktail","alcohol-free","celery-free","crustacean-free","dairy-free","DASH","egg-free","fish-free","fodmap-free","gluten-free","immuno-supportive","keto-friendly","kidney-friendly","kosher","low-fat-abs","low-potassium","low-sugar","lupine-free","Mediterranean","mollusk-free","mustard-free","no-oil-added","paleo","peanut-free","pescatarian","pork-free","red-meat-free","sesame-free","shellfish-free","soy-free","sugar-conscious","sulfite-free","tree-nut-free","vegan","vegetarian","wheat-free"};

    public static final String[] mealTypeSelection = {"breakfast","brunch","lunch/dinner","snack","teatime"};

    public static final String[] dishTypeSelection = {"alcohol cocktail", "biscuits and cookies", "bread", "cereals", "condiments and sauces", "desserts", "drinks", "egg", "ice cream and custard", "main course", "pancake", "pasta", "pastry", "pies and tarts", "pizza", "preps", "preserve", "salad", "sandwiches", "seafood", "side dish", "soup", "special occasions", "starter", "sweets"};

    public static final String[] cuisineTypeSelection = {"american", "asian", "british", "caribbean", "central europe", "chinese", "eastern europe", "french", "greek", "indian", "italian", "japanese", "korean", "kosher", "mediterranean", "mexican", "middle eastern", "nordic", "south american", "south east asian", "world"};



    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SearchFormState getState() {
        return state;
    }

    public void setState(SearchFormState state) {
        this.state = state;
    }

    private SearchFormState state = new SearchFormState();

    public SearchFormViewModel() {
        super("Search Form View");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
