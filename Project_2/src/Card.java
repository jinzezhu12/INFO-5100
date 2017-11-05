
public class Card {
    private int num;
    private int suit;

    public Card(int num, int suit){
        this.num = num;
        this.suit = suit;
    }

    public int getNum(){
        return this.num;
    }

    public int getSuit(){
        return this.suit;
    }

    public int getStrength(){
        return this.num + (this.suit*13);
    }


    public void display(){
        String cardNum = "";
        String suitName = "";

        switch (this.num){
            default: // 2 - 11
                cardNum = Integer.toString(num);
                break;
            case 11:
                cardNum = "Jack";
                break;
            case 12:
                cardNum = "Queen";
                break;
            case 13:
                cardNum = "King";
                break;
            case 14:
                cardNum = "Ace";
                break;
        }
        switch (this.suit) {
            default:
                suitName = "Error";
                break;
            case 0:
                suitName = "Clubs";
                break;
            case 1:
                suitName = "Diamonds";
                break;
            case 2:
                suitName = "Hearts";
                break;
            case 3:
                suitName = "Spades";
                break;
        }

        System.out.println(String.format("%s of %s", cardNum, suitName ));
    }


}
