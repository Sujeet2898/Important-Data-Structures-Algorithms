/*
Link: https://www.youtube.com/watch?v=jgps7MXtKRQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=17
Question: Unbounded Knapsack
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
Note -> Each item can be taken any number of times. You are allowed to put the same item again and again.
 */

import java.util.Scanner;

public class _10_UnboundedKnapsack {

    public static int unboundedKnapsack(int n, int[] values, int[] weights, int capacity){
        int[] dp = new int[capacity + 1];
        dp[0] = 0;  // there is nothing in 0 capacity bag

        for (int i = 0; i < dp.length; i++){
            int max = 0;
            for (int j = 0; j < n; j++){

                if (weights[j] <= i){
                    int remainingBagCap = i - weights[j];
                    int remainingBagVal = dp[remainingBagCap];
                    int totalBagVal = remainingBagVal + values[j];

                    if (totalBagVal > max){
                        max = totalBagVal;
                    }
                }
            }
            dp[i] = max;
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  // no. of items
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < values.length; i++){
            values[i] = scn.nextInt();
        }
        for (int i = 0; i < weights.length; i++){
            weights[i] = scn.nextInt();
        }
        int capacity = scn.nextInt();
        System.out.println(unboundedKnapsack(n,values,weights,capacity));
    }
}

/*
Input:
5
15 14 10 45 30
2 5 1 3 4
7

Output:
100

 */