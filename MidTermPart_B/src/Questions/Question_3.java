package Questions;

import java.util.Arrays;

public class Question_3 {
    public static void test(){
        int[] a = {5, 0, 1};
        int b = minMoves(a);
        System.out.println(b);
    }

    private static int minMoves(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        int min = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            result += nums[i] - min;
        }
        return result;
    }
}
