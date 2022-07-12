/*
Link: https://www.youtube.com/watch?v=IiAsqfjhZnY&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=29
Question: Partition Into Subsets
1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34
 */

import java.util.Scanner;

public class _22_PartitionIntoSubsets {

    public static long partitionIntoSubsets(int n, int k) {

        // person is 0 or team is 0 or No.of persons is less than No. of teams
        if (n == 0 || k == 0 || n < k) {
            return 0;
        }

        // There will be only 1 team possible if team is 1 and person is many
        if (k == 1){
            return 1;
        }

        long[][] dp = new long[k + 1][n + 1];
        // loop for teams (rows)
        for (int i = 1; i <= k; i++){
            // loop for persons (columns)
            for (int j = 1; j <= n; j++){

                // 1. No. of persons is less than no. of teams
                if (j < i){
                    dp[i][j] = 0;
                }
                // 2. No. of persons is equal to no. of teams
                else if (j == i){
                    dp[i][j] = 1;
                }
                // 3. No. of persons is greater than no. of teams
                else {
                    dp[i][j] = dp[i][j - 1] * i + dp[i - 1][j - 1];
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  // No. of persons
        int k = scn.nextInt();  // No. of teams
        System.out.println(partitionIntoSubsets(n, k));
    }
}

/*
    Input:
    4
    3
    Output:
    6

 */