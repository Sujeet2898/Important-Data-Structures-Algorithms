/*
Link: https://www.youtube.com/watch?v=yc0LunmJA1A&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=14
Question: Coin Change Permutations
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the number of permutations of the n coins using which the amount "amt" can be paid.

Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be used for many installments in payment of "amt"
Note2 -> You are required to find the count of permutations and not combinations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same combination. You should treat them as 3 and not 1.
 */

import java.util.Scanner;

public class _8_CoinChangePermutations {

    public static int coinChangePermutations(int[] arr, int amount){
        int[] dp = new int[amount + 1];
        dp[0] = 1;     // No buy or sell is also one way

        // Outer loop is for dp instead of arr, so that Loop for Permutation can be created
        for (int i = 1; i < dp.length; i++) {

            // Checking all coins at each spot
            for (int j = 0; j < arr.length; j++){
                // coins can be checked only if
                if (arr[j] <= i){
                    dp[i] += dp[i - arr[j]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int amount = scn.nextInt();
        System.out.println(coinChangePermutations(arr, amount));
    }
}

/*
Input:
4
2 3 5 6
7

Output:
5

 */