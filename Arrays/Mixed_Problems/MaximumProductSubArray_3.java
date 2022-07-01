/*

Link: https://www.youtube.com/watch?v=cNLHESv_XPc

Problem: Maximum Product Subarray
Given an integer array arr, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
A subarray is a contiguous subsequence of the array.

 */

package Mixed_Problems;

import java.util.Scanner;

public class MaximumProductSubArray_3 {

    public static long maxSubarrayProduct(int[] arr, int n){

        long max = arr[0];
        long min = arr[0];
        long result = arr[0];

        // Initialize with 1 as 0 place is already initialized
        for (int i = 1; i < n; i++){
            // Checking barrier
            if (arr[i] == 0){
                max = 1;
                min = 1;
                continue;
            }

            long temp1 = arr[i] * max;
            long temp2 = arr[i] * min;

            max = Math.max(temp1,temp2);
            max = Math.max(max, arr[i]);

            min = Math.min(temp1,temp2);
            min = Math.min(min, arr[i]);

            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(maxSubarrayProduct(arr,n));
    }
}

/*
Input:
5
6 -3 -10 0 2
Output:
180

Input:
5
-1 -3 -10 0 60
Output:
60

Input:
5
-2 -40 0 -2 -3
Output:
80

Input:
3
-2 0 -1
Output:
-1

 */