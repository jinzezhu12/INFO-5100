package Questions;

public class Question_2 {
    public static void test(){
        int a = arrangeCoins(3);
        System.out.println(a);
    }

    private static int arrangeCoins(int n) {
        if(n < 1)
            return 0;
        for(int i = 1; ;i++){
            n = n - i;
            if(n < 0)
                return i-1;
        }
    }
}
