import com.sun.javafx.binding.StringFormatter;

public class MyIndexOutOfBound extends IndexOutOfBoundsException{
    public MyIndexOutOfBound(int lowerBoound, int upperBound, int index){
            System.out.println(String.format("Error Message: Index : %d, but Lower bound: %d, Upper bound: %d", index, lowerBoound, upperBound));
    }
}

