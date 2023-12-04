package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RecipeListView extends JPanel {
    public final String viewName = "Recipe List View";

    public RecipeListView() {
        JLabel title = new JLabel("Recipe List View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(new BorderLayout());

        this.add(title, BorderLayout.NORTH);

        JList<String> recipeList = new JList<String>(new String[]{"Recipe 1", "Recipe 2", "Recipe 3"});
        recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane recipeListScrollPane = new JScrollPane(recipeList);
        this.add(recipeListScrollPane, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton viewRecipeButton = new JButton("View Recipe");
        JButton commentButton = new JButton("Comment");
        JButton backButton = new JButton("Back");
        buttons.add(viewRecipeButton);
        buttons.add(commentButton);
        buttons.add(backButton);

        this.add(buttons, BorderLayout.SOUTH);
        viewRecipeButton.addActionListener(
                e -> {
                    System.out.println("Button View Recipe is pressed");
                    List<String> selectedValuesList = recipeList.getSelectedValuesList();
                    if (selectedValuesList.size() > 0) {
                        // Get the selection
                    }else{
                        JOptionPane.showMessageDialog(this, "You did not select anything.");
                    }
                }
        );

        commentButton.addActionListener(
                e -> {
                    System.out.println("Button Comment is pressed");
                    List<String> selectedValuesList = recipeList.getSelectedValuesList();
                    if (selectedValuesList.size() > 0) {
                        // Get the selection
                    }else{
                        JOptionPane.showMessageDialog(this, "You did not select anything.");
                    }
                }
        );

        backButton.addActionListener(
                e -> {
                    System.out.println("Button Back is pressed");
                }
        );
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TestView");
        frame.setContentPane(new RecipeListView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
