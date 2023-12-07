package data_access;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestSaveRecipeDataAccessObject {

    @Test
    public void createCsv() throws IOException {
        File csvFile = new File("test_save_recipe.csv");

        SaveRecipeFileDataAccessObject saveRecipeDataAccessObject = new SaveRecipeFileDataAccessObject("test_save_recipe.csv");

        assert csvFile.exists();

        csvFile.delete();
    }

    @Test
    public void testSaveRecipe() throws IOException {
        File csvFile = new File("test_save_recipe.csv");

        SaveRecipeFileDataAccessObject saveRecipeDataAccessObject = new SaveRecipeFileDataAccessObject("test_save_recipe.csv");

        saveRecipeDataAccessObject.saveRecipeForUser("test", "test");
        List<String> test = saveRecipeDataAccessObject.getSavedRecipesForUser("test");
        assert test.contains("test");

        assert csvFile.exists();

        csvFile.delete();
    }
}
