/*
Link: https://www.youtube.com/watch?v=tRpkluGqINc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=11
Question: Target Sum Subsets
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "target".
4. You are required to calculate and print true or false, if there is a subset the elements of which adup to "target" or not.
 */

/*
Total SubSet = 2 ^ No. of elements
SubArray is same as SubString
SubSet is same as SubSequence
 */

import java.util.Scanner;

public class _6_TargetSumSubsets {

    public static boolean targetSumSubsets(int[] arr, int n, int target){
        boolean[][] dp = new boolean[n + 1][target + 1];

        // direction:  -->-->--> from top to bottom
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){

                // 1. First Cell
                if (i == 0 && j == 0){
                    dp[i][j] = true;
                }
                // 2. Rest cells of first row
                else if (i == 0){
                    dp[i][j] = false;
                }
                // 3. Rest cells of first column
                else if (j == 0){
                    dp[i][j] = true;
                }
                // 4. Other rest cells
                else {
                    // With no batting, looking only upward
                    if (dp[i - 1][j] == true){
                        dp[i][j] = true;
                    }
                    // With batting
                    else {
                        int val = arr[i - 1];  // adjusting index of rows

                        // Batting possible only if
                        if (j >= val){

                            // Looking both upward (i - 1) and rest run (j - val)
                            if (dp[i - 1][j - val] == true){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[arr.length][target];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(targetSumSubsets(arr, n , target));
    }
}

/*
Input:
5
4 2 7 1 3
10

Output:
true

 */