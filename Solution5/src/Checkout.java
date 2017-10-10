import sun.security.provider.Sun;

public class Checkout {
    private DessertItem[] myDessertItems;
    private int numberOfItems;
    private final int RECEIPT_WIDTH = 36; // Define the width of the receipt


    public Checkout(){
        myDessertItems = new DessertItem[50];
        numberOfItems = 0;
    }

    public int numberOfItems(){
        return  numberOfItems;
    }

    public void enterItem(DessertItem item){
        this.myDessertItems[numberOfItems] = item;
        numberOfItems++;
    }

    public void clear(){
        for(int i = 0; i < numberOfItems; i++){
            this.myDessertItems[i] = null;
        }
        numberOfItems = 0;
    }

    public int totalCost(){
        int sum = 0;
        for(int i = 0; i < numberOfItems; i++)
            sum += myDessertItems[i].getCost();
        return sum;
    }

    public int totalTax(){
        return (int)Math.round(this.totalCost() * DessertShoppe.TAX_RATE / 100);
    }

    @Override
    public String toString(){
        String s = "";

        s += "          " + DessertShoppe.STORE_NAME + "\n";
        s += "          " + "----------------------" + "\n";

        for(int j = 0; j < numberOfItems; j++) {
            String l = myDessertItems[j].getName(); //name of items
            String p = DessertShoppe.cents2dollarsAndCents(myDessertItems[j].getCost()); //cost of items

            if (myDessertItems[j] instanceof IceCream) {
                //print if ice cream
                while (l.length() < RECEIPT_WIDTH - p.length()) { //align the price to the right
                    l += " ";
                }
                s += l + p + "\n";
            }
            else if (myDessertItems[j] instanceof Sundae){
                //print if Sundae
                s += ((Sundae)myDessertItems[j]).getTopping() + " Sundae with\n";

                while(l.length() < RECEIPT_WIDTH - p.length()){ //align the price to the right
                    l += " ";
                }
                s += l + p + "\n";
            }
            else if (myDessertItems[j] instanceof Candy) { //align the price to the right
                //print if Candy
                s += ((Candy) myDessertItems[j]).getWeight() + " lbs @ " +
                        DessertShoppe.cents2dollarsAndCents(((Candy)myDessertItems[j]).getUnitPrice()) + " /lb.\n";
                while (l.length() < RECEIPT_WIDTH - p.length()) {
                    l += " ";
                }
                s += l + p + "\n";
            } else {
                // print if Cookie
                s += ((Cookie)myDessertItems[j]).getQuantity() + " @ " +
                        DessertShoppe.cents2dollarsAndCents(((Cookie)myDessertItems[j]).getUnitPrice()) + " /dz\n";

                while (l.length() < RECEIPT_WIDTH - p.length()) { //align the price to the right
                    l += " ";
                }
                s += l + p + "\n";
            }
        }

            String line = "\nTax";
            String tax = DessertShoppe.cents2dollarsAndCents(this.totalTax());	// print tax
            while(line.length() <= RECEIPT_WIDTH - tax.length())
                line += " ";
            s += line + tax;

            String totalCost = DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax());	// print total cost
            line = "\nTotal Cost";
            while(line.length() <= RECEIPT_WIDTH - totalCost.length())
                line += " ";
            s += line + totalCost;

            return s;
        }
}
