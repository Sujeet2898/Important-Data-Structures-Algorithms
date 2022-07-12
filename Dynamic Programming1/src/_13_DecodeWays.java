/*
Link: https://www.youtube.com/watch?v=jFZmBQ569So&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=20
Question: Count Encodings
1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. You are required to calculate and print the count of encodings for the string str.
     For 123 -> there are 3 encodings. abc, aw, lc
     For 993 -> there is 1 encoding. iic
     For 013 -> This is an invalid input. A string starting with 0 will not be passed.
     For 103 -> there is 1 encoding. jc
     For 303 -> there are 0 encodings. But such a string maybe passed. In this case
     print 0.
 */

import java.util.Scanner;

public class _13_DecodeWays {

    public static int decodeWays(String str){
        int[] dp = new int[str.length()];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++){

            // 1. Last both character is 0
            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0'){
                dp[i] = 0;
            }
            // 2. Second last character is 0 and last character is not 0
            else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0'){
                dp[i] = dp[i - 1];
            }
            // 3. Second last character is not 0 and last character is 0
            else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0'){
                if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2'){
                    dp[i] = (i >= 2 ? dp[i - 2] : 1);
                }else {
                    dp[i] = 0;
                }
            }
            // 4. Last both character is not 0
            else {
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26){
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                }else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[str.length() - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(decodeWays(str));
    }
}


/*
Input:
123
Output:
3
 */