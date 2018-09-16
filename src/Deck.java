import java.util.Collections;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;

public class Deck {

    private final Stack<Card> deckCards;

    private Deck(){
        this.deckCards = initDeck();
    }

    private Stack<Card> initDeck() {
        final Stack<Card> deckCards = new Stack<>();
        for(final Card.Suit suit : Card.Suit.values()){
            for(final Card.Rank rank : Card.Rank.values()) {
                deckCards.push(Card.getCard(rank, suit));
            }
            //go through all suits and ranks, for each combination retrieve that from Card cache and push it onto the deck. That's where we get all 52 cards
        }

        Collections.shuffle(deckCards);
        return deckCards;

    }
    public static void main(String args[]){
        final Deck deck = new Deck();
        final int numCardsToDeal = 5; //deal entire deck

        //call deck.deal 52 times and print all values
        IntStream.range(0, numCardsToDeal).forEach(value -> System.out.println(deck.deal()));
    }

    //wrap and object that may or may not have a value
    public Optional<Card> deal(){
        return this.deckCards.empty() ? Optional.empty() :
                Optional.of(this.deckCards.pop());
        //if deck is empty, determines what we return from it
        //if not empty, take value from top of deck and wrap it in an Optional
    }



}
