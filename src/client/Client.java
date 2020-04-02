package client;

import entity.Repository;
import service.GetData;
import util.Display;

import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args){

        Display display = new Display();
        display.printInputFormat();

        /*
        // Code for taking input using command line arguments
        int argLength = args.length;
        if (argLength != 3){
            display.printInputFormat();
            return;
        }

        String orgName = args[0];
        int topReposCount = Integer.valueOf(args[1]);
        int topCommitteesCount = Integer.valueOf(args[2]);
        */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input: ");
        String orgName = scanner.next();
        int topReposCount = scanner.nextInt();
        int topCommitteesCount = scanner.nextInt();

        System.out.println("Waiting...");

        GetData data = new GetData(orgName.toLowerCase(), topReposCount, topCommitteesCount);

        // List top m repos with top n committees for an organization
        try{
            List<Repository> repositoryList = data.getRepositoryList();
            display.printRepos(repositoryList);
        }
        catch(Exception e){
            System.out.println("Exception occurred in main()" + e);
        }

    }
}
