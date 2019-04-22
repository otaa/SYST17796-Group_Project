package cardgameweek4;

import java.util.Random;
import java.util.Scanner;


public class Card
{
    final private static int MAXCARDS = 108;
    
    // Declaring variables of different data types
    public String color;
    public int value;
    private Random rand;
    private String topCard;
	/**
	 * Constants for representing colours
	 */
	public static final int COLOR_NONE = 0;
	public static final int COLOR_GREEN = 1;
	public static final int COLOR_BLUE = 2;
	public static final int COLOR_RED = 3;
	public static final int COLOR_YELLOW = 4;
	/**
	 * An array of names indexed by the colours above
	 */
	public static final String[] COLOR_NAMES = {"", "Green","Blue","Red","Yellow"};
	protected int myColor;
	private String mySymbol;
    
    // Parameterized Constructor
    public Card(int v, String c)
    {
        value = v;
        color = c; 
    }

    // Method that Creates a random card
    public Card()
    {
        rand = new Random();
        value = rand.nextInt(28); 
        // Assigning value
        if (value >= 14) // Check if value is greater than 14 then value = value - 14;
            value -= 14;
        // Assigning color
        rand = new Random();
        // Switch statement for assigning different colors
        switch(rand.nextInt(4) )
        {
            case 0: color = "Red"; 
                break;
            case 1: color = "Green"; 
                break;
            case 2: color = "Blue"; 
                break;
            case 3: color = "Yellow"; 
                break;
        }
        // If the card is a wild card and value is greater than or equal to 13 then none value is assigned to color variable
        if (value >= 13)
            color = "none";
    }

    // Face method to set the face of the card means what players see such as [Red 2]
    public String getTopCard()
    {
        topCard = "";
        if (color != "none")
        {
             topCard += this.color + " ";
        }
        // Switch sttements to set diffrent faces 
        switch(this.value)
        {
            default:  topCard += String.valueOf(this.value); 
                break;
            case 10:  topCard += "Skip"; 
                break;
            case 11:  topCard += "Reverse"; 
                break;
            case 12:  topCard += "Draw 2"; 
                break;
            case 13:  topCard += "Wild"; 
                break;
            case 14:  topCard += "Wild Draw 4"; 
                break;
        }
         topCard += "";
        return  topCard;
    }

    // To ensure that can we place this card on top of a given card
    // Color should be changed for wild card but card should be same
    public boolean canPlace(Card o, String c)
    {
        if (this.color == c)
            return true;
        else if (this.value == o.value)
            return true;
        else if (this.color == "none") // Wild cards
            return true;
        return false;
    }
    
   public static boolean checkCard(int MAXCARDS)
    {
        
    if (MAXCARDS == 108){ return true;
    }
        
    else {
        return false;
    }
        }
    public static void main(String[] args) {
          boolean isValid=false;
          boolean numberOfCards=false;
          int number = 0;
          Scanner sc = new Scanner(System.in);
          do{
              System.out.println("Please enter number of cards in deck"); 
              number= sc.nextInt();
              if(checkCard(number)){
                  isValid = true;
              }
              else{
                  numberOfCards = false;
              }
          }while(!isValid);
              System.out.println("Valid number of cards");
          }

	/**
	 * Create a card with a given colour and number
	 * colour The card colour. Should be one of COLOUR_NONE, COLOUR_GREEN, COLOUR_BLUE, COLOUR_RED or COLOUR_YELLOW.
	 * number The number on the card
	 * @param color
	 * @param number
	 */
	public Card(int color, int number) {
		// TODO - implement Card.Card
		throw new UnsupportedOperationException();
	}

	/**
	 * Get the colour of the card
	 */
	public int getColor() {
		// TODO - implement Card.getColor
		throw new UnsupportedOperationException();
	}

	/**
	 * Set the colour of the card
	 * @param color
	 */
	public void setColor(int color) {
		// TODO - implement Card.setColor
		throw new UnsupportedOperationException();
	}

	/**
	 * Get the symbol on the card.
	 */
	public String getSymbol() {
		// TODO - implement Card.getSymbol
		throw new UnsupportedOperationException();
	}

	/**
	 * Check whether this card can be played on the given card.
	 * The card to be played on
	 * returns true if either the colors or the symbols match
	 * @param card
	 */
	public boolean canPlayOn(Card card) {
		// TODO - implement Card.canPlayOn
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param game
	 */
	public void play(UnoGame game) {
		// TODO - implement Card.play
		throw new UnsupportedOperationException();
	}

	/**
	 * String representation of the card.
	 */
	public String toString() {
		// TODO - implement Card.toString
		throw new UnsupportedOperationException();
	}
          
}

 
   