import org.json.JSONObject;

import java.util.Scanner;


public class RecipesDisplayer{
    public static void DisplayRecipes(JSONObject data, int index, int arr_length, Scanner scanner) {
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
                findotherreceipes = true;
            } else if (select == "n") {
                index = displayRecipeLabels(data, index, arr_length);
            } else if (select == "p") {
                index = index - 20;
                if (index < 0) {
                    index = 0;
                }
                index = displayRecipeLabels(data, index, arr_length);
            } else {
                int selection = Integer.parseInt(select);
                CurrentRecipeDisplayer.CurrentRecipe(data, selection);
            }

        }
    }


        public void noResult () {
            System.out.println("no recipe was found according to your selected criteria");
            System.out.println("");
            System.out.print("");

        }
        public static int displayRecipeLabels (JSONObject data,int index, int arr_length){
            System.out.println();
            HitsCls hits = new HitsCls(data, index, arr_length);
            String[] hitsArray = hits.getHitsArray();
            for (int i = 0; i < 10; i++) {
                if (hitsArray[i] != null) {
                    System.out.println(hitsArray[i]);
                    index++;
                }
            }
            System.out.println();
            return index;
        }

        public static String selectFromIndex ( int maxIndex, Scanner scanner){
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

    }