/*
Link: https://www.youtube.com/watch?v=pTQB9wbIpfU&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=32
Question: Buy And Sell Stocks With Transaction Fee - Infinite Transactions Allowed
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are give a number fee, representing the transaction fee for every transaction.
4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
 
 Leetcode same question
 ----------------------
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6 
 
 */

import java.util.Scanner;

public class _25_WithTransactionFeeInfiniteTransactions {

    public static int getMaximumProfit3 (int[] prices, int fee){

        int oldBoughtStateProfit = -prices[0];
        int oldSoldStateProfit = 0;

        for (int i = 1; i < prices.length; i++){
            int newBoughtStateProfit = 0;
            int newSoldStateProfit = 0;

            // Buy Today
            if (oldSoldStateProfit - prices[i] > oldBoughtStateProfit){
                newBoughtStateProfit = oldSoldStateProfit - prices[i];
            }else {
                newBoughtStateProfit = oldBoughtStateProfit;
            }

            // Sell Today
            if (oldBoughtStateProfit + prices[i] - fee > oldSoldStateProfit){
                newSoldStateProfit = oldBoughtStateProfit + prices[i] - fee;
            }else {
                newSoldStateProfit = oldSoldStateProfit;
            }

            // Update for the next level
            oldBoughtStateProfit = newBoughtStateProfit;
            oldSoldStateProfit = newSoldStateProfit;
        }
        return oldSoldStateProfit;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int prices[] = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        int fee = scn.nextInt();
        System.out.println(getMaximumProfit3(prices, fee));
    }
}

/*
    Input:
    3
    10 20 30
    2
    Output:
    18
 */
