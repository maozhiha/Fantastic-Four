package data_access;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveRecipeFileDataAccessObject {
    private final String filePath;

    public SaveRecipeFileDataAccessObject(String filePath) {
        this.filePath = filePath;
        initializeFile();
    }

    private void initializeFile() {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error initializing save recipe file.", e);
        }
    }

    public List<String> getSavedRecipesForUser(String userId) {
        List<String> savedRecipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(userId)) {
                    savedRecipes.add(parts[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error getting saved recipes for user.", e);
        }
        return savedRecipes;
    }

    public void saveRecipeForUser(String userId, String recipeId) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(userId + "," + recipeId);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error saving recipe for user.", e);
        }
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Optionally, you can add headers if needed
            // writer.write("user_id,recipe_id");
            // writer.newLine();

            // Iterate over saved recipes and write to the file
            // Example: for (SavedRecipe savedRecipe : savedRecipes) { ... }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error saving data to file.", e);
        }
    }
}