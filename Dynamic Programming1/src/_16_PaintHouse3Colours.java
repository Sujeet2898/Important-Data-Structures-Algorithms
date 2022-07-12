/*
Link: https://www.youtube.com/watch?v=kh48JLieeW8&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=23
Question: Paint House
1. You are given a number n, representing the number of houses.
2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
 */

import java.util.Scanner;

public class _16_PaintHouse3Colours {

    public static long paintHouse(int[][] arr, int n){
        long[][] dp = new long[n][3];
        dp[0][0] = arr[0][0]; // 1st house with red colour
        dp[0][1] = arr[0][1]; // 1st house with blue colour
        dp[0][2] = arr[0][2]; // 1st house with green colour

        // Now start loop from 2nd house to last house
        for (int i = 1; i < arr.length; i++){

            // Painting with red colour
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);

            // Painting with blue colour
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);

            // Painting with green colour
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        // Answer is minimum of 3 colours of last house
        long ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  // No. of houses
        int[][] arr = new int[n][3];  // 3 colours

        // Loop for all houses
        for (int i = 0; i < arr.length; i++){

            // Loop for 3 colours for each house
            for (int j = 0; j < arr[0].length; j++){
                // Picking price
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println(paintHouse(arr, n));
    }
}

/*
Input:
4
1 5 7
5 8 4
3 2 9
1 2 4

Output:
8

 */