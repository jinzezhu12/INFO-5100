public class Paper extends Tool {

    //constructor to set strength for Paper
    public Paper(int strength){
        this.setStrength(strength);
        this.type = 'p';
    }

    public boolean fight(Tool tool) {
        if (tool.type == 'r')
            this.strength = this.strength * 2;
        if (tool.type == 's')
            this.strength = this.strength / 2;

        if (this.strength > tool.strength)
            return true;
        else
            return false;
    }


}
