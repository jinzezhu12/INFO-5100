import java.util.Scanner;

public class printPascalTriangle {
    public static void print(int n) {
        int[] previousRow; // initialize the previous row
        int[] currentRow = {1}; // current row start at '1'

        printArray(currentRow); // print the first row
        previousRow = currentRow;
        //loop starts to form the integer array
        for (int i = 2; i <= n; i++) {
            currentRow = new int[i];
            currentRow[0] = 1; // set the first integer in array to 1
            currentRow[i - 1] = 1; // set the last integer in array to 1
            for (int j = 0; j <= i - 3; j++) {
                currentRow[j + 1] = previousRow[j] + previousRow[j + 1];
            }
            printArray(currentRow);
            previousRow = currentRow;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the row number to form Pascal's triangle: ");
        int row = scanner.nextInt();
        print(row);
    }
}
