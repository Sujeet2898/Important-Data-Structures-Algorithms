/*

Link: https://www.youtube.com/watch?v=sNH-f_5Gm0I

Problem Statement: Perform string shifts
You are given s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount].
Note:
Direction can be 0 (for left shift) or 1 (for right shift).
Amount is the amount by which string str is to be shifted.
A left shift by 1 means remove the first character of str and append it to the end.
Similarly, a right shift by 1 means remove the last character of str and append it to the beginning.
Return the final string after all operations.

Time Complexity: O(n of shift operation + length of string)

 */

import java.util.Scanner;

public class RotateAStringOrArray_5 {

    static String stringShift(String str, int[][] shift){

        // Value for storing the effective rotation
        int val = 0;
        // Stores modified string
        String result = "";

        // Iterate through all the shift values
        for (int i = 0; i < shift.length; i++){

            // If shift[i][0] = 0, then left shift. Otherwise, right shift
            if (shift[i][0] == 0) {
                val -= shift[i][1];
            }else {
                val += shift[i][1];
            }

            // Effective shift calculation
            val = val % str.length();

            // Right rotation
            if (val > 0) {
                result = str.substring(str.length() - val, (str.length() - val) + val)
                        + str.substring(0, str.length() - val);

                // Left rotation
            }else {
                result = str.substring(-val, str.length() + val)
                        + str.substring(0, -val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int[][] shift = new int[][] {{ 0, 1 }, { 1, 2 }};
        System.out.println(stringShift(str,shift));
    }
/**

Input: Str = “abc”, shift[][] = {{0, 1}, {1, 2}}
Output: cab
Explanation:
[0, 1] refers to shifting  Str[0] to the left by 1. Therefore, the string Str modifies from “abc” to “bca”.
[1, 2] refers to shifting  Str[0] to the right by 2. Therefore, the string Str modifies from “bca” to “cab”.

Input: S = “abcdefg”, shift[][] = { {1, 1}, {1, 1}, {0, 2}, {1, 3} }
Output: efgabcd
Explanation:
[1, 1] refers to shifting Str[0] to the right by 1. Therefore, the string Str modifies from “abcdefg” to “gabcdef”.
[1, 1] refers to shifting Str[0] to the right by 1. Therefore, the string Str modifies from “gabcdef” to “fgabcde”.
[0, 2] refers to shifting Str[0] to the left by 2. Therefore, the string Str modifies from “fgabcde” to “abcdefg”.
[1, 3] refers to shifting Str[0] to the right by 3. Therefore, the string Str modifies from “abcdefg” to “efgabcd”.

*/

/*

Link: https://www.youtube.com/watch?v=8RErc0VXAo8

Problem Statement: Rotate An Array
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are given a number k.
4. Rotate the array a, k times to the right (for positive values of k), and to the left for negative values of k.

 */

    public static void rotateArray(int[] arr, int k){

        // If rotation is more than arr.length
        k = k % arr.length;  // first do this before -ve rotation

        // If rotation is -ve
        if (k < 0){
            k = k + arr.length;
        }

        // 1. Reverse part 1 : 0 to arr.length-k-1
        reverse(arr, 0, arr.length-k-1);

        // 2. Reverse part 2 : arr.length-k to arr.length-1
        reverse(arr, arr.length-k, arr.length-1);

        // 3. Reverse all : 0 to arr.length-1
        reverse(arr, 0, arr.length-1);
    }

    public static void reverse(int[] arr, int i, int j){
        int left = i;
        int right = j;

        while (left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    /**

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        rotateArray(arr, k);
        for(int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

     Input:
     5
     1 2 3 4 5
     3
     Output:
     3 4 5 1 2

     */

/*

Link: https://www.youtube.com/watch?v=XRuMfDaWpOU

Problem Statement: Rotate String
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift.

 */

    public static boolean rotateString(String str, String goal){

        if (str.length() == goal.length() && (str + str).contains(goal)){
            return true;
        }
        return false;
    }

    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String goal = scn.nextLine();
        System.out.println(rotateString(str, goal));
    }

     Input:
     abcde
     cdeab

     Output:
     true

     Input:
     abcde
     abced

     Output:
     false

     */
}
