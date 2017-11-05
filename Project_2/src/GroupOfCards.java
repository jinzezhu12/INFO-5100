import java.util.ArrayList;

public class GroupOfCards {
    protected ArrayList<Card> cards;
    private int currentSize = 0;

    public GroupOfCards(int num){
        cards = new ArrayList<Card>(num);

    }

    public int getCurrentSize(){
        return cards.size();
    }

    public Card getCard(int i){
        return cards.get(i);
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public Card removeCard(int index){
        return cards.remove(index);
    }

    public void display(){
        for(Card card : cards){
            card.display();
        }
    }


}
