package datastore;

import game.Connect4Game;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Radu on 24.11.2016.
 */
public class DataStore {
    private static DataStore instance = new DataStore();
    private Map<String, Connect4Game> cache;

    private DataStore(){
        cache = new HashMap<String, Connect4Game>();
    }

    public static DataStore getInstance(){
        return instance;
    }

    public void saveGame(String session, Connect4Game game){
        cache.put(session, game);
    }
    public Connect4Game getGame(String session){
        if(cache.containsKey(session)){
            return cache.get(session);
        } else {
            return new Connect4Game();
        }
    }
}
