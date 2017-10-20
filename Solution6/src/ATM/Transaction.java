package ATM;

public class Transaction {
    private String transType; //Transaction Type
    private double amount; //Transaction Amount

    public Transaction(String transType, double amount){
        this.transType = transType;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransType() {
        return transType;
    }

}
