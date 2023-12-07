package data_access;

import entity.Comment.Comments;

import java.io.*;
import java.rmi.RemoteException;
import java.util.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SaveRecipeFileDataAccessObject {
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, List<String>> userRecipeMap = new HashMap<>();

    public SaveRecipeFileDataAccessObject(String csvPath) throws IOException {
        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("recipeId", 1);

        if (csvFile.length() == 0){
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,recipeId");
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String recipeId = String.valueOf(col[headers.get("recipeId")]);
                    userRecipeMap.computeIfAbsent(username, k -> new ArrayList<>()).add(recipeId);
                }
            } catch (IOException e){
                throw new RuntimeException("Error loading saved recipes");
            }
        }

    }


    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Map.Entry<String, List<String>> entry : userRecipeMap.entrySet()) {
                String username = entry.getKey();
                List<String> recipeIds = entry.getValue();
                for (String recipeId : recipeIds){
                    writer.write(username+","+recipeId);
                    writer.newLine();
                }
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getSavedRecipesForUser(String username) {
        return userRecipeMap.getOrDefault(username, new ArrayList<>());
    }

    public void saveRecipeForUser(String username, String recipeId) {
        userRecipeMap.computeIfAbsent(username, k -> new ArrayList<>()).add(recipeId);
        save(); // Save the updated map to the file
    }
}