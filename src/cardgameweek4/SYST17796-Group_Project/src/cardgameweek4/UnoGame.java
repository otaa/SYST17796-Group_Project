
package cardgameweek4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public abstract class UnoGame extends Player{
    
    
   
    private final String gameName;
    private ArrayList <Player> players;
	private Collection<Card> myDeck;
	private Collection<Card> myPile;
	private Collection<Player> myPlayers;
	private int myCurrentPlayer;
	private int myPlayDirection;
    
    public UnoGame(String givenName)
    {
        super(givenName);
        gameName = givenName;
        players = new ArrayList();
    }

    
     //return the gameName
     
    public String getGameName() 
    {
        return gameName;
    }
    
     //return the players of this game
    
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    
    public void setPlayers(ArrayList <Player> players) 
    {
        this.players = players;
    }
    
   
    public void play() {
        System.out.println("Welcome to the UNO Game");
        System.out.println("");
    }
    
   
    public abstract void declareWinner();
    
    
    
    public static void main(String[] args)
    {  
        
        ArrayList<Card> playerdeck = new ArrayList<Card>();
        ArrayList<Card> compdeck = new ArrayList<Card>();
        int win; // 0 - no result; 1 - win; -1 - loss. 
        Scanner input;
        Card topCard; // card on top of the "pile"
        int choiceIndex; // Index of chosen card for both player and computer
        String currentColor; // Mainly used for wild cards

        gameLoop:
        while (true)
        {
            playerdeck.clear();
            compdeck.clear();
            win = 0;
            topCard = new Card();
            currentColor = topCard.color;

            draw(7, playerdeck);
            draw(7, compdeck);
            
            //Turns
           for (boolean playersTurn = true; win == 0; playersTurn ^= true)
            {
                choiceIndex = 0;
                System.out.println("\nThe top card is: " + topCard.getTopCard());

                if (playersTurn) /*****Player's turn******/
                {
                    // Displaying user's deck
                    System.out.println("Your turn! Your choices:");
                    for (int i = 0; i < playerdeck.size(); i++)
                    {
                        System.out.print(String.valueOf(i + 1) + ". " + 
                        ((Card) playerdeck.get(i) ).getTopCard() + "\n");
                    }
                    System.out.println(String.valueOf(playerdeck.size() + 1 ) + ". " + "Draw card" + "\n" + 
                                       String.valueOf(playerdeck.size() + 2) + ". " + "Quit");
                    // Repeats every time the user doesn't input a number
                    do
                    {
                        System.out.print("\nPlaease input the number of your choice: ");
                        input = new Scanner(System.in);
                    } while (!input.hasNextInt() );
                    // The choices were incremented to make them seem more natural (i.e not starting with 0)
                    choiceIndex = input.nextInt() - 1;

                    // Taking action
                    if (choiceIndex == playerdeck.size() )
                        draw(1, playerdeck);
                    else if (choiceIndex == playerdeck.size() + 1)
                        break gameLoop;
                    else if ( ((Card) playerdeck.get(choiceIndex)).canPlace(topCard, currentColor) )
                    {
                        topCard = (Card) playerdeck.get(choiceIndex);
                        playerdeck.remove(choiceIndex);
                        currentColor = topCard.color;
                        // Producing the action of special cards                        
                        if (topCard.value >= 10)
                        {
                            playersTurn = false; // Skipping turn

                            switch (topCard.value)
                            {
                                case 12: // Draw 2
                                System.out.println("Drawing 2 cards...");
                                draw(2,compdeck);
                                break;

                                case 13: case 14: // Wild cards                         
                                do // Repeats every time the user doesn't input a valid color
                                {
                                    System.out.print("\nEnter the color you want: ");
                                    input = new Scanner(System.in);
                                } while (!input.hasNext("R..|r..|G....|g....|B...|b...|Y.....|y.....") ); //Something I learned recently
                                if (input.hasNext("R..|r..") )
                                    currentColor = "Red";
                                else if (input.hasNext("G....|g....") )
                                    currentColor = "Green";
                                else if (input.hasNext("B...|b...") )
                                    currentColor = "Blue";
                                else if (input.hasNext("Y.....|y.....") )
                                    currentColor = "Yellow";

                                System.out.println("You chose " + currentColor);
                                if (topCard.value == 14) // Wild draw 4
                                {
                                    System.out.println("Drawing 4 cards...");
                                    draw(4,compdeck);
                                }
                                break;
                            }
                        }
                    } 
                    else {
                        System.out.println("Invalid choice. Turn skipped.");
                    }
                            

                } else //computer's turn 
                {
                    System.out.println("My turn! I have " + String.valueOf(compdeck.size() ) 
                                        + " cards left!" + ((compdeck.size() == 1) ? "...Uno!":"") );
                    // Finding a card to place
                    for (choiceIndex = 0; choiceIndex < compdeck.size(); choiceIndex++)
                    {
                        if ( ((Card) compdeck.get(choiceIndex)).canPlace(topCard, currentColor) ) // Searching for playable cards
                            break; 
                    }

                    if (choiceIndex == compdeck.size() )
                    {
                         System.out.println("I've got nothing! Drawing cards...");
                         draw(1,compdeck);
                    } else 
                    {
                         topCard = (Card) compdeck.get(choiceIndex);
                         compdeck.remove(choiceIndex);
                         currentColor = topCard.color;
                         System.out.println("I choose " + topCard.getTopCard() + " !");

                         // Must do as part of each turn because topCard can stay the same through a round
                         if (topCard.value >= 10)
                         {
                             playersTurn = true; // Skipping turn

                             switch (topCard.value)
                             {
                                 case 12: // Draw 2
                                 System.out.println("Drawing 2 cards for you...");
                                 draw(2,playerdeck);
                                 break;

                                 case 13: case 14: // Wild cards                         
                                 do // Picking a random color that's not none
                                 {
                                     currentColor = new Card().color;
                                 } while (currentColor == "none");

                                 System.out.println("New color is " + currentColor);
                                 if (topCard.value == 14) // Wild draw 4
                                 {
                                     System.out.println("Drawing 4 cards for you...");
                                     draw(4,playerdeck);
                                 }
                                 break;
                             }
                         }
                    }

                    // If decks are empty
                    if (playerdeck.size() == 0)
                        win = 1;
                    else if (compdeck.size() == 0)
                        win = -1;
                }

            } // turns loop end

            //Results
            if (win == 1)
                System.out.println("You win :)");
            else 
                System.out.println("You lose :(");

            System.out.print("\nPlay again? ");
            input = new Scanner(System.in);

            if (input.next().toLowerCase().contains("n") )
                break;
        } // game loop end

        System.out.println("Bye bye");
    }
    // For drawing cards
    public static void draw(int cards, ArrayList<Card> deck)
    {
        for (int i = 0; i < cards; i++)
            deck.add(new Card() );
    }

	
   
    
}

   
        
        
    



