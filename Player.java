/**
   Hand class
*/

public class Player {
   private String name; 
   private Card[] hand = new Card[5];
   private int nCard;
   
   public Player(String cName) {
      this.name = cName;
      this.format();
   }   
   
   //get card  
   public boolean getCard(Card cCard){
      //cannot get cards over 5 times
      if(this.nCard ==5)
      {
       System.err.printf("% has aleady 5 card\n", this.name);
       System.exit(1);
      }
      
      //get a card here
      this.hand[this.nCard] = cCard;
      this.nCard++;
      
      //to validate 21
      return (this.getHandSum() <= 21);
      
   }
   
   //Sum of card
   public int getHandSum(){
      int handSum = 0;
      int cardNum;
      int numAces = 0;
      
      for (int c = 0; c < this.nCard; c++)
      {
      cardNum = this.hand[c].getNumber();
         if (cardNum == 1)
         {
            numAces++;
            handSum += 11;
         }
         else if (cardNum > 10)
         {
            handSum +=10;
         }
         else 
         {
            handSum +=cardNum;
         }
      }
      
      //Make Ace 1
      while(handSum > 21 && numAces > 0) 
      {
         handSum -= 10;
         numAces--;
      }
         
      return handSum;
   }
       
   //Display the result
   
   public void printHand(boolean showFirstCard) {
      System.out.printf("\n%s's cards:\n", this.name);
      for (int c = 0; c < this.nCard; c++) 
      {
         if(c == 0 && !showFirstCard)
         {
            System.out.printf(" [hidden] "); 
         }
         else
         {
            System.out.printf(" %s\n", this.hand[c].toString());
         }
      }
      
   }
   
   public void format()
   {
      for (int i = 0; i < 5; i++) 
      {
         this.hand[i] = null;
      }
      this.nCard = 0;
      
   }      
}   