import java.util.ArrayList;
import java.util.List;

public class solutionForBonus {
    public static List<Integer> spiralOrder(int[] [] matrix){

        int r = matrix.length; // get the number of rows of the matrix
        int c = matrix[0].length; // get the number of columns of the matrix
        ArrayList<Integer> result = new ArrayList<Integer>();

        int k = 0; // starting row index
        int l = 0; // starting column index
        int i;

        while (k < r && l < c){
            // Print the first row from the remaining rows
            for (i = l; i < c; ++i)
            {
                result.add(matrix[k][i]);
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < r; ++i)
            {
                result.add(matrix[i][c-1]);
            }
            c--;

            // Print the last row from the remaining rows */
            if ( k < r)
            {
                for (i = c-1; i >= l; --i)
                {
                    result.add(matrix[r-1][i]);
                }
                r--;
            }

            // Print the first column from the remaining columns */
            if (l < c)
            {
                for (i = r-1; i >= k; --i)
                {
                   result.add(matrix[i][l]);
                }
                l++;
            }

        }
        return result;
    }
}
