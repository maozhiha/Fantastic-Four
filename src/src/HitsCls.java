import org.json.JSONArray;
import org.json.JSONObject;

public class HitsCls implements HitsInterface {
    private JSONArray hits;
    private String[] hitsArray;

    public HitsCls(JSONObject data, int index, int arr_length) {
        hits = data.getJSONArray("hits");
        hitsArray = new String[10];
        for (int i = 0; i < 10; i++) {
            if (index < arr_length) {
                String slabel0 = hits.getJSONObject(index).getJSONObject("recipe").getString("label");
                int print_index = index + 1;
                //System.out.println(" (" + print_index + ") " + slabel);
                String slabel = " (" + print_index + ") " + slabel0;
                hitsArray[i] = slabel;
                index++;
            }
        }
    }

    public String[] getHitsArray() {
        return hitsArray;
    }
}
