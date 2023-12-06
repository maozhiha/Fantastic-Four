package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {
    public String uri;

    public String label;

    public List<String> ingredientLines;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<String> getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(List<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    // This is used to get identifier of recipe
    public String getId() {
        return uri.substring(uri.lastIndexOf("#") + 1);
    }
}
