/*
Link: https://www.youtube.com/watch?v=SHDu0Ufjyk8&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=28
Question: Friends Pairing
1. You are given a number n, representing the number of friends.
2. Each friend can stay single or pair up with any of it's friends.
3. You are required to print the number of ways in which these friends can stay single or pair up.
E.g.
1 person can stay single or pair up in 1 way.
2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.
3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.
 */

import java.util.Scanner;

public class _21_FriendsPairing {

    public static int friendsPairingCombination(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;  // Possible way of pairing one person is 1
        dp[2] = 2;  // Possible way of pairing two persons is 2

        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[ i - 2] * (i - 1);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(friendsPairingCombination(n));
    }
}

/*
Input:
4

Output:
10

 */