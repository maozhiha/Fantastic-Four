package use_case.saved_recipes;


public class IdUrlCls {
    private String Url;
    public IdUrlCls(String recipeId){
        try{
            String APP_ID = "30ccd393";
            String APP_KEYS = "bd712aef489acbcfd24a515b6e18fb08";
            String URL = "https://api.edamam.com/search?/app_id=" + APP_ID + "&app_key=" + APP_KEYS;
            String rValue = "http%3A%2F%2Fwww.edamam.com%2Fontologies%2Fedamam.owl%23" + recipeId;
            String url = URL +"&r="+rValue;
            this.Url = url;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getUrl(){return Url;}
}
