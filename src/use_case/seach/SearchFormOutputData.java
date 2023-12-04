package use_case.seach;

import org.json.JSONObject;

public class SearchFormOutputData {

    private JSONObject data;

    private int arr_length;

    public SearchFormOutputData(JSONObject data, int arr_length) {
        this.data = data;
        this.arr_length = arr_length;
    }

    public JSONObject getData() {
        return data;
    }

    public int getArr_length() {
        return arr_length;
    }
}
