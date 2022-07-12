/*
Link: https://www.youtube.com/watch?v=IV9pbZsi5cc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=21
Question: Count Subsequences of form A^i B^j C^k i.e Count A+ B+ C+ Subsequences
1. You are given a string str.
2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
For abbc -> there are 3 subsequences. abc, abc, abbc
For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
 */

import java.util.Scanner;

public class _14_CountABCSubsequences {

    public static int countABCSubsequences(String str){
        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if (ch == 'a'){
                a = 2 * a + 1;
            } else if (ch == 'b'){
                ab = 2 * ab + a;
            } else if (ch == 'c'){
                abc = 2 * abc + ab;
            }
        }
        return abc;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(countABCSubsequences(str));
    }
}

/*
Input:
abcabc

Output:
7
 */