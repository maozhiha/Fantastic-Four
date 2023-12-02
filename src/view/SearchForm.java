package view;

import interface_adapter.*;
import use_case.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SearchForm extends JFrame {
    private JPanel searchPanel;
    private JButton btnSearch;
    private JLabel lbTitle;
    private JLabel lbKeywords;
    private JTextField tfKeywords;
    private JPanel pnFilterBy;
    private JList listDiet;
    private JLabel lbFilterBy;
    private JList listHealth;
    private JList listMealType;
    private JList listDishType;
    private JList listCuisineType;
    private JPanel pnFilterByDiet;
    private JPanel pnFilterByHealth;
    private JPanel pnFilterByMealType;
    private JPanel pnFilterByDishType;
    private JPanel pnFilterByCuisineType;
    private RecipeList recipeList;
    private SearchCompleteListener searchCompleteListener;

    private String formatSelectedValuesList(JList<String> list) {
        String selectedString = list.getSelectedValuesList().toString();
        if ("[]".equals(selectedString)) {
            return "";
        } else {
            return selectedString.substring(1, selectedString.length() - 1);
        }
    }
    public SearchForm(){
        setContentPane(searchPanel);
        setTitle("Search");
        setSize(450, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords = tfKeywords.getText();
                System.out.println(keywords);
                String dietSubString = formatSelectedValuesList(listDiet);
                String healthSubString = formatSelectedValuesList(listHealth);
                String mealTypeSubString = formatSelectedValuesList(listMealType);
                String dishSubString = formatSelectedValuesList(listDishType);
                String cuisineSubString = formatSelectedValuesList(listCuisineType);
                //GetInput.searchRecipes(keywords, dietSubString, healthSubString, mealTypeSubString, dishSubString, cuisineSubString);
                // Set data in the controller
                Controller.setSearchData(keywords, dietSubString, healthSubString, mealTypeSubString, dishSubString, cuisineSubString);

                // Perform search
                GetInput.searchRecipes();
                //Controller.searchRecipes();
                //openRecipeList(Controller.gethit());
                // Notify the listener when the search is complete
                if (searchCompleteListener != null) {
                    ArrayList<String> recipeData = Controller.gethit();
                    searchCompleteListener.onSearchComplete(recipeData);
            }
            }

        });
        // Set the default close operation to dispose when closing
        recipeList.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        recipeList.setVisible(true);

    }

    public void setSearchCompleteListener(SearchCompleteListener listener) {
            this.searchCompleteListener = listener;
        }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SearchForm searchForm = new SearchForm();

            // You can set a listener in SearchForm to be notified when the search is done
            searchForm.setSearchCompleteListener(recipeData -> {
                RecipeList recipeList = new RecipeList(recipeData);

                // Set the default close operation to dispose when closing
                recipeList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                recipeList.setVisible(true);
                });
        });

    }
}