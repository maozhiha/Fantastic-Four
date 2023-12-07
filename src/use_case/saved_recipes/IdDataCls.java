package use_case.saved_recipes;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.IOException;

public class IdDataCls {
    private JSONObject data;
    public IdDataCls(String Url){
        try{
            String response = Jsoup.connect(Url).ignoreContentType(true).execute().body(); //call api
            data = new JSONObject(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public JSONObject getData() {
        return data;
    }
    public int getArraylength() {
        JSONArray arr = data.getJSONArray("hits");
        return arr.length();

    }
}
