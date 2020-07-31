import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Jsondemo {

    final String PATH = "src/main/resources/tweets-users.json";

    private void parsingJson(){
        JSONParser parser = new JSONParser();
        Map<String, List<String>> map = new HashMap<>();

        try{
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(PATH));

              for(Object o : jsonArray) {
                  JSONObject jsonObject = (JSONObject) o;

                  String username = (String) jsonObject.get("user");
                  System.out.println(username);
                  String tweet = (String) jsonObject.get("tweet");
                  System.out.println(tweet);
                  if(!map.containsKey(username)){
                      //New Username
                      List<String> newList = new ArrayList<>();
                      newList.add(tweet);
                      map.put(username,newList);
                  }else {
                      // Users exists
                      List<String> currList = map.get(username);
                      currList.add(tweet);
                      map.put(username, currList);
                  }
              }
              Map.Entry<String, List<String>> maxEntry = null;

              for(Map.Entry<String, List<String>> entry : map.entrySet()) {
                if(maxEntry == null || entry.getValue().size() > maxEntry.getValue().size()){
                    maxEntry = entry;
                }
              }
            if (maxEntry != null) {
                System.out.println("Max entry - " + maxEntry.getKey() + " had a count of " + maxEntry.getValue());
            }
            if (maxEntry != null) {
                for (String tweet : maxEntry.getValue()) {
                        System.out.println(tweet);
                    }
            }
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }

    }
    public void initialize(){
        parsingJson();
    }
}

