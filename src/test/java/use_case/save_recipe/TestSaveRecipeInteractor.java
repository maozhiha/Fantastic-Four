package use_case.save_recipe;

import data_access.SaveRecipeFileDataAccessObject;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestSaveRecipeInteractor {
    SaveRecipeInputBoundary saveRecipeInputBoundary;

    SaveRecipeFileDataAccessObject saveRecipeFileDataAccessObject;

    public TestSaveRecipeInteractor() throws IOException {
        saveRecipeFileDataAccessObject = new SaveRecipeFileDataAccessObject("test_save.csv");
        saveRecipeInputBoundary = new SaveRecipeInteractor(saveRecipeFileDataAccessObject);
    }

    @Test
    public void testSaveRecipe() throws IOException {
        SaveRecipeInputData saveRecipeInputData = new SaveRecipeInputData("test_user", "test_recipe");
        saveRecipeInputBoundary.saveRecipe(saveRecipeInputData);
    }

    @After
    public void tearDown() throws Exception {
        File csvFile = new File("test_save.csv");
        csvFile.delete();
    }
}
