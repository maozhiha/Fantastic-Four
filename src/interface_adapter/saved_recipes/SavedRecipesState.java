package interface_adapter.saved_recipes;

import entity.Recipe;
import use_case.saved_recipes.IdCurrRecipeCls;

import java.util.List;

public class SavedRecipesState {
    private List<IdCurrRecipeCls> recipes;
    public SavedRecipesState(){}
    public List<IdCurrRecipeCls> getRecipes() {return recipes;}
    public void setRecipes(List<IdCurrRecipeCls> recipes){this.recipes=recipes;}

}
