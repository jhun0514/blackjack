/**
   BlackJack program
*/

import javax.swing.JOptionPane;
import java.io.*;


public class BlackJackDemo{

   public static void main(String[] args){
      String input, answer, input2,get;
      boolean pTurn = false, dTurn = false;
      
      do{
         //reset
         pTurn = false;
         dTurn = false;
            
         //Making deck
         Deck deck = new Deck(1,true); 
         
         //Making players
         Player player = new Player("Player");
         Player dealer = new Player("Dealer");
         
         //Giving cards
         for(int i = 0; i < 2; i++)
         {
            player.getCard(deck.dealNextCard());
            dealer.getCard(deck.dealNextCard());      
         }
         
         //Display cards
         JOptionPane.showMessageDialog(null,"Welcome to BlackJack Simulator!\n" +
                                    "Press OK to start");
         JOptionPane.showMessageDialog(null,"Cards are given to Player and Dealer.");
         player.printHand(true);
         dealer.printHand(false);
         
         if (player.getHandSum() == 21)
         {
            player.printHand(true);
            dealer.printHand(true);
            JOptionPane.showMessageDialog(null,"Player got Black Jack!\n" +
                                    "Player win !!");
            
            pTurn = true;
            dTurn = true;
         }
         
         else if (dealer.getHandSum() == 21)
         {
            player.printHand(true);
            dealer.printHand(true);
            JOptionPane.showMessageDialog(null,"Dealer got Black Jack!\n" +
                                    "Dealer win :(");
            
            pTurn = true;
            dTurn = true;
         }
         
         //Playing game
         while (!pTurn || !dTurn)
         {
            if(!pTurn)
            {
               //Asking about playing again
               input = JOptionPane.showInputDialog("Do you want to Hit or Stay? Enter hit or stay: ");
               answer = input;
               
               while (!answer.equalsIgnoreCase("hit") && !answer.equalsIgnoreCase("stay"))
               {
                  input = JOptionPane.showInputDialog("Please enter correctly. Enter hit or stay: ");
                  answer = input;
               }
               
               //get a next card
               if(answer.compareToIgnoreCase("hit")==0)
               {
                  pTurn = !player.getCard(deck.dealNextCard());
                  if (player.getHandSum() > 21)
                  {
                     player.printHand(true);
                     dealer.printHand(true);
                     JOptionPane.showMessageDialog(null,"Player got over 21\n" +
                                    "Dealer win :(");
                     pTurn = true;
                     dTurn = true;
                  }
                  else
                     player.printHand(true); 
               }
               
               else
               {
                  pTurn = true;
               }  
            }
               
            if(!dTurn) 
            {
               //to get cards util 17
               if(dealer.getHandSum() < 17)
               {
                  JOptionPane.showMessageDialog(null,"The Dealer takes the card");
                  dTurn =!dealer.getCard(deck.dealNextCard());
                  //dealer over 21
                  if (dealer.getHandSum() > 21)
                  {
                     player.printHand(true);
                     dealer.printHand(true);
                     JOptionPane.showMessageDialog(null,"Dealer got over 21\n" +
                                       "Player win !!");
                     pTurn = true;
                     dTurn = true;
                  }
                  dealer.printHand(false);                  
               }
               
               else
               {
                  JOptionPane.showMessageDialog(null,"The Dealer stays");
                  dTurn = true;
               }  
            }             
         }
         
         if (dealer.getHandSum() <= 21 && player.getHandSum() <= 21)
         {
            //Display result   
            player.printHand(true);
            dealer.printHand(true);
              
            int playerSum = player.getHandSum();
            int dealerSum = dealer.getHandSum();
              
            if(playerSum > dealerSum)
            {
               JOptionPane.showMessageDialog(null,"Player's value is bigger than dealer!\n"+
                                       "Player win!!");
            }
            
            else if(playerSum == dealerSum)
            {
               JOptionPane.showMessageDialog(null,"It's tie. So, Dealer win..");
            }
            
            else
            {
               JOptionPane.showMessageDialog(null,"Dealer's value is bigger than player.\n"+
                                       "Dealer win :(");
            }
         }   
         get = JOptionPane.showInputDialog("Do you want to play again?" +
                                       "\n Enter 'yes' or 'no'");
         input2 = get;
         
      }while(input2.equalsIgnoreCase("yes"));
      
      JOptionPane.showMessageDialog(null,"Thank you. Good Bye~!");  
        
      
   }
}