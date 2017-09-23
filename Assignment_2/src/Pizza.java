
public class Pizza {

     private String type;
     private double unitPrice;
     private int qty; //quantity of this pizza type
     private int loyaltyPoints;

    public Pizza() {
        this.type = "Barbecue Chicken";
        this.unitPrice = 11.00;
        this.qty = 1;
        this.loyaltyPoints = 100;
    }

    public Pizza(String type, double unitPrice, int quantity, int loyaltyPoints) {
        this.type = type;
        this.unitPrice = unitPrice;
        this.loyaltyPoints = loyaltyPoints;
        this.qty = quantity;
    }

    public void printPizzaInfo() {
        System.out.println("You ordered a pizza...");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type: ");
        stringBuilder.append(this.type);
        stringBuilder.append(" Unit Price: ");
        stringBuilder.append(this.unitPrice);
        stringBuilder.append(" Quantity: ");
        stringBuilder.append(this.qty);
        stringBuilder.append(" Loyalty points: ");
        stringBuilder.append(this.loyaltyPoints);

        System.out.println(stringBuilder.toString());
    }

    public double calculatePrice(){

        return this.unitPrice*this.qty;
    }

}
