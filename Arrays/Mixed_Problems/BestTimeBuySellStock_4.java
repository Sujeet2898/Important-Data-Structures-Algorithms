package Mixed_Problems;

import java.util.Scanner;

public class BestTimeBuySellStock_4 {

    /*
    Problem Statement: Best Time to Buy and Sell Stock
    You have been given stock values/prices for N number of days. Every i-th day signifies the price of a stock on that day. Your task is to find the maximum profit which you can make by buying and selling the stocks.
    Note: You may make as many transactions as you want but can not have more than one transaction at a time i.e, if you have the stock, you need to sell it first, and then only you can buy it again.
     */

    // 1 . Best Time to Buy and Sell Stocks - One Transaction Allowed
    // Link: https://www.youtube.com/watch?v=4YjEHmw1MX0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=30

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

   /**
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int prices[] = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(getMaximumProfit1(prices));
    }
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

   // 2. Best Time to Buy and Sell Stocks - Infinite Transactions Allowed
   // Link: https://www.youtube.com/watch?v=HWJ9kIPpzXs&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=31

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

   /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int prices[] = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(getMaximumProfit2(prices));
    }
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

   // 3. Best Time to Buy and Sell Stocks with Transaction Fee and Infinite Transactions
   // Link: https://www.youtube.com/watch?v=pTQB9wbIpfU&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=32

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

   /**

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
    Input:
    3
    10 20 30
    2
    Output:
    18

    */

   // 4. Best Time to Buy and Sell Stocks with Cool down and Infinite Transactions
   // Link: https://www.youtube.com/watch?v=GY0O57llkKQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=33

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

   /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(getMaximumProfit4(prices));
    }
    Input:
    3
    10 20 30
    Output:
    20

    */

   // 5. Best Time to Buy and Sell Stocks - Two Transaction Allowed
   // Link: https://www.youtube.com/watch?v=wuzTpONbd-0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=34

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

   /**
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(getMaximumProfit5(prices));
    }
    Input:
    3
    10 20 30
    Output:
    20

    */

   // 6. Best Time to Buy and Sell Stocks - K Transaction Allowed
   // Link: https://www.youtube.com/watch?v=3YILP-PdEJA&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=35
   // timeSpan: 33:40 for optimized code of O(n^2) instead of O(n^3)

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

/**
Input:
6
9 6 7 6 3 8
3
Output:
6
 */

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
3
10 20 30
1
Output:
20

 */