
public class Dealer extends Player {
   public Dealer(){
       super("Dealer", 0);
  }
   
   
   public boolean shouldHit(){
      return getHandTotal() < 17;
   }
   
   public Card showHiddenCard(){
       return (getHand().get(0));
   }
   
    
}
