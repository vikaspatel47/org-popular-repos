package util;

import entity.Committee;
import entity.Repository;

import java.util.List;

public class Display {

    public void printInputFormat() {
        System.out.println("Enter organization name, repo count and committees count");
        System.out.println("Ex: google 2 3");
    }

    // Print repositories and its committees
    public void printRepos(List<Repository> repositories){
        for(Repository repo: repositories){
            System.out.println("-----------------------------");
            System.out.println(repo.getRepoName() + ": " + repo.getForkCount() );
            displayCommitteesList(repo.getCommittees());
        }
    }

    public void displayCommitteesList(List<Committee> committees) {
        String committeesList = "List of committees: \n";
        for(Committee committee: committees){
            committeesList += "    " + committee.getUserName() + ": " + committee.getCommitCount() + "\n";
        }
        System.out.println(committeesList);
    }
}
