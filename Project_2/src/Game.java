public class Game {
    public final int PLAYERS;

    private Deck deck = new Deck();
    private Hand[] players;
    private Trick[] tricks;
    private int numberOfTricks = 0;
    private boolean hearts = false;
    private boolean queenOfSpades = false;

    //**********************************************************

    public Game(int numberOfPlayers)
    {
        int plays;

        this.PLAYERS = numberOfPlayers;
        players = new Hand[PLAYERS];
        plays = Deck.TOTAL_CARDS / PLAYERS;
        for (int i=0; i<PLAYERS; i++)
        {
            players[i] = new Hand(i, plays);
        }
        tricks = new Trick[plays];
    } // end constructor

    //**********************************************************

    public int getNumberOfTricks()
    {
        return numberOfTricks;
    }
    //**********************************************************

    public boolean getHearts()
    {
        return hearts;
    }
    //**********************************************************

    public boolean getQueenOfSpades()
    {
        return queenOfSpades;
    }

    //**********************************************************

    public void playAGame()
    {
        int cardsLeft;
        Hand player;
        int playerNum = 0;
        Card card;
        Trick trick;
        int index;
        int low;
        int num;

        // shuffling the deck
        deck.shuffle();
        cardsLeft = Deck.TOTAL_CARDS - tricks.length * PLAYERS;
        for (int i=0; i<tricks.length; i++)
        {
            for (playerNum=0; playerNum<PLAYERS; playerNum++)
            {
                players[playerNum].addCard(deck.dealCard());
            }
        }
        low = 15;
        for (int i=0; i<PLAYERS; i++)
        {
            players[i].sort();
            players[i].setShortest();  // lead cards from this suit!
            System.out.println("player " + i +
                    " shortest= " + players[i].getShortest());
            players[i].display();
            index = players[i].findLowest(0);
            if (index >= 0)  // this player has a club
            {
                num = players[i].getCard(index).getNum();
                if (num < low)
                {
                    playerNum = i;
                    low = num;
                }
            } // end if index >= 0
        } // end for low

        // loop through all tricks
        for (int i=0; i<tricks.length; i++)
        {
            player = players[playerNum];
            trick = new Trick(PLAYERS);
            tricks[numberOfTricks++] = trick;

            if (numberOfTricks == 1)     // start with lowest club
            {
                index = player.findLowest(0);
                card = player.removeCard(index);
                trick.update(playerNum, card);
            }
            else                         // for all remaining tricks
            {
                card = player.playACard(this, trick);
            }
            System.out.print("\nplayer " + playerNum + "\t");
            card.display();
            for (int j=1; j<PLAYERS; j++)
            {
                playerNum = (playerNum + 1) % PLAYERS;
                player = players[playerNum];
                card = player.playACard(this, trick);
                System.out.print("player " + playerNum + "\t");
                card.display();
            }

            playerNum = trick.getWinner();
            if (numberOfTricks == 1)
            {
                for (; cardsLeft>0; cardsLeft--)
                {
                    // include in first trick but don't change winner
                    card = deck.dealCard();
                    trick.addCard(card);
                    updateHeartsAndQueen(card);
                    System.out.print("undelt card \t");
                    card.display();
                }
            }
        } // end for all tricks

        for (playerNum=0; playerNum<PLAYERS; playerNum++)
        {
            System.out.println("Player " + playerNum + " score= " +
                    computePoints(playerNum));
        }
    } // end playAGame

    //**********************************************************

    public void updateHeartsAndQueen(Card card)
    {
        if (card.getSuit() == 2 && this.hearts == false)
        {
            System.out.println("Hearts is now broken");
            hearts = true;
        }
        if (card.getNum() == 12 && card.getSuit() == 3)
        {
            queenOfSpades = true;
        }
    } // end updateHeartsQueen

    //**********************************************************

    private int computePoints(int playerNum)
    {
        int points = 0;
        Trick trick;
        Card card;

        for (int j=0; j<numberOfTricks; j++)
        {
            trick = tricks[j];
            if (trick.getWinner() == playerNum)
            {
                for (int i=0; i<trick.getCurrentSize(); i++)
                {
                    card = trick.getCard(i);
                    if (card.getNum() == 12 && card.getSuit() == 3)
                    {
                        points += 13;  // queen of spades
                    }
                    else if (card.getSuit() == 2)
                    {
                        points++;      // a heart
                    }
                } // end for cards in trick
            } // end if winner
        } // end for tricks
        return points;
    } // end of computing Points
}
