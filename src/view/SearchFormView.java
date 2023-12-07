package view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.SearchResult;
import interface_adapter.search_form.SearchFormController;
import interface_adapter.search_form.SearchFormState;
import interface_adapter.search_form.SearchFormViewModel;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class SearchFormView extends JPanel implements PropertyChangeListener {

    public static final String viewName = "Search Form View";
    private final SearchFormViewModel searchFormViewModel;

    private final SearchFormController searchFormController;
    public SearchFormView(SearchFormViewModel searchFormViewModel, SearchFormController searchFormController) {
        this.searchFormViewModel = searchFormViewModel;
        this.searchFormController = searchFormController;
        this.searchFormViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Search Receipe by keywords and ingredients");

        this.setLayout(new GridLayout(10, 1));

        // Row1
        JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerPanel.add(title);

        // Row 2
        JLabel prompt = new JLabel("Enter keywords(s). Use 'and' if multiple keywords.");

        // Row 3
        JTextField keywords = new JTextField();

        // Row 4
        JLabel filterBy = new JLabel("Filter by:");

        // Row 5
        JPanel dietPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel dietPanelDescription = new JLabel("Diet \n (You can select multiple)");
        JList dietSelection = new JList(SearchFormViewModel.dietSelection);
        JScrollPane dietScrollPane = new JScrollPane(dietSelection);
        dietSelection.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        dietSelection.setLayoutOrientation(JList.VERTICAL);

        dietPanel.add(dietPanelDescription);
        dietPanel.add(dietScrollPane);

        // Row 6
        JPanel healthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel healthPanelDescription = new JLabel("Health \n (You can select multiple)");
        JList healthSelection = new JList(SearchFormViewModel.healthSelection);
        JScrollPane healthScrollPane = new JScrollPane(healthSelection);
        healthSelection.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        healthSelection.setLayoutOrientation(JList.VERTICAL);

        healthPanel.add(healthPanelDescription);
        healthPanel.add(healthScrollPane);

        // Row 7
        JPanel mealTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel mealTypePanelDescription = new JLabel("Meal Type \n (Select one)");
        JList mealTypeSelection = new JList(SearchFormViewModel.mealTypeSelection);
        JScrollPane mealTypeScrollPane = new JScrollPane(mealTypeSelection);
        mealTypeSelection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mealTypeSelection.setLayoutOrientation(JList.VERTICAL);

        mealTypePanel.add(mealTypePanelDescription);
        mealTypePanel.add(mealTypeScrollPane);


        // Row 8
        JPanel dishTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel dishTypePanelDescription = new JLabel("Dish Type \n (Select one)");
        JList dishTypeSelection = new JList(SearchFormViewModel.dishTypeSelection);
        JScrollPane dishTypeScrollPane = new JScrollPane(dishTypeSelection);
        dishTypeSelection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        dishTypeSelection.setLayoutOrientation(JList.VERTICAL);
        dishTypePanel.add(dishTypePanelDescription);
        dishTypePanel.add(dishTypeScrollPane);

        // Row 9
        JPanel cuisineTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel cuisineTypePanelDescription = new JLabel("Cuisine Type \n (Select one)");
        JList cuisineTypeSelection = new JList(SearchFormViewModel.cuisineTypeSelection);
        JScrollPane cuisineTypeScrollPane = new JScrollPane(cuisineTypeSelection);
        cuisineTypeSelection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cuisineTypeSelection.setLayoutOrientation(JList.VERTICAL);
        cuisineTypePanel.add(cuisineTypePanelDescription);
        cuisineTypePanel.add(cuisineTypeScrollPane);

        // Row 10
        JPanel buttons = new JPanel();
        JButton searchButton = new JButton("Search");
        JButton backButton = new JButton("Back");
        buttons.add(searchButton);
        buttons.add(backButton);

        searchButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        SearchFormState searchFormState = searchFormViewModel.getState();

                        String searchKeywords = keywords.getText();
                        System.out.println(keywords);
                        String dietSubString = formatSelectedValuesList(dietSelection);
                        String healthSubString = formatSelectedValuesList(healthSelection);
                        String mealTypeSubString = formatSelectedValuesList(mealTypeSelection);
                        String dishSubString = formatSelectedValuesList(dishTypeSelection);
                        String cuisineSubString = formatSelectedValuesList(cuisineTypeSelection);

                        searchFormState.setKeywords(searchKeywords);
                        searchFormState.setDietSubString(dietSubString);
                        searchFormState.setHealthSubString(healthSubString);
                        searchFormState.setMealTypeSubString(mealTypeSubString);
                        searchFormState.setDishSubString(dishSubString);
                        searchFormState.setCuisineSubString(cuisineSubString);

                        System.out.println(searchFormState.getKeywords());
                        System.out.println(searchFormState.getDietSubString());
                        System.out.println(searchFormState.getHealthSubString());
                        System.out.println(searchFormState.getMealTypeSubString());
                        System.out.println(searchFormState.getDishSubString());
                        System.out.println(searchFormState.getCuisineSubString());
                        searchFormController.execute(
                                searchFormState.getKeywords(),
                                searchFormState.getDietSubString(),
                                searchFormState.getHealthSubString(),
                                searchFormState.getMealTypeSubString(),
                                searchFormState.getDishSubString(),
                                searchFormState.getCuisineSubString());
                    }
                }
        );

        backButton.addActionListener(actionEvent -> {
            searchFormController.goBackToLoggedInView();
        });


        this.add(innerPanel);
        this.add(prompt);
        this.add(keywords);
        this.add(filterBy);
        this.add(dietPanel);
        this.add(healthPanel);
        this.add(mealTypePanel);
        this.add(dishTypePanel);
        this.add(cuisineTypePanel);
        this.add(buttons);
    }

    private String formatSelectedValuesList(JList<String> list) {
        String selectedString = list.getSelectedValuesList().toString();
        if ("[]".equals(selectedString)) {
            return "";
        } else {
            return selectedString.substring(1, selectedString.length() - 1);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        SearchFormState state = searchFormViewModel.getState();
        System.out.println(state.isSearchResultEmpty());
        if (state.isSearchResultEmpty()) {
            JOptionPane.showMessageDialog(this, "No result found.");
        }
    }
}
