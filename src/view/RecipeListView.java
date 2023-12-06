package view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Recipe;
import entity.SearchResult;
import interface_adapter.recipe_list.RecipeListController;
import interface_adapter.recipe_list.RecipeListViewModel;
import interface_adapter.search_form.SearchFormState;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class RecipeListView extends JPanel implements PropertyChangeListener {
    public final String viewName = "Recipe List View";

    private final RecipeListController recipeListController;
    private final RecipeListViewModel recipeListViewModel;

    private JList<String> recipeList;

    public RecipeListView(RecipeListController recipeListController, RecipeListViewModel recipeListViewModel) {
        this.recipeListController = recipeListController;
        this.recipeListViewModel = recipeListViewModel;
        this.recipeListViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel("Recipe List View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(new BorderLayout());

        this.add(title, BorderLayout.NORTH);

        recipeList = new JList<String>(new String[]{"Recipe 1", "Recipe 2", "Recipe 3"});
        recipeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane recipeListScrollPane = new JScrollPane(recipeList);
        this.add(recipeListScrollPane, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton viewRecipeButton = new JButton("View Recipe");
        JButton backButton = new JButton("Back");
        buttons.add(viewRecipeButton);
        buttons.add(backButton);

        this.add(buttons, BorderLayout.SOUTH);
        viewRecipeButton.addActionListener(
                actionEvent -> {
                    System.out.println("Button View Recipe is pressed");
                    List<String> selectedValuesList = recipeList.getSelectedValuesList();
                    if (selectedValuesList.size() > 0) {
                        // Get the selection
                        SearchFormState state = recipeListViewModel.getState();
                        JSONObject data = state.getSearchResult();

                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            // From Chatgpt: Use Jackson to parse JSON into Java Class
                            SearchResult searchResult = objectMapper.readValue(data.toString(), SearchResult.class);

                            // Find the selected recipe that match the selectedValuesList.get(0)
                            String selectedRecipeTitle = selectedValuesList.get(0);
                            Recipe selectedRecipe = searchResult
                                    .getHits()
                                    .stream()
                                    .filter(hit -> hit.getRecipe().getLabel().equals(selectedRecipeTitle))
                                    .findFirst()
                                    .get().getRecipe();

                            recipeListController.displayRecipeDetail(selectedRecipe);
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "You did not select anything.");
                    }
                }
        );

        backButton.addActionListener(
                e -> {
                    System.out.println("Button Back is pressed");
                    recipeListController.goBackToSearchForm();
                }
        );
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        SearchFormState state = (SearchFormState) propertyChangeEvent.getNewValue();
        System.out.println("propertyChanged: SearchFormState: " + state);
        JSONObject data = state.getSearchResult();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // From Chatgpt: Use Jackson to parse JSON into Java Class
            SearchResult searchResult = objectMapper.readValue(data.toString(), SearchResult.class);
            System.out.println("searchResult: " + searchResult);

            List<String> recipeLabels = searchResult.getHits().stream().map(hit -> hit.getRecipe().getLabel()).toList();

            recipeList.setListData(recipeLabels.toArray(new String[0]));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("TestView");
//        frame.setContentPane(new RecipeListView(recipeListController));
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
