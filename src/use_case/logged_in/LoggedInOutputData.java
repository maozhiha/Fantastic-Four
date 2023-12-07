package use_case.logged_in;

import entity.Recipe;
import java.util.List;


public class LoggedInOutputData {
    private final List<Recipe> recipes;
    public LoggedInOutputData(List<Recipe> recipes){
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes(){return recipes;}
}
