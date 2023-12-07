package view;

import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.saved_recipes.SavedRecipesController;
import interface_adapter.saved_recipes.SavedRecipesState;
import interface_adapter.saved_recipes.SavedRecipesViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.json.JSONArray;
import java.util.*;



import use_case.saved_recipes.IdCurrRecipeCls;

import java.util.List;

public class SavedRecipesView extends JPanel implements PropertyChangeListener {
    public final String viewName = "Saved Recipes View";
    private final SavedRecipesController savedRecipesController;
    private final SavedRecipesViewModel savedRecipesViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private JLabel title;
    private JTextPane recipesPane;

    public SavedRecipesView(SavedRecipesController savedRecipesController, SavedRecipesViewModel savedRecipesViewModel, LoggedInViewModel loggedInViewModel){
        this.savedRecipesController = savedRecipesController;
        this.savedRecipesViewModel = savedRecipesViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.savedRecipesViewModel.addPropertyChangeListener(this);

        this.setLayout(new BorderLayout());
        title = new JLabel("Saved Recipes");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);
        recipesPane = new JTextPane();
        recipesPane.setEditable(false);
        JScrollPane recipesScrollablePane = new JScrollPane(recipesPane);
        this.add(recipesScrollablePane, BorderLayout.CENTER);
        JButton backButton = new JButton("Back");
        this.add(backButton, BorderLayout.SOUTH);

        LoggedInState loggedInState = loggedInViewModel.getState();
        String username = loggedInState.getUsername();
        savedRecipesController.displayRecipes(username);

        backButton.addActionListener(
                actionEvent -> {
                    savedRecipesController.goBackToLoggedIn();
                }
        );

    }

    public void propertyChange(PropertyChangeEvent propertyChangeEvent){
        SavedRecipesState state = (SavedRecipesState) propertyChangeEvent.getNewValue();
        List<IdCurrRecipeCls> recipes = state.getRecipes();
        StringBuilder totalSb = new StringBuilder();

        for (IdCurrRecipeCls recipe: recipes){
            List<String> ingredientLines = jsonArrayToList(recipe.getingredientsLine());
            String uri = recipe.getcurrRecipeUrl();
            StringBuilder sb = new StringBuilder();
            sb.append(recipe.getcurrRecipeLabel());
            sb.append("\nIngredients:\n");
            for (String ingredientLine: ingredientLines){
                sb.append(ingredientLine);
                sb.append("\n");
            }
            sb.append("uri for this recipe: ");
            sb.append(uri);
            sb.append("\n\n");
            String recipeItem = sb.toString();
            totalSb.append(recipeItem);
        }
        recipesPane.setText(totalSb.toString());
    }

    private static List<String> jsonArrayToList(JSONArray jsonArray) {
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            // Assuming elements are strings; adjust this if elements can have other types
            String element = jsonArray.getString(i);
            stringList.add(element);
        }

        return stringList;
    }

}
