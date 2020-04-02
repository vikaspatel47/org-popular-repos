package entity;

import java.util.ArrayList;

public class Repository {
    private String repoName;
    private String contributorsUrl;
    private long forkCount;
    private ArrayList<Committee> committees;

    public Repository(String repoName, String contributorsUrl, long forkCount){
        this.repoName = repoName;
        this.forkCount = forkCount;
        this.contributorsUrl = contributorsUrl;
        this.committees = new ArrayList<>();
    }

    public String getRepoName() {
        return repoName;
    }

    public long getForkCount() {
        return forkCount;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public ArrayList<Committee> getCommittees() {
        return committees;
    }

    public void setCommittees(ArrayList<Committee> committees) {
        this.committees.addAll(committees);
    }
}
