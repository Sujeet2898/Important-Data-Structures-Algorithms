/*
Link: https://www.youtube.com/watch?v=BzTIOsC0xWM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=7
Question: Min Cost In Maze Traversal
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
7. You are required to traverse through the matrix and print the cost of path which is least costly.
 */

import java.util.Scanner;

public class _4_MinimumCostPath {

    public static int minimumCostPath(int[][]arr, int nR, int nC){
        int[][] dp = new int[nR][nC];

        // direction:  <--<--<-- from bottom to upward
        for (int i = dp.length - 1; i >= 0; i--){
            for (int j = dp[0].length - 1; j >= 0; j--){

                // 1. Last Cell
                if (i == dp.length - 1 && j == dp[0].length - 1){
                    dp[i][j] = arr[i][j];
                }
                // 2. Last Row
                else if (i == dp.length - 1){
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                }
                // 3. Last Column
                else if (j == dp[0].length - 1){
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                }
                // 4. Rest Cells
                else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
                }
            }
        }
        return dp[0][0];
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
        System.out.println(minimumCostPath(arr,nR,nC));
    }
}

/*
Input:
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

Output:
23

 */