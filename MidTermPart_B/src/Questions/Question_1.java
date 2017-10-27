package Questions;
import java.util.Arrays;

public class Question_1 {
    public static void test(){
        int[] a = {6, 4, 1, 0, 3, 2};
        int[] b = reverseEventIndices(a);
        System.out.println(Arrays.toString(b));
    }

    private static int[] reverseEventIndices(int[] a) {

        int right = a.length - 1; // set the last index of the integer array
        int median; //set the median of the array to prevent from swapping back
        if(a.length % 2 == 0){
            median = (a.length/2) - 1;
            for (int i = 0; i < median; i++) {
                if ((i % 2) == 0) {
                    int temp = a[i];
                    a[i] = a[right-1];
                    a[right-1] = temp;
                    right -= 2;
                }
            }
        }
        else {
            median = (a.length - 1) / 2;
            for (int i = 0; i < median; i++) {
                if ((i % 2) == 0) {
                    int temp = a[i];
                    a[i] = a[right];
                    a[right] = temp;
                    right -= 2;
                }
            }
        }
        return a;
    }
}
