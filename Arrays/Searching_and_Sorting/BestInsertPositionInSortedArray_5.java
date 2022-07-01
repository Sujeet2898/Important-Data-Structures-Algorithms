/*

Link: https://www.youtube.com/watch?v=0A40XJH_VvE

Problem Statement: Algorithm to find best insert position in sorted array
You are given a sorted array 'A' of length 'N' with distinct integers and a target integer 'M'. You need to return the position of 'M' if it existed in the array 'A'. If it already exists in 'A', return that position. (0-based indexing)

For example:
If the given array 'A' is: [1, 2, 4, 7] and M = 6. We insert M = 6 in the array and get 'A' as: [1, 2, 4, 6, 7]. The position of 6 is 3 (according to 0-based indexing)

Note:
1) The given array has distinct integers.
2) The given array may be empty.

 */

//  Time Complexity: O(logn)
package Searching_and_Sorting;

import java.util.Scanner;

public class BestInsertPositionInSortedArray_5 {

    public static int bestInsertPos(int [] arr, int n, int m){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if (arr[mid] == m){
                return mid;
            }else if (arr[mid] < m){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = scn.nextInt();
        }
        int m = scn.nextInt();

        System.out.println(bestInsertPos(input, n, m));
    }
}

/*
Input:
4
1 2 4 7
6
Output:
3

Input:
4
1 2 4 7
9
Output:
4

 */