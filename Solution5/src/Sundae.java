import sun.security.provider.Sun;

public class Sundae extends IceCream {
    private String topping;
    private int toppingPrice;
    private int cost;

    public Sundae(String iceCreamName, int iceCreamCost, String topping, int toppingPrice){
        super(iceCreamName, iceCreamCost);
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    public int getCost(){
        cost = this.toppingPrice + super.getCost();
        return cost;
    }

    public String getTopping(){
        return topping;
    }

}
