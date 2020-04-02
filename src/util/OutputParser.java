package util;

import entity.Committee;
import entity.Repository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class OutputParser {

    // Get list of required top committees for a given repository
    public ArrayList<Committee> getCommittees (int topCommitteesCount, String parseString){
        ArrayList<Committee> committees = new ArrayList<>();
        try {

            JSONParser parser = new JSONParser();
            Object object = parser.parse(parseString);

            JSONArray array = (JSONArray)object;

            for(int i = 0; i< array.size() && i<topCommitteesCount; i++){
                JSONObject json = (JSONObject) array.get(i);
                committees.add(new Committee((String) json.get("login"), (long) json.get("contributions")));
            }
        } catch (Exception e) {
            System.out.println("getCommittees() failed with: " + e);
        }
        return committees;
    }

    // Get list of repositories for a given organization
    public ArrayList<Repository> getRepos(String parseString) {
        ArrayList<Repository> repos = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(parseString);

            JSONArray array = (JSONArray)object;

            for(int i = 0; i< array.size(); i++){
                JSONObject json = (JSONObject) array.get(i);
                repos.add(new Repository((String) json.get("name"), (String) json.get("contributors_url"), (long) json.get("forks_count")));
            }
        } catch (Exception e) {
            System.out.println("getRepos() failed with: " + e);
        }
        return repos;
    }
}
