import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

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
            System.out.println("enter keyword(s).  Use 'and' if multiple keywords.");
            System.out.print("\t>> ");
            String keyWord = scanner.nextLine();
            keyWord = keyWord.replaceAll("(?i) and ", "+");
            keyWord = keyWord.replaceAll("(?i) or ", ",");

            System.out.println("Enter diet labels (comma-separated):");
            System.out.println("      Check valid inputs from https://developer.edamam.com/edamam-docs-recipe-api");
            System.out.print("\t>> ");
            String dietLabels = scanner.nextLine();

            System.out.println("Enter health labels (comma-separated):");
            System.out.println("      Check valid inputs from https://developer.edamam.com/edamam-docs-recipe-api");
            System.out.print("\t>> ");
            String healthLabels = scanner.nextLine();

            System.out.println("Enter meal type:");
            System.out.println("      Check valid inputs from https://developer.edamam.com/edamam-docs-recipe-api");
            System.out.print("\t>> ");
            String mealType = scanner.nextLine();

            System.out.println("Enter dish type:");
            System.out.println("      Check valid inputs from https://developer.edamam.com/edamam-docs-recipe-api");
            System.out.print("\t>> ");
            String dishType = scanner.nextLine();

            System.out.println("Enter cuisine type:");
            System.out.println("      Check valid inputs from https://developer.edamam.com/edamam-docs-recipe-api");
            System.out.print("\t>> ");
            String cuisineType = scanner.nextLine();

            data = makeRequest(getUrlQ(keyWord, dietLabels, healthLabels, mealType, dishType, cuisineType));
            JSONArray arr = data.getJSONArray("hits");

            if (arr.length() > 0) {
                success = true;
            } else {
                System.out.println("no recipe was found according to your selected criteria");
                System.out.println("");
                System.out.print("");
                return;
            }


            int arr_length = arr.length();
            if (arr_length == 1) {
                System.out.println(arr_length + " recipes was found.");
            } else if (arr_length >= 100) {
                System.out.println("100 recipes or more than 100 recipes were found");
                arr_length = 100;
            } else {
                System.out.println(arr_length + " recipes were found.");
            }


            index = displayRecipeLabels(data, index, arr_length);


            boolean findotherreceipes = false;
            while (!findotherreceipes) {
                System.out.println(" input recipe number or \n       (n)ext to display next 10 recipes or \n       (p)revious to display previous 10 recipes or \n       (q)uit to find other recipes");
                String select = selectFromIndex(index, scanner);
                if (select == "q") {
                    findotherreceipes=true;
                } else if (select == "n") {
                    index = displayRecipeLabels(data, index, arr_length);
                } else if (select == "p") {
                    index = index - 20;
                    if (index < 0) {
                        index = 0;
                    }
                    index = displayRecipeLabels(data, index, arr_length);
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
            } else if (select.equalsIgnoreCase("n")) {
                System.out.println();
                return;
            } else if (select.equalsIgnoreCase("p")) {
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

    public static String getUrlQ(String keyWord, String dietLabels, String healthLabels, String mealType, String dishType, String cuisineType) {
        return getUrlQ(keyWord, 0, 100, dietLabels, healthLabels, mealType, dishType, cuisineType);
    }

    public static String getUrlQ(String keyWord, int _from, int _to, String dietLabels, String healthLabels, String mealType, String dishType, String cuisineType) {
        try {
            String urlencode = URLEncoder.encode(keyWord, "UTF-8");
            String url = URL + "&q=" + urlencode + "&to=" + _to + "&from=" + _from;

            if (dietLabels != null && !dietLabels.isEmpty()) {
                url += "&diet=" + URLEncoder.encode(dietLabels, "UTF-8");
            }

            if (healthLabels != null && !healthLabels.isEmpty()) {
                url += "&health=" + URLEncoder.encode(healthLabels, "UTF-8");
            }

            if (mealType != null && !mealType.isEmpty()) {
                url += "&mealType=" + URLEncoder.encode(mealType, "UTF-8");
            }

            if (dishType != null && !dishType.isEmpty()) {
                url += "&dishType=" + URLEncoder.encode(dishType, "UTF-8");
            }

            if (cuisineType != null && !cuisineType.isEmpty()) {
                url += "&cuisineType=" + URLEncoder.encode(cuisineType, "UTF-8");
            }


            System.out.println(url);
            return url;

        } catch (UnsupportedEncodingException e) {
            return e.toString();
        }
    }

    public static int displayRecipeLabels(JSONObject data, int index, int arr_length) {
        System.out.println();
        JSONArray hits = data.getJSONArray("hits");
        for (int i = 0; i < 10; i++) {
            if (index < arr_length) {
                String slabel = hits.getJSONObject(index).getJSONObject("recipe").getString("label");
                int print_index = index + 1;
                System.out.println(" (" + print_index + ") " + slabel);
                index++;
            }
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
            } else if (select.equalsIgnoreCase("n")) {
                return "n";
            } else if (select.equalsIgnoreCase("p")) {
                return "p";
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