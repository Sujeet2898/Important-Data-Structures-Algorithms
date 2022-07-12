/*
Link: https://www.youtube.com/watch?v=GY0O57llkKQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=33
Question: Buy And Sell Stocks With Cooldown - Infinite Transaction Allowed
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
 */

import java.util.Scanner;

public class _26_WithCoolDownInfiniteTransactions {

    public static int getMaximumProfit4 (int[] prices){

        int oldBoughtStateProfit = -prices[0];
        int oldSoldStateProfit = 0;
        int oldCoolStateProfit = 0;

        for (int i = 1; i < prices.length; i++){
            int newBoughtStateProfit = 0;
            int newSoldStateProfit = 0;
            int newCoolStateProfit = 0;

            // Buy Today
            if (oldCoolStateProfit - prices[i] > oldBoughtStateProfit){
                newBoughtStateProfit = oldCoolStateProfit - prices[i];
            }else {
                newBoughtStateProfit = oldBoughtStateProfit;
            }

            // Sell Today
            if (oldBoughtStateProfit + prices[i] > oldSoldStateProfit){
                newSoldStateProfit = oldBoughtStateProfit + prices[i];
            }else {
                newSoldStateProfit = oldSoldStateProfit;
            }

            // Cool Down
            if (oldSoldStateProfit > oldCoolStateProfit){
                newCoolStateProfit = oldSoldStateProfit;
            }else {
                newCoolStateProfit = oldCoolStateProfit;
            }

            // Update for the next level
            oldBoughtStateProfit = newBoughtStateProfit;
            oldSoldStateProfit = newSoldStateProfit;
            oldCoolStateProfit = newCoolStateProfit;
        }
        return oldSoldStateProfit;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(getMaximumProfit4(prices));
    }
}

/*
    Input:
    3
    10 20 30
    Output:
    20

 */