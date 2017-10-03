package Question_2;

import Question_2.Tool;

public class Rock extends Tool {

    //constructor to set strength for Rock
    public Rock(int strength){
        this.strength = strength;
        this.type = 'r';
    }

    public boolean fight(Tool tool) {
        if(tool.type == 's')
            this.strength = this.strength * 2;
        if(tool.type == 'p')
            this.strength = this.strength / 2;

        if(this.strength > tool.strength)
            return true;
        else
            return false;

    }
}
