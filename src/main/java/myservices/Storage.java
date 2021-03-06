package myservices;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Storage simpleStorage = new Storage();
    private Map<String,String> map = new HashMap<String, String>();

    private Storage(){

    }

    public static Storage getSimpleStorage(){
        return  simpleStorage;
    }

    public void addItem(String sessionId, String token){
        map.put(sessionId,token);
    }

    public String getItem(String sessionId){
        for(Map.Entry<String,String> entry : map.entrySet()){
            if(sessionId.equals(entry.getKey())){
                return  entry.getValue();
            }
        }
        return null;
    }
    public void print() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("sessionId " + entry.getKey() + " token" + entry.getValue());
        }
    }
}

