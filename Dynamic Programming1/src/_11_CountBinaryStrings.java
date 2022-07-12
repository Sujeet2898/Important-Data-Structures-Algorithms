/*
Link: https://www.youtube.com/watch?v=nqrXHJWMeBc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=18
Question: Binary Strings with no consecutive 0's
1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
 */

import java.util.Scanner;

public class _11_CountBinaryStrings {

    public static int countBinaryStrings(int n){
        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];

        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= n; i++){
            dp1[i] = dp1[i - 1] + dp0[i - 1];
            dp0[i] = dp1[i - 1];
        }
        return dp1[n] + dp0[n];
    }

    public static int countBinaryString(int n){
        int oldCountZeros = 1;
        int oldCountOnes = 1;

        for (int i = 2; i <= n; i++){
            int newCountZeros = oldCountOnes;
            int newCountOnes = oldCountZeros + oldCountOnes;

            oldCountZeros = newCountZeros;
            oldCountOnes = newCountOnes;
        }
        return oldCountZeros + oldCountOnes;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(countBinaryStrings(n));
        System.out.println(countBinaryString(n));
    }
}

/*
Input:
6
Output:
21
21

 */