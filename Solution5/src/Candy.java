public class Candy extends DessertItem {

    //declare variables
    private double weight;
    private int unitPrice;
    private int cost;

    public Candy(String name, double weight, int unitPrice){
        super(name);
        this.weight = weight;
        this.unitPrice = unitPrice;
    }

    public int getCost(){
        this.cost = (int)Math.round(this.weight * this.unitPrice);
        return this.cost;
    }

    public int getUnitPrice(){
        return this.unitPrice;
    }

    public double getWeight(){
        return this.weight;
    }
}
