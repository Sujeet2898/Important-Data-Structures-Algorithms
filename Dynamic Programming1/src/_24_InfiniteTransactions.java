/*
Link: https://www.youtube.com/watch?v=HWJ9kIPpzXs&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=31
Question: Buy And Sell Stocks - Infinite Transactions Allowed

You have been given stock values/prices for N number of days. Every i-th day signifies the price of a stock on that day. Your task is to find the maximum profit which you can make by buying and selling the stocks.
Note: You may make as many transactions as you want but can not have more than one transaction at a time i.e, if you have the stock, you need to sell it first, and then only you can buy it again.
 */

import java.util.Scanner;

public class _24_InfiniteTransactions {

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