import java.util.Scanner;

public class MatrixMultiplication_1 {

/*
Link: https://www.youtube.com/watch?v=0dGuTLr6xT4&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=3

Question: Matrix Multiplication

1. You are given a number n1, representing the number of rows of 1st matrix.
2. You are given a number m1, representing the number of columns of 1st matrix.
3. You are given n1*m1 numbers, representing elements of 2d array a1.
4. You are given a number n2, representing the number of rows of 2nd matrix.
5. You are given a number m2, representing the number of columns of 2nd matrix.
6. You are given n2*m2 numbers, representing elements of 2d array a2.
7. If the two arrays representing two matrices of dimensions n1 * m1 and n2 * m2 can be multiplied, display the contents of prd array as specified in output Format.
8. If the two arrays can't be multiplied, print "Invalid input".

 */
    
    // Time Complexity : O(N^3)
    // Space Complexity : O(1)

    public static void matrixMultiplication(int[][] one, int r1, int c1, int[][] two, int r2, int c2){

        // Checking condition for matrix multiplication  (2*3) & (3*4) = (2*4) i.e (r1*c1) & (r2*c2) = (r1*c2) where c1 = r2
        if (c1 != r2){
            System.out.println("Invalid INPUT");
            return;
        }

        // Making Product Matrix   (2*3) & (3*4) = (2*4) i.e (r1*c1) & (r2*c2) = (r1*c2) where c1 = r2
        int[][] productMatrix = new int[r1][c2];
        for (int i = 0; i < productMatrix.length; i++){
            for (int j = 0; j < productMatrix[0].length; j++){
                for (int k = 0; k < c1; k++){  // k continue till c1 or r2 as both are equal
                    productMatrix[i][j] += one[i][k] * two[k][j];
                }
            }
        }

        // Printing
        for (int i = 0; i < productMatrix.length; i++){
            for (int j = 0; j < productMatrix[0].length; j++){
                System.out.print(productMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Take 1st matrix
        int r1 = scn.nextInt();
        int c1 = scn.nextInt();
        int[][] one = new int[r1][c1];
        for (int i = 0; i < one.length; i++){
            for (int j = 0; j < one[0].length; j++){
                one[i][j] = scn.nextInt();
            }
        }

        // Take 2nd matrix
        int r2 = scn.nextInt();
        int c2 = scn.nextInt();
        int[][] two = new int[r2][c2];
        for (int i = 0; i < two.length; i++){
            for (int j = 0; j < two[0].length; j++){
                two[i][j] = scn.nextInt();
            }
        }
        matrixMultiplication(one, r1, c1, two, r2, c2);
    }
}

/*
Input:
2    // r1
3    // c1
10   // 2*3 = 6 elements
0
0
0
20
0
3    // r2
4    // c2
1    // 3*4 = 12 elements
0
1
0
0
1
1
2
1
1
0
0
Output:
10 0 10 0
0 20 20 40

 */
