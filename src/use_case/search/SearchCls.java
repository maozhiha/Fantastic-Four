package use_case.search;

public class SearchCls implements searchInterface {
    private String keyword;

    public SearchCls(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

}