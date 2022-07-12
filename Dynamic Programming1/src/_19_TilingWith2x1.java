/*
Link: https://www.youtube.com/watch?v=dVT9JeUMMDE&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=26
Question: Tiling With 2 * 1 Tiles in 2 * n Board.
1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
2. You've an infinite supply of 2 * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 */

import java.util.Scanner;

public class _19_TilingWith2x1{

    public static int tilingWithDominoes(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;  // No. of way to tiles up 2*1 is only 1
        dp[2] = 2;  // No. of way to tiles up 2*2 is only 2 i.e either both vertical or both horizontal

        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];  // No. of way to tiles up 2*i
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(tilingWithDominoes(n));
    }
}

/*
Input:
8
Output:
34

 */