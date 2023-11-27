import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.IOException;

public class DataCls implements DataInterface {
    private JSONObject data;

    public DataCls(String Url) {
        try {
            String response = Jsoup.connect(Url).ignoreContentType(true).execute().body();
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
