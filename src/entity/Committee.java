package entity;

public class Committee {
    private String userName;
    private long commitCount;

    public Committee(String userName, long commitCount){
        this.userName = userName;
        this.commitCount = commitCount;
    }

    public String getUserName() {
        return userName;
    }

    public long getCommitCount() {
        return commitCount;
    }
}
