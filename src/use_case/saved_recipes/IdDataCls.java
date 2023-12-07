package use_case.saved_recipes;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import use_case.signup.SignupOutputData;

import java.io.IOException;

public class IdDataCls {
    private JSONObject data;
    public IdDataCls(String Url){
        try{
            String response = Jsoup.connect(Url).ignoreContentType(true).execute().body(); //call api
            JSONArray jsonArray = new JSONArray(response);
            if(jsonArray.length()>0){
                data = jsonArray.getJSONObject(0);
                System.out.println("data is an object");
            }
            else{
                data = new JSONObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public JSONObject getData() {
        return data;
    }

}
