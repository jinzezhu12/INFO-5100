package Question_2;

import Question_2.Paper;
import Question_2.Rock;
import Question_2.Scissors;

public class RockPaperScissorsGame {

    public static void main(){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);

        System.out.println(s.fight(p) + " , " + p.fight(s));
        System.out.println(p.fight(r) + " , " + r.fight(p));
        System.out.println(r.fight(s) + " , " + s.fight(r));
    }
}
