/*
Link: https://www.youtube.com/watch?v=HWJ9kIPpzXs&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=31
Question: Buy And Sell Stocks - Infinite Transactions Allowed

You have been given stock values/prices for N number of days. Every i-th day signifies the price of a stock on that day. Your task is to find the maximum profit which you can make by buying and selling the stocks.
Note: You may make as many transactions as you want but can not have more than one transaction at a time i.e, if you have the stock, you need to sell it first, and then only you can buy it again.

Leetcode same Question
----------------------
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4

*/

import java.util.Scanner;

public class _24_InfiniteTransactions {
    
    // Time Complexity: O(N) --> Where N is the size of prices array. 
    // Space Complexity: O(1) --> We do not use any extra space. 

    public static int getMaximumProfit2 (int[] prices){

        int buyingDate =  0;
        int sellingDate =  0;
        int profit =  0;

        for (int i = 1; i < prices.length; i++){

            // During increment
            if (prices[i] >= prices[i - 1]){
                sellingDate++;
            }
            // During decrement
            else {
                // First collect stockProfit
                profit += prices[sellingDate] - prices[buyingDate];
                // Make the both date as current
                buyingDate = sellingDate = i;
            }
        }
        // Collecting the last stockProfit
        profit += prices[sellingDate] - prices[buyingDate];

        return profit;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int prices[] = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(getMaximumProfit2(prices));
    }
}

/*
    Input:
    3
    1 2 3
    Output:
    2

    Input:
    7
    1 2 3 4 5 6 7
    Output:
    6
 */
