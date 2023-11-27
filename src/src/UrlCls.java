import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlCls implements UrlInterface {
    private String Url;

    public UrlCls(SearchCls SearchKeyword, FilterCls FilterCriteria) {
        try {
            int _from = 0;
            int _to = 100;
            String APP_ID = "30ccd393";
            String APP_KEYS = "bd712aef489acbcfd24a515b6e18fb08";
            String URL = "https://api.edamam.com/search?/app_id=" + APP_ID + "&app_key=" + APP_KEYS;

            String keyWord = SearchKeyword.getKeyword();
            String dietLabels = FilterCriteria.getdietlabel();
            String healthLabels = FilterCriteria.gethealthlabel();
            String mealType = FilterCriteria.getmealtype();
            String dishType = FilterCriteria.getdishtype();
            String cuisineType = FilterCriteria.getcuisinetype();


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
            this.Url = url;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return Url;
    }

}