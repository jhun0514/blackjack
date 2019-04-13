/**
   Card class
*/

public class Card
{
   private String randomSuit;
   private int cardNumber;
   
   //Constructor
   public Card(String cSuit, int cNumber)
   {
      this.randomSuit = cSuit;
      this.cardNumber = cNumber;
   }
   
   //return the value of number of card
   public int getNumber()
   {
      return cardNumber;
   }
   
   //Convert number to name
   public String toString()
   {
   String name = " ";
   
   switch(this.cardNumber){
   
   case 1:
      name = "Ace";
      break;
   
   case 2:
      name = "Two";
      break;
   
   case 3:
      name = "Three";
      break;
   
   case 4:
      name = "Four";
      break;
   
   case 5:
      name = "Five";
      break;   

   case 6:
      name = "Six";
      break;
   
   case 7:
      name = "Seven";
      break;
   
   case 8:
      name = "Eight";
      break;   

   case 9:
      name = "Nine";
      break;   

   case 10:
      name = "Ten";
      break;   

   case 11:
      name = "Jack";
      break;   

   case 12:
      name = "Queen";
      break;   

   case 13:
      name = "King";
      break;   
      
    }
    return name + " of " + randomSuit.toString();
  }
}