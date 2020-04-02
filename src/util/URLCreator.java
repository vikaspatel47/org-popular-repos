package util;

public class URLCreator {
    String orgName;
    String baseURL = "https://api.github.com/";
    String url;

    public URLCreator(String orgName){
        this.orgName = orgName;
    }

    public String getRepoUrl(int pageNumber) {
        return baseURL + "orgs/" + orgName + "/repos?page=" + pageNumber + "&per_page=100";
    }
}
