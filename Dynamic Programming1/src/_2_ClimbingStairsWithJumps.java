/*
Link: https://www.youtube.com/watch?v=uNqoQ0sNZCM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=3
Question: Climb Stairs With Variable Jumps
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given an array of n numbers, where ith element's value represents - till how far from the step you could jump to in a single move.
   You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.
 */

import java.util.Scanner;

public class _2_ClimbingStairsWithJumps {

    public static int climbingStairsJumps(int[] arr, int n){
        int[] dp = new int[n + 1];
        dp[n] = 1;  // n to n is 1 path

        // direction:  <--<--<--
        for (int i = n - 1; i >= 0; i--){
            for (int j = 1; j <= arr[i] && i + j < dp.length; j++){
                dp[i] += dp[i + j];
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
        System.out.println(climbingStairsJumps(arr, n));
    }
}

/*
Input:
10
3 3 0 2 1 2 4 2 0 0

Output:
5

 */