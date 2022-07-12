/*
Link: https://www.youtube.com/watch?v=bUSaenttI24&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=16
Question: Zero One Knapsack
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.
 */

import java.util.Scanner;

public class _9_01Knapsack {

    public static int _01Knapsack(int n, int[] values, int[] weights, int capacity){
        int[][] dp = new int[n + 1][capacity + 1];

        // direction:  -->-->--> from top to bottom
        // leave first row and column as there are only 0, so start from i,j = 1 to avoid array out of bound exception
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                int val = weights[i - 1];  // adjusting index of rows
                // Batting possible only if
                if (j >= val){

                    // Looking both upward (i - 1) and rest run (j - val)
                    if (dp[i - 1][j - val] + values[i - 1] > dp[i - 1][j]){
                        dp[i][j] = dp[i - 1][j - val] + values[i - 1];
                    }else {
                        dp[i][j] = dp[i - 1][j]; // when i doesn't bat
                    }
                }
                // Not batting
                else {
                    dp[i][j] = dp[i - 1][j]; // when i doesn't bat, looking upward
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  // no. of items
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < values.length; i++){
            values[i] = scn.nextInt();
        }
        for (int i = 0; i < weights.length; i++){
            weights[i] = scn.nextInt();
        }
        int capacity = scn.nextInt();
        System.out.println(_01Knapsack(n,values,weights,capacity));
    }
}

/*
Input:
5
15 14 10 45 30
2 5 1 3 4
7

Output:
75

 */