import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class Card {

    private final Rank rank; //Jack, Queen, King, Ace, etc
    private final Suit suit; //hearts, spades, diamonds, clubs

    private final static Map<String, Card> CARD_CACHE = initCache();

    private static Map<String, Card> initCache(){

        final Map<String, Card> cache = new HashMap<>();
        for(final Suit suit : Suit.values()){
            for(final Rank rank : Rank.values()){
                cache.put(cardKey(rank, suit), new Card(rank, suit));
            }
        }
        return Collections.unmodifiableMap(cache); //map cannot be mutated
    }

    public static Card getCard(final Rank rank,
                        final Suit suit){
        final Card card = CARD_CACHE.get(cardKey(rank, suit));

        if(card != null){
            return card;
        }
        throw new RuntimeException("Invalid card!" + rank + " " + suit);
    }

    private static String cardKey(final Rank rank,
                                  final Suit suit){
        return rank + "of " + suit; //given some rank and some suit, produce this string for identifying card
    }

    private Card(final Rank rank,
                 final Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString(){
        return String.format("%s of %s", this.rank, this.suit);
    }

    enum Suit{
        DIAMONDS,
        CLUBS,
        HEARTS,
        SPADES
    }
    enum Rank{
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private final int rankValue;

        Rank(final int rankValue){
            this.rankValue = rankValue;
        }
    };



}
