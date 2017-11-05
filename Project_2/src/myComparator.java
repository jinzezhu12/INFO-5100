import java.util.Comparator;

public class myComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2){
        return card1.getStrength() < card2.getStrength() ? -1 : card1.getStrength() == card2.getStrength() ? 0 : 1;
    }

}
