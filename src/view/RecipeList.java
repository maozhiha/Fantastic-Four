package view;

import interface_adapter.search_form.SearchFormController;
import use_case.seach.RecipesDisplayer2;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class RecipeList extends JFrame {
    private JLabel lbResultNum;
    private JList listRecipe;
    private JButton btnOK;
    private JTextField tfInput;
    private JPanel listPanel;
    private JLabel lbTitle;
    private SearchCompleteListener inputListener;
    private int currentIndex;
    public RecipeList(ArrayList<String> recipeDat) {
        this.inputListener = inputListener;
        setContentPane(listPanel);
        setTitle("Result");
        setSize(450, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        ArrayList<String> recipeData = SearchFormController.gethit();
        listRecipe.setListData(new String[]{});
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = tfInput.getText();
                // Set user choice in the controller
                SearchFormController.setUserChoice(input);
                RecipesDisplayer2.DisplayRecipes();
            }
            //System.out.println(input);
        });
    }
    // Method to update the JList with data from the ArrayList
    public void updateRecipeList(ArrayList<String> recipeData) {
        listRecipe.setListData(recipeData.toArray(new String[0]));
    }
    public void setInputListener(SearchCompleteListener inputListener) {
        this.inputListener = inputListener;
    }
    public static void main(String[] args) {
        // Assuming you have recipeData from Controller.gethit()
        ArrayList<String> recipeData = SearchFormController.gethit();

        // Create an instance of RecipeList
        RecipeList recipeList = new RecipeList(null);
        recipeList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        recipeList.setVisible(true);
    }
}
