/*
Link: https://www.youtube.com/watch?v=3YILP-PdEJA&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=35
Question: Buy And Sell Stocks - K Transactions Allowed
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are given a number k, representing the number of transactions allowed.
3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
 */

import java.util.Scanner;

public class _28_KTransaction {

    public static int getMaximumProfit6 (int[] prices, int k){

        int[][] dp = new int[k + 1][prices.length];

        // Loop for transaction
        for(int t = 1; t <= k; t++){
            int max = Integer.MIN_VALUE;

            // Loop for days
            for (int d = 1; d < prices.length; d++){
                if (dp[t - 1][d - 1] - prices[d - 1] > max){
                    max = dp[t - 1][d - 1] - prices[d - 1];
                }

                if (max + prices[d] > dp[t][d - 1]){
                    dp[t][d] = max + prices[d];
                }else {
                    dp[t][d] = dp[t][d - 1];
                }
            }
        }
        return dp[k][prices.length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(getMaximumProfit6(prices, k));
    }
}

/*
Input:
6
9 6 7 6 3 8
3
Output:
6

 */
