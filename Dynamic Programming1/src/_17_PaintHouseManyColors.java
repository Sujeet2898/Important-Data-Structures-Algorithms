/*
Link: https://www.youtube.com/watch?v=jGywRalvoRw&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=24
Question: Paint House - Many Colors
1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
 */

import java.util.Scanner;

public class _17_PaintHouseManyColors {


    // Time Complexity: O(n^3)

    public static long paintHouseManyColors(int[][] arr, int n){
        int[][] dp = new int[arr.length][arr[0].length];

        // First Row
        for (int j = 0; j < arr[0].length; j++){
            dp[0][j] = arr[0][j];
        }

        // Second row onwards
        for (int i = 1; i < dp.length; i++){ // For houses
            for (int j = 0; j < dp[0].length; j++){ // For colours

                int min = Integer.MAX_VALUE;
                for (int k = 0; k < dp[0].length; k++){
                    if (k != j) {
                        if (dp[i - 1][k] < min) {
                            min = dp[i - 1][k];
                        }
                    }
                }
                dp[i][j] = arr[i][j] + min;
            }
        }

        // Last Row
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < dp[0].length; k++){
            if (dp[n - 1][k] < min) {
                min = dp[n - 1][k];
            }
        }
        return min;
    }

    // Time Complexity: O(n^2)

    public static long paintHouseManyColorsOptimized(int[][] arr, int n){
        int[][] dp = new int[arr.length][arr[0].length];

        int least = Integer.MAX_VALUE;
        int secondLeast = Integer.MAX_VALUE;

        // First Row
        for (int j = 0; j < arr[0].length; j++){
            dp[0][j] = arr[0][j];

            // For array
            if (arr[0][j] <= least){
                secondLeast = least;
                least = arr[0][j];
            }else if (arr[0][j] <= secondLeast){
                secondLeast = arr[0][j];
            }
        }

        // Second row onwards
        for (int i = 1; i < dp.length; i++){ // For houses
            int newLeast = Integer.MAX_VALUE;
            int newSecondLeast = Integer.MAX_VALUE;

            for (int j = 0; j < dp[0].length; j++){ // For colours

                if (least == dp[i - 1][j]){
                    dp[i][j] = secondLeast + arr[i][j];
                }else {
                    dp[i][j] = least +  arr[i][j];
                }

                // For dp
                if (dp[i][j] <= newLeast){
                    newSecondLeast = newLeast;
                    newLeast = dp[i][j];
                }else if (dp[i][j] <= newSecondLeast){
                    newSecondLeast = dp[i][j];
                }
            }

            // Updating
            least = newLeast;
            secondLeast = newSecondLeast;
        }

        return least;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  // No. of houses
        int c = scn.nextInt();  // No. of colours
        int[][] arr = new int[n][c];

        // Loop for all houses
        for (int i = 0; i < arr.length; i++){

            // Loop for all colours
            for (int j = 0; j < arr[0].length; j++){
                // Picking price
                arr[i][j] = scn.nextInt();
            }
        }
        System.out.println(paintHouseManyColors(arr, n));
        System.out.println(paintHouseManyColorsOptimized(arr, n));
    }
}

/*
Input:
4 3
1 5 7
5 8 4
3 2 9
1 2 4

Output:
8
8
 */