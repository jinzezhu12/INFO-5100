import javax.lang.model.type.DeclaredType;
import java.util.Scanner;

public class GameDriver {
    public static void main(String args[]){
        Scanner stdIn = new Scanner(System.in);
        String playAgain;
        Game game;
        do
        {
            game = new Game(4);   // number of players
            game.playAGame();
            System.out.println("Play another game (y/n)? ");
            playAgain = stdIn.nextLine();
        } while (playAgain.equals("y"));

    }

}
