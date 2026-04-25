
public class Card {
    Suit suit ;
    Rank rank ;
 enum Suit{
     HEARTS, DIAMONDS, SPADES, CLUBS
 }
 
 enum Rank{
     ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
 }
  public Card(Suit suit, Rank rank){
    this.suit = suit;
    this.rank = rank;
  }
  
  public int getValue(){
      switch(this.rank){
          // ace is 11 by default. have to add logic to handle it changing to 1 later
          case ACE: return 11;
          case TWO: return 2;
          case THREE: return 3;
          case FOUR: return 4;  
          case FIVE: return 5;   
          case SIX: return 6;   
          case SEVEN: return 7;   
          case EIGHT: return 8; 
          case NINE: return 9;
          case TEN: return 10;  
          case JACK: return 10;  
          case QUEEN: return 10;
          case KING: return 10;
          
          // enum covers all cases but java doesnt know that so i need this
          default: return 0;
            
                    
      }
      
  }
  
  public String toString(){
      return this.rank + " of " + this.suit;
      
  }
  
 
    
  
}
