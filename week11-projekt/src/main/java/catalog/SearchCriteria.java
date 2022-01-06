package catalog;

public class SearchCriteria {

    public final String title;
    public  String contributor;


    public SearchCriteria(String title, String contributor) {
        this.title = title;
        this.contributor = contributor;
    }

    public SearchCriteria(String title) {
        this.title = title;
        //this.contributor = contributor;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        return new SearchCriteria(title, contributor);
    }

    public static SearchCriteria createByContributor(String contributor) {
        return new SearchCriteria(contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        return new SearchCriteria(title);
    }

    public boolean hasTitle() {
        return true;
    }

    public boolean hasContributor() {
        return true;
    }

    public String getTitle() {
        return title;
    }

    public String getContributor() {
        return contributor;
    }
}
