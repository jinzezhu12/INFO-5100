public class Trick extends GroupOfCards{
    private int winner;
    private Card winningCard;
    private boolean hearts = false;
    private boolean queen = false;

    public Trick(int players){
        super(2* players-1);
    }

    public int getWinner() {
        return winner;
    }

    public Card getWinningCard(){
        return winningCard;
    }

    public boolean getHearts() {
        return hearts;
    }

    public boolean getQueen(){
        return queen;
    }

    public void update(int playerNum, Card card){
        if(isWinner(card)){
            winner = playerNum;
            winningCard = card;
        }
        if(card.getSuit() == 2)
            hearts = true;
        if(card.getSuit() == 3 && card.getNum() == 12)
            queen = true;

        addCard(card);
    }

    private boolean isWinner(Card card){
        if(winningCard != null && (card.getSuit() != winningCard.getSuit() || card.getNum() <=winningCard.getNum())){
            return false;
        }
        return true;
    }
}
