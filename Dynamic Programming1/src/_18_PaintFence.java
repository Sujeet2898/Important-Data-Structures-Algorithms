/*
Link: https://www.youtube.com/watch?v=ju8vrEAsa3Q&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=25
Question: Paint Fence
1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive fences have same colors.
 */

import java.util.Scanner;

public class _18_PaintFence {

    public static long paintFence(int n, int k){
        long same = k * 1;
        long diff = k * (k - 1);
        long total = same + diff;

        for (int i = 3; i <= n; i++){
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  // No. of fences
        int k = scn.nextInt();  // No. of colours
        System.out.println(paintFence(n, k));
    }
}

/*
Input:
8
3

Output:
3672

 */