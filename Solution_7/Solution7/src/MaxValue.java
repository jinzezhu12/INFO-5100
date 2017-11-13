import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MaxValue extends Thread {
    private int lo, hi;
    private int[] arr;
    private int max;

    public MaxValue(int[] arr, int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }

    @Override
    public void run() {
        max = arr[0];

        for (int i = lo; i < hi; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
    }

    private static int findMax(int[] arr) throws InterruptedException {
        int len = arr.length;
        int ans = 0;
        ArrayList<Integer> maxList = new ArrayList<>();

        //create and start 4 threads
        MaxValue[] ts = new MaxValue[4];
        for (int i = 0; i < 4; i++){
            ts[i] = new MaxValue(arr, (i*len) / 4,((i+1) * len /4));
            ts[i].start();
        }

        //wait for the threads to finish finding max value
        for(int i = 0; i < 4; i++){
            ts[i].join();
            maxList.add(ts[i].max);
        }
        return Collections.max(maxList);
    }


    public static void main() throws InterruptedException {
        Random rd = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(1000)+1;
            System.out.println(String.format("Number *%d* is added to the array",arr[i]));
        }

        int max = findMax(arr);

        System.out.println("The max value of this integer array is " + max);
    }
}

