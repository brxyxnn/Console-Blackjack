
import java.util.Collections;
import java.util.ArrayList;



public class Deck {
    ArrayList<Card> card = new ArrayList <>();
    
 // makes the 52 cards in the deck   
public void buildDeck(){
    for(Card.Suit suit: Card.Suit.values()){
        for(Card.Rank rank: Card.Rank.values()){
            Card newCard = new Card(suit, rank);
            card.add(newCard);
            
        }
        
    }
}
// constructor to build and shuffle automatically when a Deck is created
public Deck(){
    buildDeck();
    Collections.shuffle(card);
}
//removes and returns the top card in the deck
public Card drawCard(){
   return card.remove(0);
        
    
}
//resets and reshuffles for a new round
public void reshuffle(){
    card.clear();
    buildDeck();
    Collections.shuffle(card);
}












}
