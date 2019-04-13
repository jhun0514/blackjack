/**
   Deck class
*/

import java.util.*;

public class Deck{
   
   private Card[] cards;   
   private int number;    
   //suit array
   private String[] suit = {"Clubs", "Diamonds", "Spades", "Hearts"};
   //for shuffle
   public Deck(){
      this(1,false); 
   }
      
   // Make Deck
   public Deck(int deckNum, boolean x){
   
      this.number = deckNum * 52;
      this.cards = new Card[this.number];
      
      int count = 0;
      
      for(int d = 0; d< deckNum; d++)
      {
          for (int s = 0; s < 4; s++) 
          {  
              for (int n = 1; n<=13; n++) 
              {
                  this.cards[count] = new Card(suit[s], n);
                  count++;    
              }
        
          }
      }   
      
      //Shuffle check
      if (x == true)
      {
         this.shuffle();
      }
   }
   // To avoid duplicate
   public void shuffle(){
      Random random= new Random();
    
      Card index;
    
      int j;
      for (int i = 0; i < this.number; i++) 
      {
         j = random.nextInt(this.number);
         //Swapping duplicates value
         index = this.cards[i];
         this.cards[i] = this.cards[j];
         this.cards[j] = index;
      }
   }
   
   // To get next card           
   public Card dealNextCard(){
   
      //get the top card
      Card first = this.cards[0];
      
      for(int c = 1; c < this.number;  c++)
      {
         this.cards[c-1] = this.cards[c];
      }
      
      this.cards[this.number-1] = null;
      this.number--;
            
      return first;
   
   
   }                                    
}


