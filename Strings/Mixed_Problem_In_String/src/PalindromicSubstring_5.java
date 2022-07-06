import java.util.Scanner;

public class PalindromicSubstring_5 {

/*

Link: https://www.youtube.com/watch?v=_jM3iMT4k7g

Question 1: Print All Palindromic Substrings

1. You are given a string.
2. You have to print all palindromic substrings of the given string.

 */

    public static void allPalindromicSubString(String str){
        for (int i = 0; i < str.length(); i++){
            for (int j = i + 1; j <= str.length(); j++){  // equalTo is must
                String subStr = str.substring(i, j);
                if (isPalindrome(subStr) == true){
                    System.out.println(subStr);
                }
            }
        }
    }

    private static boolean isPalindrome(String subStr) {
        int i = 0;
        int j = subStr.length() - 1;
        while (i <= j){
            char ch1 =subStr.charAt(i);  // take first character
            char ch2 =subStr.charAt(j);  // take last character
            if (ch1 != ch2){
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        allPalindromicSubString(str);
    }

/*
Input:
abcc

Output:
a
b
c
cc
c

 */

/*

Link: https://www.youtube.com/watch?v=lUdWGkCUD54

Question 2: Subarray Problem

1. You are given an array of size 'n' and n elements of the same array.
2. You are required to find and print all the subarrays of the given array.
3. Each subarray should be space seperated and on a seperate lines. Refer to sample input and output.

 */

    public static void subArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                for (int k = i; k <= j; k++){
                    System.out.print(arr[k] + "\t");
                }
                System.out.println();
            }
        }
    }

    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        subArray(arr);
    }

     Input:
     3
     10
     20
     30

     Output:
     10
     10	20
     10	20	30
     20
     20	30
     30

     */

}

