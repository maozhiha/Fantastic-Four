package view;

import entity.Recipe;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.recipe_detail.RecipeDetailController;
import interface_adapter.recipe_detail.RecipeDetailState;
import interface_adapter.recipe_detail.RecipeDetailViewModel;
import interface_adapter.save_recipe.SaveRecipeController;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class RecipeDetailView extends JPanel implements PropertyChangeListener {

    public final String viewName = "Recipe Detail View";

    private final RecipeDetailController recipeDetailController;
    private final RecipeDetailViewModel recipeDetailViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final SaveRecipeController saveRecipeController;


    private JLabel recipeTitle;

    private JTextPane recipeDetailPane;

    public RecipeDetailView(RecipeDetailController recipeDetailController, RecipeDetailViewModel recipeDetailViewModel, SaveRecipeController saveRecipeController, LoggedInViewModel loggedInViewModel) {
        this.recipeDetailController = recipeDetailController;
        this.saveRecipeController = saveRecipeController;
        this.recipeDetailViewModel = recipeDetailViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.recipeDetailViewModel.addPropertyChangeListener(this);

        this.setLayout(new BorderLayout());

        recipeTitle = new JLabel("Recipe Title");
        recipeTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        recipeTitle.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(recipeTitle, BorderLayout.NORTH);

        recipeDetailPane = new JTextPane();
        recipeDetailPane.setEditable(false);
        JScrollPane recipeDetailScrollPane = new JScrollPane(recipeDetailPane);
        this.add(recipeDetailScrollPane, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton comment = new JButton("Comment");
        JButton backButton = new JButton("Back");
        JButton saveButton = new JButton("Save");
        buttons.add(comment);
        buttons.add(backButton);
        buttons.add(saveButton);
        this.add(buttons, BorderLayout.SOUTH);

        comment.addActionListener(
                actionEvent -> {
                    RecipeDetailState state = recipeDetailViewModel.getState();
                    Recipe recipe = state.getRecipe();

                    recipeDetailController.comment(recipe);
                }
        );

        backButton.addActionListener(
                actionEvent -> {
                    recipeDetailController.goBackToRecipeListView();
                }
        );

        saveButton.addActionListener(
                actionEvent -> {
                    RecipeDetailState state = recipeDetailViewModel.getState();
                    Recipe recipe = state.getRecipe();
                    String recipeId = recipe.getId();
                    LoggedInState loggedInState = loggedInViewModel.getState();
                    String userName = loggedInState.getUsername();

                    boolean userConfirmed = showConfirmationDialog("Do you want to save this recipe?");
                    if (userConfirmed){
                        saveRecipeController.saveRecipe(userName, recipeId);
                        JOptionPane.showMessageDialog(null, "Recipe saved successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
        );
    }

    private boolean showConfirmationDialog(String message){
        int confirmation = JOptionPane.showConfirmDialog(null, message, "Save Confirmation", JOptionPane.YES_NO_OPTION);
        return confirmation == JOptionPane.YES_OPTION;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

        RecipeDetailState state = (RecipeDetailState) propertyChangeEvent.getNewValue();
        Recipe recipe = state.getRecipe();


        List<String> ingredientLines = recipe.getIngredientLines();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Recipe Name: %s\n", recipe.getLabel()));
        sb.append(String.format("Recipe URL: %s\n", recipe.getUri()));
        for (String ingredientLine : ingredientLines) {
            sb.append(ingredientLine);
            sb.append("\n");
        }
        recipeDetailPane.setText(sb.toString());
        recipeTitle.setText(recipe.getLabel());

    }
}
