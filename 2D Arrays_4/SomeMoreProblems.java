
1. Largest Row or Column
    -----------------
public class Solution {

    public static void findLargest(int mat[][]){
        boolean isRow = true;
        int largestSum = Integer.MIN_VALUE;
        int num = 0;

        int nRows = mat.length;
        if (nRows == 0) {
            System.out.println("row " + num + " " + largestSum);
            return;
        }
        int mCols = mat[0].length;


        for(int i = 0; i < nRows; i++){
            int rowSum = 0;
            for(int j = 0; j < mCols; j++){
                rowSum += mat[i][j];
            }

            if(rowSum > largestSum){
                largestSum = rowSum;
                num = i;
            }
        }

        for(int j = 0; j < mCols; j++){
            int colSum = 0;
            for(int i = 0; i < nRows; i++){
                colSum += mat[i][j];
            }

            if(colSum > largestSum){
                largestSum = colSum;
                num = j;
                isRow = false;
            }
        }

        if(isRow){
            System.out.println("row " + num + " " + largestSum);
        }else{
            System.out.println("column " + num + " " + largestSum);
        }
    }
}

2. Print Diagonal
--------------------

public class solution {

    public static int R,C;

    public static void PrintDiagonals(int[][] arr, int row, int col) {
        R = row;
        C = col;
        /* through this for loop we choose each element
             of first column as starting point and print
             diagonal starting at it. arr[0][0], arr[1][0]
             ....arr[R-1][0] are all starting points */
        for (int k = 0; k < R; k++){
            System.out.print(arr[k][0] + " ");

            int i = k - 1;    // set row index for next
            // point in diagonal
            int j = 1;       //  set column index for
            // next point in diagonal

            /* Print Diagonally upward */
            while (isValid(i, j)){
                System.out.print(arr[i][j] + " ");

                i--;
                j++;    // move in upright direction
            }
            System.out.println();
        }

        /* through this for loop we choose each element
                of last row as starting point (except the
                [0][c-1] it has already been processed in
                previous for loop) and print diagonal
                starting at it. arr[R-1][0], arr[R-1][1]....
                arr[R-1][c-1] are all starting points */

        // Note : we start from k = 1 to C-1;
        for (int k = 1; k < C; k++){
            System.out.print(arr[R-1][k] + " ");

            int i = R - 2; // set row index for next
            // point in diagonal
            int j = k + 1; // set column index for
            // next point in diagonal

            /* Print Diagonally upward */
            while (isValid(i, j)){
                System.out.print(arr[i][j] + " ");

                i--;
                j++; // move in upright direction
            }
            System.out.println();
        }
    }

    public static boolean isValid(int i, int j){
        if (i < 0 || i >= R || j >= C || j < 0){
            return false;
        }
        return true;
    }

}

3. Art of Reversing
--------------------
public class Solution {
    public static void printreverse(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i].length-1;j>=0;j--)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}

4.  Idempotent Matrix
---------------------

public class solution {

    static int N;

    // Function for matrix multiplication.
    static void multiply(int mat[][], int res[][]){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                res[i][j] = 0;
                for (int k = 0; k < N; k++){
                    res[i][j] += mat[i][k] * mat[k][j];
                }
            }
        }
    }

    // Function to check idempotent
    // property of matrix.
    public static boolean CheckIdempotent(int mat[][], int size){
        N = size;

        // Calculate multiplication of matrix
        // with itself and store it into res.
        int res[][] = new int[N][N];
        multiply(mat, res);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (mat[i][j] != res[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}

