package Questions;


public class Question_4 {
    public static void test(){
        int n = 2; //number of dices
        int m = 6; //number of faces in a dice
        int x = 3; //destination sum
        int count; //count of possible ways
        count = countNumberOfPossibleWays(n, m, x);
        System.out.println(count);
    }

    public static int countNumberOfPossibleWays(int m, int n, int x){
        int[][] ways = new int[n + 1][x + 1];
        int min = Math.min(x,m);
        for(int i = 1; i<= min; i++) {
            ways[1][i] = 1;
        }

        for (int i  = 2; i <= n ;i++) {
            for (int j  = 1; j <= x ; j++)
                for (int k = 1; k <= m && k < j; k++)
                    ways[i][j] += ways[i-1][j - k];

        }
        return ways[n][x];
    }


}


