/*
Problem: Find the modified array after performing k operations of given type
Given an array arr[] of n integers and an integer K. In one operation every element of the array is replaced by the difference of that element and the maximum value of the array. The task is to print the array after performing K operations.
 */

package Mixed_Problems;

import java.util.Scanner;

public class PrintArrayAfterKOperations_8 {

    public static void printArrayAfterKOperations(int[] arr, int k){
        /*
        There are two possible cases:
        1. If k is even then the new array will be arr[i] – min(arr) for all i in range [0, n).
        2. If k is odd then the new array will be max(arr) – arr[i] for all i in range [0, n).
         */
        if (k % 2 == 0){
            int i = arr[0];
            int minVal = arr[0];

            // Get the minimum value from the array
            for (i = 1; i < arr.length; i++) {
                minVal = Math.min(minVal, arr[i]);
            }

            // Remove the minimum value from every element of the array
            for (i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - minVal;
            }

        }else {

            int i = arr[0];
            int maxVal = arr[0];

            // Get the maximum value from the array
            for (i = 1; i < arr.length; i++)
                maxVal = Math.max(maxVal, arr[i]);

            // Remove every element of the array from the maximum value of the array
            for (i = 0; i < arr.length; i++)
                arr[i] = maxVal - arr[i];
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        printArrayAfterKOperations(arr, k);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
Input:
4
4 8 12 16
3
Output:
12 8 4 0

Input:
4
4 8 12 16
4
Output:
0 4 8 12

Explanation:
Let arr[] = {4, 8, 12, 16}
For k = 1, arr[] = (12, 8, 4, 0}
For k = 2, arr[] = (0, 4, 8, 12}
For k = 3, arr[] = (12, 8, 4, 0}
For k = 4, arr[] = (0, 4, 8, 12}
It can be observed that the array is repeating after every 2 operations.

 */
