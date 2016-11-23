package game;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Radu on 22.11.2016.
 */
public class Connect4GameTest {

    @Test
    public void testAddToken(){
        Connect4Game game = new Connect4Game();
        game.addToken(1);
        game.addToken(2);
        game.addToken(3);
        game.addToken(1);
        game.addToken(1);
        game.addToken(1);
//        game.showMatrix();
        Assert.assertTrue(true);
    }
    @Test
    public void testColumnFull(){
        Connect4Game game = new Connect4Game();
        game.addToken(0);
        game.addToken(0);
        game.addToken(0);
        game.addToken(0);
        game.addToken(0);
        game.addToken(0);
        game.addToken(0);
        Assert.assertEquals(game.addToken(0),Message.COLUMN_FULL);
    }
    @Test
    public void testHorizontalLineWin(){
        Connect4Game game = new Connect4Game();
        game.addToken(1);
        game.addToken(1);
        game.addToken(2);
        game.addToken(0);
        Assert.assertFalse(game.isLineWin(6,0));
        game.addToken(3);
        game.addToken(3);
        game.addToken(4);
//        game.showMatrix();
        Assert.assertTrue(game.isLineWin(6,1));
        Assert.assertTrue(game.isLineWin(6,2));
        Assert.assertTrue(game.isLineWin(6,3));
        Assert.assertTrue(game.isLineWin(6,4));
        Assert.assertFalse(game.isMainDiagonalWin(6,4));
        Assert.assertFalse(game.isSecondaryDiagonalWin(6,4));
    }
    @Test
    public void testVerticalLineWin(){
        Connect4Game game = new Connect4Game();
        game.addToken(1);
        game.addToken(1);
        game.addToken(2);
        game.addToken(0);
        game.addToken(3);
        game.addToken(3);
        game.addToken(5);
        game.addToken(3);
        game.addToken(2);
        game.addToken(3);
        game.addToken(6);
        game.addToken(3);
//        game.showMatrix();
        Assert.assertTrue(game.isLineWin(2,3));
        Assert.assertTrue(game.isLineWin(3,3));
        Assert.assertTrue(game.isLineWin(4,3));
        Assert.assertTrue(game.isLineWin(5,3));
    }

    @Test
    public void testSecondaryDiagonalWin(){
        Connect4Game game = new Connect4Game();
        game.addToken(1);
        game.addToken(1);
        game.addToken(2);
        game.addToken(0);
        game.addToken(3);
        game.addToken(3);
        game.addToken(5);
        game.addToken(3);
        game.addToken(2);
        game.addToken(3);
        game.addToken(6);
        game.addToken(2);
//        game.showMatrix();
        Assert.assertTrue(game.isSecondaryDiagonalWin(3,3));
        Assert.assertTrue(game.isSecondaryDiagonalWin(4,2));
        Assert.assertTrue(game.isSecondaryDiagonalWin(5,1));
        Assert.assertTrue(game.isSecondaryDiagonalWin(6,0));
    }

    @Test
    public void testMainDiagonalWin(){
        Connect4Game game = new Connect4Game();
        game.addToken(1);
        game.addToken(1);
        game.addToken(2);
        game.addToken(0);
        game.addToken(3);
        game.addToken(3);
        game.addToken(5);
        game.addToken(3);
        game.addToken(2);
        game.addToken(3);
        game.addToken(6);
        game.addToken(4);
        game.addToken(5);
        game.addToken(2);
        game.addToken(1);
        game.addToken(1);
//        game.showMatrix();
        Assert.assertTrue(game.isMainDiagonalWin(3,1));
        Assert.assertTrue(game.isMainDiagonalWin(4,2));
        Assert.assertTrue(game.isMainDiagonalWin(5,3));
        Assert.assertTrue(game.isMainDiagonalWin(6,4));
    }




}
