/*
Link: https://www.youtube.com/watch?v=wuzTpONbd-0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=34
Question: Buy And Sell Stocks - Two Transactions Allowed
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

Leetcode same question
----------------------
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*/

import java.util.Scanner;

public class _27_TwoTransaction {

    public static int getMaximumProfit5 (int[] prices){

        // dpOnTheLeft
        int maxProfitIfSoldToday = 0;
        int leastSoFar = prices[0];
        int[] dpOnTheLeft = new int[prices.length];

        for (int i = 1; i < prices.length; i++){

            // Maintaining leastSoFar
            if (prices[i] < leastSoFar){
                leastSoFar = prices[i];
            }

            // Storing MaxProfitIfSoldUpToToday
            maxProfitIfSoldToday = prices[i] - leastSoFar;
            if (maxProfitIfSoldToday > dpOnTheLeft[i - 1]){
                dpOnTheLeft[i] = maxProfitIfSoldToday;
            }else {
                dpOnTheLeft[i] = dpOnTheLeft[i - 1];
            }
        }

        // dpOnTheRight
        int maxProfitIfBoughtToday = 0;
        int maxAfterToday = prices[prices.length - 1];
        int[] dpOnTheRight = new int[prices.length];

        for (int i = prices.length - 2; i >= 0; i--){

            // Maintaining maxAfterToday
            if (prices[i] > maxAfterToday){
                maxAfterToday = prices[i];
            }

            // Storing MaxProfitIfBoughtUpToToday
            maxProfitIfBoughtToday = maxAfterToday - prices[i];
            if (maxProfitIfBoughtToday > dpOnTheRight[i + 1]){
                dpOnTheRight[i] = maxProfitIfBoughtToday;
            }else {
                dpOnTheRight[i] = dpOnTheRight[i + 1];
            }
        }

        int overAllProfit = 0;
        for (int i = 0; i < prices.length; i++){
            if (dpOnTheLeft[i] + dpOnTheRight[i] > overAllProfit){
                overAllProfit = dpOnTheLeft[i] + dpOnTheRight[i];
            }
        }
        return overAllProfit;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(getMaximumProfit5(prices));
    }
}

/*
    Input:
    3
    10 20 30
    Output:
    20

 */
