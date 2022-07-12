/*
Link: https://www.youtube.com/watch?v=A6mOASLl2Dg&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=2
Question: Climb Stairs
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.
 */

import java.util.Scanner;

public class _1_ClimbStairs {

    public static int countPathsRecursion(int n){
        if (n == 0){  // 0 to 0 is 1 path
            return 1;
        }else if (n < 0) {
            return 0;
        }

        int nMinus1 = countPathsRecursion(n - 1);
        int nMinus2 = countPathsRecursion(n - 2);
        int nMinus3 = countPathsRecursion(n - 3);
        int countPath = nMinus1 + nMinus2 + nMinus3;

        return countPath;
    }

    public static int countPathsMemo(int n, int[] quesBank){
        if (n == 0){  // 0 to 0 is 1 path
            return 1;
        }else if (n < 0) {
            return 0;
        }

        int nMinus1 = countPathsMemo(n - 1, quesBank);
        int nMinus2 = countPathsMemo(n - 2, quesBank);
        int nMinus3 = countPathsMemo(n - 3, quesBank);
        int countPath = nMinus1 + nMinus2 + nMinus3;

        return countPath;
    }

    /*
    Dynamic Programming:
    1. Storage and Meaning
    2. Direction (Smaller problem to Bigger Problem)
    3. Travel and Solve
     */

    public static int countPathsTab(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;  // 0 to 0 is 1 path

        // direction:  -->-->-->
        for (int i = 1; i <= n; i++){
            if (i == 1){
                dp[i] = dp[i - 1];
            }else if (i == 2){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(countPathsRecursion(n));
        System.out.println(countPathsMemo(n, new int[n + 1]));
        System.out.println(countPathsTab(n));
    }
}

/*
Input:
4
Output:
7
7
7

 */