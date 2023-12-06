package view;

import entity.Recipe;
import interface_adapter.recipe_detail.RecipeDetailController;
import interface_adapter.recipe_detail.RecipeDetailState;
import interface_adapter.recipe_detail.RecipeDetailViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class RecipeDetailView extends JPanel implements PropertyChangeListener {

    public final String viewName = "Recipe Detail View";


    private final RecipeDetailController recipeDetailController;
    private final RecipeDetailViewModel recipeDetailViewModel;


    private JLabel recipeTitle;

    private JTextPane recipeDetailPane;

    public RecipeDetailView(RecipeDetailController recipeDetailController, RecipeDetailViewModel recipeDetailViewModel) {
        this.recipeDetailController = recipeDetailController;
        this.recipeDetailViewModel = recipeDetailViewModel;
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
        buttons.add(comment);
        buttons.add(backButton);
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
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        RecipeDetailState state = (RecipeDetailState) propertyChangeEvent.getNewValue();
        Recipe recipe = state.getRecipe();


        List<String> ingredientLines = recipe.getIngredientLines();

        StringBuilder sb = new StringBuilder();
        for (String ingredientLine : ingredientLines) {
            sb.append(ingredientLine);
            sb.append("\n");
        }

        recipeDetailPane.setText(sb.toString());
        recipeTitle.setText(recipe.getLabel());
    }
}
