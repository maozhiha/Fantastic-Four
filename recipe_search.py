import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

public class RecipeFinder {
    private static final String APP_ID = "30ccd393";
    private static final String APP_KEYS = "bd712aef489acbcfd24a515b6e18fb08";
    private static final String URL = "https://api.edamam.com/search?/app_id=" + APP_ID + "&app_key=" + APP_KEYS;

    public static void main(String[] args) {
        boolean endprogram = false;
        Scanner scanner = new Scanner(System.in);
        while (!endprogram) {
            System.out.println("Find recipe? (yes/no):");
            System.out.print("\t>> ");
            String command = scanner.nextLine();
            System.out.println();
            if (command.equalsIgnoreCase("yes")) {
                searchRecipes(scanner);
            } else {
                endprogram=true;
            }
        }
        System.out.println("Thank you for using this App");
        System.out.println();
        scanner.close();
    }

    public static void searchRecipes(Scanner scanner) {        
        JSONObject data = null;
        boolean success = false;
        int index = 0;
        while (!success) {
            System.out.println("enter keyword(s).  Use or/and if multiple keywords");
            System.out.print("\t>> ");
            String keyWord = scanner.nextLine();
            keyWord = keyWord.replaceAll("(?i) and ", "+");
            keyWord = keyWord.replaceAll("(?i) or ", ",");
            data = makeRequest(getUrlQ(keyWord));
            JSONArray arr = data.getJSONArray("hits");

            if (arr.length() > 0) {
                success = true;
            } else {
                System.out.println("no results for \"" + keyWord + "\"");
                System.out.print("");
            }
            index = arr.length();
            if (index == 1) {
                System.out.println(index + " recipes was found.");
            } else if (index >= 100) {
                System.out.println("100 recipes or more than 100 recipes were found"); 
                index = 100;
            } else {
                System.out.println(index + " recipes were found.");
            }
            boolean findotherreceipes = false;
            while (!findotherreceipes) {
                System.out.println(" input recipe number (1-" + index + ")\n (enter q to find other recipes)");
                String select = selectFromIndex(index, scanner);
                if (select == "q") {
                    findotherreceipes=true;
                } else {
                    selectRecipe(data, index, select, scanner);
                }
            }
        }
    }

    public static void selectRecipe(JSONObject data, int maxIndex, String select, Scanner scanner) {
        boolean invalid = true;
        int selection = 0;
        while (invalid) {
            if (select.equals("-1")) {
                select = selectRecipeFromIndex(maxIndex, scanner);
            }
            if (select.equalsIgnoreCase("q")) {
                System.out.println();
                return;            
            } else {
                try {
                    selection = Integer.parseInt(select);
                    invalid = false;
                } catch (NumberFormatException e) {
                    invalid = true;
                    select = "-1";
                }
            }
        }
        selection = Integer.parseInt(select);
        JSONObject recipeResponse = data.getJSONArray("hits").getJSONObject(selection);
        JSONObject recipe = recipeResponse.getJSONObject("recipe");
        JSONObject currRecipe = filterResponse(recipe);
        displayRecipeDict(currRecipe);
    }

    public static JSONObject makeRequest(String url) {
        try {
            String response = Jsoup.connect(url).ignoreContentType(true).execute().body();
            JSONObject data = new JSONObject(response);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUrlQ(String keyWord) {
        return getUrlQ(keyWord, 0, 100);
    }

    public static String getUrlQ(String keyWord, int _from, int _to) {
        try {
            String urlencode = URLEncoder.encode(keyWord, "UTF-8");
            String url = URL + "&q=" + urlencode + "&to=" + _to + "&from=" + _from;
            System.out.println(url);
            return url;               

        } catch (UnsupportedEncodingException e) {
            return e.toString();
        }
    }

    public static int displayRecipeLabels(JSONObject data, int index) {
        System.out.println();
        JSONArray hits = data.getJSONArray("hits");
        for (int i = 0; i < hits.length(); i++) {
            index++;
            System.out.printf(" " + index + ")", hits.getJSONObject(i).getJSONObject("recipe").getString("label"));
        }
        System.out.println();
        return index;
    }

    public static String selectRecipeFromIndex(int maxIndex, Scanner scanner) {
        System.out.println(" Select recipe number (1-" + maxIndex + ")");
        return selectFromIndex(maxIndex, scanner);
    }

    public static String selectFromIndex(int maxIndex, Scanner scanner) {
        String select = "-1";
        while (select.equals("-1") || Integer.parseInt(select) <= 0 || Integer.parseInt(select) > maxIndex) {
            System.out.print("\t>> ");
            select = scanner.nextLine();
            if (select.equalsIgnoreCase("q")) {
                return "q";
            } else {
                try {
                    select = Integer.toString(Integer.parseInt(select));
                } catch (NumberFormatException e) {
                    System.out.println("Input must be an integer!");
                    select = "-1";
                }
            }
        }
        return Integer.toString(Integer.parseInt(select) - 1);
    }

    public static JSONObject filterResponse(JSONObject recipe) {
        JSONObject currRecipe = new JSONObject();
        currRecipe.put("ingredients_line", recipe.getJSONArray("ingredientLines"));
        currRecipe.put("ingredients", recipe.getJSONArray("ingredients"));
        currRecipe.put("label", recipe.getString("label"));
        currRecipe.put("url", recipe.getString("url"));
        currRecipe.put("uri", recipe.getString("uri"));
        return currRecipe;
    }

    public static void displayRecipeDict(JSONObject currRecipe) {
        System.out.println();
        System.out.println("====================================================");
        System.out.println(currRecipe.getString("label") + ":");
        System.out.println("----------------------------------------------------");
        JSONArray ingredientsLine = currRecipe.getJSONArray("ingredients_line");
        for (int i = 0; i < ingredientsLine.length(); i++) {
            System.out.println(" - " + ingredientsLine.getString(i));
        }
        System.out.println();
        System.out.println("Directions: " + currRecipe.getString("url"));
        System.out.println("====================================================");
        System.out.print("");
    }
}
