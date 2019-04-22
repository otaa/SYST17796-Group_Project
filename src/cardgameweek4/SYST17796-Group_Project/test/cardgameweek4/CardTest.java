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
public class CardTest {
    
    public CardTest() {
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
     * Test of getTopCard method, of class Card.
     */
    @Test
    public void testGetTopCardGood() {
        System.out.println("getTopCard good");
        Card instance = new Card();
        String expResult = "Yellow 1";
        String result = instance.getTopCard();
        assertEquals(expResult, result);
        
    }
@Test
    public void testGetTopCardBad() {
        System.out.println("getTopCard bad");
        Card instance = new Card();
        String expResult = "Pink";
        String result = instance.getTopCard();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testGetTopCardBoundaries() {
        System.out.println("getTopCard boundaries");
        Card instance = new Card();
        String expResult = "Yellow 3";
        String result = instance.getTopCard();
        assertEquals(expResult, result);
        
    }
   

    /**
     * Test of checkCard method, of class Card.
     */
    @Test
    public void testCheckCardGood() {
        System.out.println("checkCard good");
        int MAXCARDS = 108;
        boolean expResult = true;
        boolean result = Card.checkCard(MAXCARDS);
        assertEquals(expResult, result);
       
    }
    
   @Test
    public void testCheckCardBad() {
        System.out.println("checkCard bad");
        int MAXCARDS = 0;
        boolean expResult = false;
        boolean result = Card.checkCard(MAXCARDS);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheckCardBoundaries() {
        System.out.println("checkCard");
        int MAXCARDS = 108;
        boolean expResult = true;
        boolean result = Card.checkCard(MAXCARDS);
        assertEquals(expResult, result);
        
    }

    
    
}
