package service;

import entity.Repository;
import util.OutputParser;
import util.URLCreator;

import java.io.IOException;
import java.util.*;

public class GetData {

    private String orgName;
    private int topReposCount;
    private int topCommitteesCount;
    private URLCreator urlCreator;

    public GetData(String orgName, int topReposCount, int topCommitteesCount){
        this.orgName = orgName;
        this.topReposCount = topReposCount;
        this.topCommitteesCount = topCommitteesCount;
        this.urlCreator = new URLCreator(this.orgName);
    }

    // get all required top repositories of a given organization  with  required top committees.
    public List<Repository> getRepositoryList() throws IOException {
        List<Repository> repositoryList = new ArrayList<>();
        RequestHandlerService handler = new RequestHandlerService();
        OutputParser outputParser = new OutputParser();
        List<Repository> tempRepoList;
        int pageNumber = 1;
        do {
            String repoUrl = urlCreator.getRepoUrl(pageNumber++);
            String response = handler.serveUrlRequest(repoUrl);
            tempRepoList = outputParser.getRepos(response);
            repositoryList.addAll(tempRepoList);
        } while(tempRepoList.size() == 100 );

        repositoryList =  getTopRepos(repositoryList);

        return updateCommittees(repositoryList);
    }

    // get required top repositories in sorted order
    private List<Repository> getTopRepos(List<Repository> repositories){
        Collections.sort(repositories, compareByForkCount);
        if(repositories.size() <= topReposCount){
            return repositories;
        }
        return repositories.subList(0, topReposCount);
    }

    private final Comparator<Repository> compareByForkCount = (r1, r2) -> {
        long c1 = r1.getForkCount();
        long c2 = r2.getForkCount();
        return c1 > c2 ? -1 : (c1 == c2)? 0 : 1;
    };

    // Update repository with required top committees based on number of commit
    private List<Repository> updateCommittees(List<Repository> repositories) throws IOException {
        RequestHandlerService handler = new RequestHandlerService();
        OutputParser outputParser = new OutputParser();

        for(Repository repos: repositories) {
            String response = handler.serveUrlRequest(repos.getContributorsUrl());
            repos.setCommittees(outputParser.getCommittees(topCommitteesCount, response));
        }

        return repositories;
    }
}
