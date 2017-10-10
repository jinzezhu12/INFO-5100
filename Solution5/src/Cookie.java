public class Cookie extends DessertItem {

    private int quantity;
    private int unitPrice;
    private int cost;

    public Cookie(String name, int quantity, int unitPrice) {
        super(name);
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getCost(){
        cost = (int)Math.round(quantity / 12.0 * unitPrice);
        return cost;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getUnitPrice(){
        return unitPrice;
    }
}
