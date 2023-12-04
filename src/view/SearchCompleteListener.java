package view;

import java.util.*;

@FunctionalInterface
public interface SearchCompleteListener {
    void onSearchComplete(ArrayList<String> recipeData);
}

