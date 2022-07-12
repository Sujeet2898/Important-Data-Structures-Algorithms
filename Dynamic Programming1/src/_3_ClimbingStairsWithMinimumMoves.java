/*
Link: https://www.youtube.com/watch?v=Zobz9BXpwYE&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=5
Question: Climb Stairs With Minimum Moves
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given an array of n numbers, where ith element's value represents - till how far from the step you could jump to in a single move.  You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of staircase.
Note -> If there is no path through the staircase print null.
 */

import java.util.Scanner;

public class _3_ClimbingStairsWithMinimumMoves {

    public static int climbingStairsMinimumMoves(int[] arr, int n){
        // dp of Integer array in which null represents there is no moves
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;  // n to n is 0 moves

        // direction:  <--<--<--
        for (int i = n - 1; i >= 0; i--){
            if (arr[i] > 0){      // arr[i] = 0 => dp[i] = null

                int min = Integer.MAX_VALUE;

                for (int j = 1; j <= arr[i] && i + j < dp.length; j++){
                    if (dp[i + j] != null){
                        min = Math.min(min, dp[i + j]);
                    }
                }

                if (min != Integer.MAX_VALUE){
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(climbingStairsMinimumMoves(arr, n));
    }
}

/*
Input:
10
3 3 0 2 1 2 4 2 0 0

Output:
4

 */