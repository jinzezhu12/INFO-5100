/*
    This is a deck which has all the cards ready to be dealt
    its default number of card is 52
 */
import java.util.Collections;

public class Deck extends GroupOfCards{
    public static final int TOTAL_CARDS = 52;

    public Deck(){
        super(TOTAL_CARDS);
        Card card;

        for (int i=0; i<TOTAL_CARDS; i++)
        {
            card = new Card((2 + i%13), i/13);
            addCard(card);
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card dealCard(){
        return  cards.remove(0);
    }

}
