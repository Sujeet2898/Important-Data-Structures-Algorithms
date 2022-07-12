/*
Link: https://www.youtube.com/watch?v=hs0lilfJ7C0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=9
Question: Path with Maximum Gold
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
 */

import java.util.Scanner;

public class _5_Goldmine {

    public static int pathWithMaximumGold(int[][] arr, int nR, int nC){
        int[][] dp = new int[nR][nC];

        // direction:  Moving downward from right to left OR Moving upward from right to left
        for (int j = arr[0].length - 1; j >= 0; j--){
            for (int i = 0; i < arr.length; i++){

                // 1. Last Column
                if (j == arr[0].length - 1){
                    dp[i][j] = arr[i][j];
                }
                // 2. First Row
                else if (i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                }
                // 3. Last Row
                else if (i == arr.length - 1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                }
                // 4. Rest Cells
                else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        // Answer will be maximum of all cells of first column
        int max = dp[0][0];
        for (int i = 1; i < dp.length; i++){
            // First Column
            if (dp[i][0] > max){
                max = dp[i][0];
            }
        }
        return max;
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
        System.out.println(pathWithMaximumGold(arr,nR,nC));
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
33

 */