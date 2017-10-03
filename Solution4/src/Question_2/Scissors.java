package Question_2;

public class Scissors extends Tool {

    //constructor to set strength for Scissors
    public Scissors(int strength){
        this.setStrength(strength);
        this.type = 's';
    }

    public boolean fight(Tool tool) {
        if (tool.type == 'p')
            this.strength = this.strength * 2;
        if (tool.type == 'r')
            this.strength = this.strength / 2;

        if (this.strength > tool.strength)
            return true;
        else
            return false;
    }
}
