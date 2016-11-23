package datastore;

import game.Connect4Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Radu on 24.11.2016.
 */
public class DataStoreTest {
    Connect4Game game;
    String session;

    @Before
    public void initialize() {
        game = new Connect4Game();
        session = "sID131231";
    }

    @Test
    public void testInstanceNotNull(){
        Assert.assertNotNull(DataStore.getInstance());
    }

    @Test
    public void testSaveGameFunctionality(){
        DataStore.getInstance().saveGame(session, game);
        Assert.assertEquals(game, DataStore.getInstance().getGame(session));
    }

    @Test
    public void testGameExistance(){
        Assert.assertNotNull(DataStore.getInstance().getGame("sID222"));
        DataStore.getInstance().saveGame(session, game);
        Assert.assertNotSame(game, DataStore.getInstance().getGame("sID222"));
    }

}
