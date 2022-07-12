/*
Link: https://www.youtube.com/watch?v=4YjEHmw1MX0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=30
Question: Buy And Sell Stocks - One Transaction Allowed
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.
 */

import java.util.Scanner;

public class _23_OneTransaction {

    public static int getMaximumProfit1 (int[] prices){

        int leastSoFar = Integer.MAX_VALUE;
        int overAllProfit = 0;
        int profitIfSoldToday = 0;

        for (int i = 0; i < prices.length; i ++){
            if (prices[i] < leastSoFar){
                leastSoFar = prices[i];
            }

            profitIfSoldToday = prices[i] - leastSoFar;

            if (profitIfSoldToday > overAllProfit){
                overAllProfit = profitIfSoldToday;
            }
        }
        return overAllProfit;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int prices[] = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(getMaximumProfit1(prices));
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