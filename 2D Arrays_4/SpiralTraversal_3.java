import java.util.Scanner;

public class SpiralTraversal_3 {

/*
Link:

Question: Spiral Traversal

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a.
4. You are required to traverse and print the contents of the 2d array in form of a spiral.

      s   ________
      |  |    e   |
      |  |    |   |
      |  |____|   |
      |___________|

 */

    public static void spiralTraversal(int[][] arr, int nR, int nC) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = arr.length - 1;
        int maxCol = arr[0].length - 1;

        // when we will stop, for this we take
        int totalNoOfElements = nR * nC;
        int count = 0;

        while (count < totalNoOfElements){
            // left wall
            for (int i = minRow, j = minCol; i <= maxRow && count < totalNoOfElements; i++){
                System.out.print(arr[i][j] + "->");
                count++;
            }
            minCol++;

            // bottom wall
            for (int i = maxRow, j = minCol; j <= maxCol && count < totalNoOfElements; j++){
                System.out.print(arr[i][j] + "->");
                count++;

            }
            maxRow--;

            // right wall
            for (int i = maxRow, j = maxCol; i >= minRow && count < totalNoOfElements; i--){
                System.out.print(arr[i][j] + "->");
                count++;
            }
            maxCol--;

            // top wall
            for (int i = minRow, j = maxCol; j >= minCol && count < totalNoOfElements; j--){
                System.out.print(arr[i][j] + "->");
                count++;
            }
            minRow++;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nR = scn.nextInt();
        int nC = scn.nextInt();
        int[][] arr = new int[nR][nC];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        spiralTraversal(arr, nR, nC);
    }
}

/*
Input:
3
5
11            11 12 13 14 15
12            21 22 23 24 25
13            31 32 33 34 35
14
15
21
22
23
24
25
31
32
33
34
35
Output:
11->21->31->32->33->34->35->25->15->14->13->12->22->23->24->

 */