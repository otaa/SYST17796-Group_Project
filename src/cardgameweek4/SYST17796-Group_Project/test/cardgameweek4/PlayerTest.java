/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgameweek4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pysia
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Player.
     */
   

    /**
     * Test of checkNumberOfPlayers method, of class Player.
     */
    @Test
    public void testCheckNumberOfPlayersGoood() {
        System.out.println("checkNumberOfPlayers good");
        int number = 4;
        boolean expResult = true;
        boolean result = Player.checkNumberOfPlayers(number);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testCheckNumberOfPlayersBad() {
        System.out.println("checkNumberOfPlayers bad");
        int number = 1;
        boolean expResult = false;
        boolean result = Player.checkNumberOfPlayers(number);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testCheckNumberOfPlayersBoudaries() {
        System.out.println("checkNumberOfPlayers good");
        int number = 2;
        boolean expResult = true;
        boolean result = Player.checkNumberOfPlayers(number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkLength method, of class Player.
     */
    @Test
    public void testCheckLengthGood() {
        System.out.println("checkLength good");
        String name = "player";
        boolean expResult = true;
        boolean result = Player.checkLength(name);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testCheckLengthBad() {
        System.out.println("checkLength bad");
        String name = "mat";
        boolean expResult = false;
        boolean result = Player.checkLength(name);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testCheckLengthBoundaries() {
        System.out.println("checkLength boundaries");
        String name = "nickolav";
        boolean expResult = true;
        boolean result = Player.checkLength(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkNumber method, of class Player.
     */
    @Test
    public void testCheckNumberGood() {
        System.out.println("checkNumber good");
        String name = "player1";
        boolean expResult = true;
        boolean result = Player.checkNumber(name);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testCheckNumberBad() {
        System.out.println("checkNumber bad");
        String name = "player";
        boolean expResult = false;
        boolean result = Player.checkNumber(name);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testCheckNumberBoundaries() {
        System.out.println("checkNumber boundaries");
        String name = "player15";
        boolean expResult = true;
        boolean result = Player.checkNumber(name);
        assertEquals(expResult, result);
       
    }

    
    
    
}
