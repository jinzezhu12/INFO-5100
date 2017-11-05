import java.util.Collections;

public class Hand extends GroupOfCards{
    public final int NUM;
    private int shortest = 0;


    public Hand(int playerNum, int numberOfCards){
        super(numberOfCards);
        NUM = playerNum;

    }

    public void sort(){
        Collections.sort(cards, new myComparator());
    }

    public void setShortest(){
        int num_clubs, num_diamonds, num_spades; // club,diamond,spade lengths

        if ((num_diamonds = count(1)) <= (num_clubs = count(0)))
        {
            shortest = 1;
        }

        // see if spades are shorter and safe
        if ((num_spades = count(3)) <= (count(shortest)) &&
                find(12, 3) < 0 && find(13, 3) < 0 && find (14, 3) < 0)
        {
            shortest = 3;
        }
    }

    public int getShortest() {
        return shortest;
    }

    public Card playACard(Game game, Trick trick)
    {
        Card winningCard;
        int suit = 0;
        int index = -1;
        Card card;

        winningCard = trick.getWinningCard();
        if(winningCard != null)
        {
            suit = winningCard.getSuit();
        }

        // start with first hand
        if (trick.getCurrentSize() == 0)
        {
            if (shortest >= 0)  // have not yet created a void
            {
                index = findHighest(shortest);
                if (index < 0)
                {
                    shortest = -1;
                }
            }
            if (shortest < 0)   // pick lowest in any suit
            {
                index = findLowest(game);
                if (index < 0)
                {
                    System.out.println("Rule Error: forced heart lead");
                    index = findLowest(2);
                }
            } // end if it is the shortest
        }

        // last hand with no bad cards in trick
        else if ((trick.getCurrentSize() == game.PLAYERS - 1)
                && !trick.getHearts() && !trick.getQueen()
                && (index = findLastHigh(suit)) >= 0); // take it!

            // middle hand, or last hand with bad cards in trick
        else if ((index = findHighestBelow(winningCard)) >= 0);
        else if ((index = findMiddleHigh(game, suit)) >= 0);


        else if ((index = find(12, 3)) >= 0); // queen of Spades
        else if ((index = find(14, 3)) >= 0); // Ace of Spaces
        else if ((index = find(13, 3)) >= 0); // King of Spades
        else if ((index = findHighest(2)) >= 0); // heart
        else
        {
            index = findHighest();
        }

        card = removeCard(index);
        trick.update(this.NUM, card);
        game.updateHeartsAndQueen(card);
        return card;
    }

    //**********************************************************

    public int findLowest(int suit)        // find lowest value in hand
    {
        for (int i=getCurrentSize()-1; i>=0; i--)
        {
            if (getCard(i).getSuit() == suit)
            {
                return i;
            }
        }
        return -1;
    }

    //**********************************************************

    private int count(int suit) //count the number of every suit in each player's hand
    {
        int count = 0;

        for (int i=0; i<getCurrentSize(); i++)
        {
            if (getCard(i).getSuit() == suit)
            {
                count++;
            }
        }
        return count;
    }

    //**********************************************************

    // Use this to find special cards in your own hand

    private int find(int num, int suit)
    {
        Card card;

        for (int i=0; i<getCurrentSize(); i++)
        {
            card = getCard(i);
            if (card.getNum() == num && card.getSuit() == suit)
            {
                return i;
            }
        }
        return -1;
    }

    //**********************************************************

    // Use this when following suit but unable to undercut
    // the current trick winner.

    private int findHighest(int suit)
    {
        for (int i=0; i<getCurrentSize(); i++)
        {
            if (getCard(i).getSuit() == suit)
            {
                return i;
            }
        }
        return -1;
    }

    //**********************************************************

    // This finds lowest number in hand, but excludes hearts
    // until hearts has been broken
    // Use this when leading a suit other than your shortest one


    private int findLowest(Game game)
    {
        int low = 15;
        int index = -1;
        int num;
        Card card;

        for (int i=0; i<getCurrentSize(); i++)
        {
            card = getCard(i);
            num = card.getNum();
            if ((num < low) &&
                    (card.getSuit() != 2 || game.getHearts()))
            {
                low = num;
                index = i;
            }
        }
        return index;
    } // end findLowest

    //**********************************************************

    // Start with this for last hand in trick

    private int findLastHigh(int suit)        // avoid own queen
    {
        int index;

        index = findHighest(suit);          // highest in own hand

        // try to avoid playing own queen of spades
        if (index >= 0 && suit == 3 &&
                getCard(index).getNum() == 12 &&
                index + 1 < getCurrentSize() - 1 &&
                getCard(index + 1).getSuit() == 3)
        {
            return (index + 1);  // play spade below queen of spaces
        }
        return index;
    }

    //**********************************************************

    // Start with this for any middle hand

    private int findHighestBelow(Card winningCard)
    {
        int suit = winningCard.getSuit();
        int num = winningCard.getNum();
        int index = findHighest(suit);
        Card card;

        if (index >= 0)
        {
            for (int i=index; i<getCurrentSize(); i++)
            {
                card = getCard(i);
                if (card.getSuit() != suit)
                {
                    index = -1;  // not found
                    break;
                }
                if (card.getNum() < num)
                {
                    index = i;
                    break;
                }
            } // end for
        } // end if index
        return index;
    }

    //**********************************************************


    private int findMiddleHigh(Game game, int suit) // execute this after failure of "findHighest()"
    {
        Card card;
        int index;

        index = findHighest(suit);          // highest in own hand

        if (index >= 0 && suit == 3 && !game.getQueenOfSpades() &&
                getCard(index).getNum() >= 12)
        {
            for (int i=index; i<getCurrentSize(); i++)
            {
                card = getCard(i);
                if (card.getSuit() != suit)  // end of spades, too bad
                {
                    break;  // and use highest
                }
                if (card.getNum() < 12)      // accept Jack or smaller
                {
                    index = i;
                    break;
                }
            } // end for
        } // end if
        return index;
    }

    //**********************************************************

    private int findHighest()  // find highest value card in hand
    {
        int high = 0;
        int index = -1;
        int num;

        for (int i=0; i<getCurrentSize(); i++)
        {
            num = getCard(i).getNum();
            if (num > high)
            {
                high = num;
                index = i;
            }
        }
        return index;
    } // end findHighest

} // end Hand class


