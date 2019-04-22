/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgameweek4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Pysia
 */
public class CardsOnHand {
    final private static int NUMCARDHAND = 7;
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;//the size of the grouping
    
    public CardsOnHand(int givenSize)
    {
        size = givenSize;
    }
    
   
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    
    public int getSize() {
        return size;
    }

    public void setSize(int givenSize) {
        size = givenSize;
    }
    
   /* public static boolean checkCardPlayer(int number){
       if( 7){
           
    }
    public static void main(String[] args) {
        boolean isValid = false;
        boolean cardPlayer = false;
        int number = 0;
        
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Please enter number of cards you have at the start of the game ?");
            number = sc.nextInt();
            if(checkCardPlayer(number)){
                isValid=true;
            }else{
                cardPlayer = false;
            }
        }while(!isValid);
        System.out.println("Number is valid");
        }*/
    }

   

       
    
    



