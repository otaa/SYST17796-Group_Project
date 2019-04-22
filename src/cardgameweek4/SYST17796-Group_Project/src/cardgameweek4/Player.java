

package cardgameweek4;

 import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author Pysia
 */
public class Player
{
    private String PlayerID;
    
        
    public static void main(String[] args) {
        boolean isValid=false;
        
         char ch;
         int number;
         
         //boolean wantToPlay=false;
        
        Scanner sc = new Scanner(System.in);
        
        do
        {
            System.out.println("Please enter a VALID name, name must have:");
            System.out.println("A length of at least 5");
            System.out.println("At least one digit");
            String name = sc.nextLine();
            System.out.println("Please enter a number of players: ");
            number=sc.nextInt();
            if (checkLength(name) && checkNumber(name) && checkNumberOfPlayers(number))
            {
               isValid=true;
            }
           
        }while(!isValid);
        System.out.println("Valid name and players number, accepted!");
        
    }
    public static boolean checkNumberOfPlayers(int number){
        if(number>=2){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkLength(String name)
    {
        if(name.length()>=5)
        {
            return true;
        }
        return false;
    }
    
    
    
    //checking for number
    public static boolean checkNumber(String name){
       for(int i = 0; i < name.length(); i++){  
    
        if(Character.isAlphabetic(name.charAt(i)) && (Character.isDigit(name.charAt(i)))){
        return true;
        }
       }
       return false;   
    }
    //Create a player. The player's hand is initially empty.
     private String playerID;
	private String myName;
	private Collection<Card> myCards; //the unique ID for this player
    
   
    public Player(String name)
    {
        playerID= name;
    }
    
    
    public String getPlayerID() 
    {
        return playerID;
    }

    
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
   
    public void play() {
        System.out.println("");
    }

	/**
	 * Access the player's name
	 */
	public String getName() {
		// TODO - implement Player.getName
		throw new UnsupportedOperationException();
	}

	/**
	 * Access the player's hand
	 */
	public ArrayList<Card> getCards() {
		// TODO - implement Player.getCards
		throw new UnsupportedOperationException();
	}

	/**
	 * Clear the player's hand
	 */
	public void clearCards() {
		// TODO - implement Player.clearCards
		throw new UnsupportedOperationException();
	}

	/**
	 * Add a card to the player's hand
	 * @param card
	 */
	public void gainCard(Card card) {
		// TODO - implement Player.gainCard
		throw new UnsupportedOperationException();
	}

	/**
	 * Choose a card to play.
	 * @param pileCard
	 */
	public Card playCard(Card pileCard) {
		// TODO - implement Player.playCard
		throw new UnsupportedOperationException();
	}

	/**
	 * The string representation of the player
	 */
	public String toString() {
		// TODO - implement Player.toString
		throw new UnsupportedOperationException();
	}
    
}