package use_case.saved_recipes;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class IdUrlCls {
    private String Url;

    private static final String BASE_URL = "https://api.edamam.com/search";
    private static final String APP_KEY = "bd712aef489acbcfd24a515b6e18fb08";
    private static final String APP_ID = "30ccd393";
    private static final String ONTOLOGY_PREFIX = "http%3A%2F%2Fwww.edamam.com%2Fontologies%2Fedamam.owl%23";

    public IdUrlCls(String recipeId){
        try{
            /*String APP_ID = "30ccd393";
            String APP_KEYS = "bd712aef489acbcfd24a515b6e18fb08";
            String URL = "https://api.edamam.com/search?/app_id=" + APP_ID + "&app_key=" + APP_KEYS;
            String rValue = "http%3A%2F%2Fwww.edamam.com%2Fontologies%2Fedamam.owl%23" + recipeId;
            String url = URL +"&r="+rValue;*/
            String encodedRecipeId = URLEncoder.encode(recipeId, "UTF-8");
            String fullRecipeId = ONTOLOGY_PREFIX + encodedRecipeId;
            String url = String.format("%s?r=%s&app_key=%s&app_id=%s", BASE_URL, fullRecipeId, APP_KEY, APP_ID);

            this.Url = url;
            System.out.println(this.Url);
        } catch (UnsupportedEncodingException e){
            throw new RuntimeException("Error encoding recipeId for URL", e);
        }
    }

    public String getUrl(){return Url;}
}
