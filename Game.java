import java.util.Scanner;
import java.util.InputMismatchException;

public class Game {
    
 Deck deck;
 Player player;
 Dealer dealer;
 int currentBet;
 boolean playerBust = false;
 
 public Game(){
     Scanner scanner = new Scanner(System.in);
     System.out.println("Enter Your Name: ");
     String name = scanner.nextLine();
     
     deck = new Deck();
     dealer = new Dealer();
     player = new Player(name, 100);
    
}
  public void play(){
      do{
          playRound();
      } while(player.getBalance() > 0);
      
      System.out.println("Game over, you're out of money!");
  }
   public void playRound(){
       player.clearHand();
       dealer.clearHand();
       deck.reshuffle();
       System.out.println("Your current balance is: " + player.getBalance());
     placeBet();
     dealInitialCards();
     playerTurn();
     dealerTurn();
     determineWinner();
     //So that bust doesnt carry over to next round
     playerBust = false;
 
   }
   //Exception handling Requirement
 public void placeBet(){
    Scanner scanner = new Scanner(System.in);
    int bet = 0;
     do{
         try{
          System.out.println("How much would you like to bet? ");
          bet = scanner.nextInt(); 
         }
         catch(InputMismatchException e){
          System.out.println("Invalid input! Please enter a number.");
          scanner.next(); 
         }  
     }  
     while( bet > player.getBalance() || bet < 0);
     currentBet = bet; 
 }
 
 public void dealInitialCards(){
   // player gets their cards
   player.receiveCard(deck.drawCard());
   player.receiveCard(deck.drawCard());
   
   //prints out cards
   System.out.println("Your hand: " + player.getHand());
   System.out.println("Your total: " + player.getHandTotal());
   
   // dealer gets cards
   dealer.receiveCard(deck.drawCard());
   dealer.receiveCard(deck.drawCard());
   
   // only see dealers first card
   System.out.println("Dealer shows: " + dealer.getHand().get(0));

 }
 
 public void playerTurn(){
     boolean playerStood = false;
     
     Scanner scanner = new Scanner (System.in);
     
     while( player.getHandTotal() < 21 && !playerStood ){
          System.out.println("Would you like to hit or stand?");
          String answer = scanner.nextLine();
          if(answer.toLowerCase().equals("hit")){
              player.receiveCard(deck.drawCard());
              System.out.println("Your hand: " + player.getHand());
              System.out.println("Your total: " + player.getHandTotal());
          }
          if (player.getHandTotal() > 21){
              playerBust = true;
              break;
          }
          else if(answer.toLowerCase().equals("stand")){
         playerStood = true;
     }
         
     }
 }
 
 public void dealerTurn(){
    if(playerBust) return;
    while(dealer.shouldHit()){
        dealer.receiveCard(deck.drawCard());
        System.out.println("Dealer draws: " + dealer.getHand().get(dealer.getHand().size()-1));
    }
    System.out.println("Dealer's final total: " + dealer.getHandTotal());
}
 
 public void determineWinner(){
     if(player.getHandTotal() > 21){
         playerBust = true;
         player.loseBet(currentBet);
         System.out.println("You busted!");
     }
     else if(dealer.getHandTotal() > 21){
         player.winBet(currentBet);
         System.out.println("Dealer busted, you win!");
     }
     else if ( player.getHandTotal() == dealer.getHandTotal()){
         System.out.println("It's a tie!");
     }
     else if( player.getHandTotal() > dealer.getHandTotal()){
         System.out.println(player.getName() + " Wins!"); 
          player.winBet(currentBet);
     }
     else if( dealer.getHandTotal() > player.getHandTotal()){
         System.out.println("Dealer wins!");
         player.loseBet(currentBet);
     }   
 }
 
 
 
 
 
 
 
 
 
 
 
}
