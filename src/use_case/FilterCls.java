package use_case;

public class FilterCls implements filterInterface {
    private String dietlabel;
    private String healthlabel;
    private String mealtype;
    private String dishtype;
    private String cuisinetype;


    public FilterCls(String dietlabel, String healthlabel, String mealtype, String dishtype, String cuisinetype) {
        this.dietlabel = dietlabel;
        this.healthlabel = healthlabel;
        this.mealtype = mealtype;
        this.dishtype = dishtype;
        this.cuisinetype = cuisinetype;
    }

    public String getdietlabel() {
        return dietlabel;
    }

    public String gethealthlabel() {
        return healthlabel;
    }

    public String getmealtype() {
        return mealtype;
    }

    public String getdishtype() {
        return dishtype;
    }

    public String getcuisinetype() {
        return cuisinetype;
    }

}