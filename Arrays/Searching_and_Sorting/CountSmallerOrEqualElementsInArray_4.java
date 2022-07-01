/*

Link:  https://www.youtube.com/watch?v=qE3RvSwfT9I

Problem Statement: Count Smaller or Equal elements in array
You are given two arrays of integers. Let's call the first array A and the second array B. A finds the number of elements in array B that are smaller than or equal to that element for every array element.
 */

package Searching_and_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class CountSmallerOrEqualElementsInArray_4 {

//  Time Complexity: O(n*logm)

    public static int[] countSmallerOrEqual(int[] arr1, int[] arr2){
        Arrays.sort(arr2);
        int[] ans = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++){
            int key = arr1[i];
            int countSmallerOrEqual = helper(key, arr2);
            ans[i] = countSmallerOrEqual;
        }
        return ans;
    }

    private static int helper(int key, int[] arr) {
        // To find the count of elements which are smaller or equal to key in arr
        int count = 0;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = (low + high)/2;

            if (arr[mid] <= key){
                count += (mid - low + 1);
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int[] a = new int[n1];
        for(int i = 0; i < n1; i++) {
            a[i] = s.nextInt();
        }

        int n2 = s.nextInt();
        int[] b = new int[n2];
        for(int i = 0; i < n2; i++) {
            b[i] = s.nextInt();
        }

        int[] ans = countSmallerOrEqual(a,b);

        for (int val : ans){
            System.out.print(val + " ");
        }
    }
}

/*
Input:
4
-2 1 3 0
4
-1 0 2 1
Output:
0 3 4 2

Input:
5
5 4 3 2 1
2
3 4
Output:
2 2 1 0 0

 */

/*

********************************************************************

package Searching_and_Sorting;

import java.util.Scanner;

public class Solution {

    //  Time Complexity: O(n)
    // Pre-Processing & Optimization
    public static int[] countSmallerOrEqual(int[] arr1, int[] arr2){

        int max1 = 0;
        int max2 = 0;
        for (int val : arr1){
            max1 = Math.max(max1, val);
        }
        for (int val : arr2){
            max2 = Math.max(max2, val);
        }
        int overAllMax = Math.max(max1, max2);

        // 1. Making frequencyArray
        int[] fArr = new int[100000];
        for (int i = 0; i < arr2.length; i++){
            fArr[arr2[i]]++;
        }

        // 2. Making PrefixSumArray
        int[] psa = new int[100000];
        psa[0] = fArr[0];
        for (int i = 1; i <= overAllMax; i++){
            psa[i] = psa[i - 1] + fArr[i];
        }

        // 3. Making ansArray which is in O(1)
        int[] ans = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++){
            int key = arr1[i];
            ans[i] = psa[key];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int[] a = new int[n1];
        for(int i = 0; i < n1; i++) {
            a[i] = s.nextInt();
        }

        int n2 = s.nextInt();
        int[] b = new int[n2];
        for(int i = 0; i < n2; i++) {
            b[i] = s.nextInt();
        }

        int[] ans = countSmallerOrEqual(a,b);

        for (int val : ans){
            System.out.print(val + " ");
        }
    }
}

/*

Input:
7
1 2 3 4 7 40 9
8
0 1 2 1 1 4 39 40
Output:
4 5 5 6 6 8 6

 */
