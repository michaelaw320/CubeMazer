/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.DataStructure;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Timothy
 */
public class GameDataTest {
    
    public GameDataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        GameData.loadPlayer("player.xml");
    }
    
    @AfterClass
    public static void tearDownClass() {
        GameData.reset();
    }

    /**
     * Test of reset method, of class GameData.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        GameData.reset();
        int expectedJumlahPlayer = 0;
        int expectedJumlahMap = 0;
        assertEquals(expectedJumlahMap, GameData.getJumlahMap());
        assertEquals(expectedJumlahPlayer, GameData.getJumlahPlayer());
        GameData.loadPlayer("player.xml");
    }

    /**
     * Test of loadPlayer method, of class GameData.
     */
    @Test
    public void testloadPlayer()
    {
        GameData.dataPlayer.clear();
        System.out.println("Before Load");
        GameData.printPlayer();
        GameData.loadPlayer("player.xml");
        System.out.println("After Load");
        GameData.printPlayer();
    }
    
    /**
     * Test of addPlayer method, of class GameData.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        String nama = "Test";
        GameData.addPlayer(nama);
        String namaExpected = "Test";
        int scoreExpected = 0;
        int achievementUnlockedExpected = 0;
        int levelUnlockedExpected = 0;
        Player temp = GameData.dataPlayer.get(GameData.getJumlahPlayer()-1);
        assertEquals(namaExpected, temp.getNama());
        assertEquals(scoreExpected, temp.getScore());
        assertEquals(achievementUnlockedExpected, temp.getAchievmentUnlocked());
        assertEquals(levelUnlockedExpected, temp.getLevelUnlocked());
    }

    /**
     * Test of deletePlayer method, of class GameData.
     */
    @Test
    public void testDeletePlayer() {
        System.out.println("deletePlayer");
        String nama = "Test";
        GameData.addPlayer("Test");
        int jumlahPlayerExpected = GameData.getJumlahPlayer()-1;
        GameData.deletePlayer(nama);
        assertEquals(jumlahPlayerExpected, GameData.getJumlahPlayer());
    }

    /**
     * Test of getIndexPlayer method, of class GameData.
     */
    @Test
    public void testGetIndexPlayer1() {
        System.out.println("getIndexPlayer(player exist)");
        String nama = "dummy";
        int expResult = 0;
        int result = GameData.getIndexPlayer(nama);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetIndexPlayer2() {
        System.out.println("getIndexPlayer(player not exist)");
        String nama = "jack sparrow";
        int expResult = -1;
        int result = GameData.getIndexPlayer(nama);
        assertEquals(expResult, result);
    }
    
}