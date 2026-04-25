import java.util.ArrayList;


public class Player {
    ArrayList <Card> hand = new ArrayList<>();
    String name = null;
    int balance;
    
    
 public Player(String name, int balance){
     this.name = name;
     this.balance = balance;  
 }
 public String getName(){
     return this.name;
 }
 public int getBalance(){
     return this.balance;
 }
 public ArrayList<Card> getHand(){
     return this.hand;
 }
 public void winBet(int amount){
     balance += amount;
 }
 public void loseBet(int amount){
     balance -= amount;
 }
 
 public void receiveCard(Card card){
    hand.add(card); 
 }
 
 public int getHandTotal(){
   int total = 0;
   for (Card c: hand){
       total += c.getValue();
   }
   return calculateTotal(hand, total);
 }
 
 public int calculateTotal(ArrayList<Card> hand, int total){
         if (total <= 21){
             return total; // base case 1 Total is 21 or under and we're good
         }
         for( Card c: hand){
             if(c.getValue() == 11){
                 return calculateTotal(hand, total - 10); // recursive case
             }
         }
         return total; // base case 2 where no aces are found
         
 }
 
 
 public void clearHand(){
     hand.clear();
 }
}

