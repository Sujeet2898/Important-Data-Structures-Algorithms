/*
Link: https://www.youtube.com/watch?v=_c_R-uIi-zU&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=27
Question: Tiling with M x 1 Tiles
1. You are given a number n and a number m separated by line-break representing the length and breadth of a m * n floor.
2. You've an infinite supply of m * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 */

import java.util.Scanner;

public class _20_TilingWithMx1Tiles {

    public static int tilingWithMx1Tiles(int n, int m){
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++){

            if (i < m){
                dp[i] = 1;  // No. of way to tiles up M*i where i less than M is only 1 i.e all vertical
            }else if (i == m){
                dp[i] = 2;  // No. of way to tiles up M*i where i equal to M is only 2 i.e either all vertical or all horizontal
            }else {
                dp[i] = dp[i - 1] + dp[i - m];  // No. of way to tiles up m*n
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  // no. of m*1 tiles i.e m*n tiles
        int m = scn.nextInt();  // m*1 tile
        System.out.println(tilingWithMx1Tiles(n, m));
    }
}


/*
Input:
39
16

Output:
61

 */