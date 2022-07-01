/*

Link: https://www.youtube.com/watch?v=iL7oSNc3OXA

Problem Statement: Non-Decreasing Array
You have been given an integer array/list 'ARR' of size 'N'. Write a solution to check if it could become non-decreasing by modifying at most 1 element.
We define an array as non-decreasing, if ARR[i] <= ARR[i + 1] holds for every i (0-based) such that (0 <= i <= N - 2).

 */

package Mixed_Problems;

import java.util.Scanner;

public class NonDecreasingArray_5 {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static boolean isPossible(int[] arr){

        int pos= -1;
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] > arr[i + 1]){
                if (pos != -1){
                    return false;
                }
                pos = i;
            }
        }
        return pos == -1 ||pos == 0 || pos == arr.length - 2 || arr[pos - 1] <= arr[pos + 1] || arr[pos] <= arr[pos + 2];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(isPossible(arr));
    }
}

/*
Input:
6
-2 7 -1 0 1 2
Output:
true

Input:
5
-10 10 0 10 3
Output:
false

 */