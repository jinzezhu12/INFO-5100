import java.util.ArrayList;
import java.util.Collection;

public class Customer {
    private String name;
    double totalPrice;

    public  Customer(){
        this.name = "Zezhu - Store Manager";
        this.totalPrice = 0;
    }

    public Customer(String name, double totalPrice){
        this.name = name;
        this.totalPrice = totalPrice;
    }
}
