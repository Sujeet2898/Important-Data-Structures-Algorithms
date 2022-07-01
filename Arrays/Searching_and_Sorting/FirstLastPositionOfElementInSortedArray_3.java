/*

Link: 1. https://www.youtube.com/watch?v=9NXZccIWNqU
      2. https://www.youtube.com/watch?v=Y7LiLNdayF0

Problem Statement: First and Last Position of an element in Sorted Array
You are given a sorted array ARR consisting of N integers and an integer X. You need to find the first and last position of occurrence of X in the array.
Note:
1. The array follows 0-based indexing, so you need to return 0-based indices.
2. If X is not present in the array, return “-1 -1”.
3. If X is only present once in the array, the first and last position of its occurrence will be the same.

Follow Up:
Try to solve the problem in O(log(N)) time complexity.
 */

// First Way of Solving

package Searching_and_Sorting;

import java.util.Scanner;

public class FirstLastPositionOfElementInSortedArray_3 {

    public static int[] findFirstLastPosition(int arr[], int data) {

        int[] ans = {-1,-1};
        int low = 0;
        int high = arr.length - 1;

        // To find first index
        while (low <= high){
            int mid = (low + high) / 2;

            if (data > arr[mid]){
                low = mid + 1;
            }else if (data < arr[mid]){
                high = mid - 1;
            }else {
                ans[0] = mid;

                // Continue searching left part
                high = mid - 1;
            }
        }

        // To find last index
        low = 0;
        high = arr.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (data > arr[mid]){
                low = mid + 1;
            }else if (data < arr[mid]){
                high = mid - 1;
            }else {
                ans[1] = mid;

                // Continue searching right part
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = scn.nextInt();
        }
        int data = scn.nextInt();

        int[] ans = findFirstLastPosition(input,data);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

/*
Input:
5
-10 -5 -5 -5 2
-5
Output:
1 3

Input:
4
1 2 3 4
5
Output:
-1 -1

 */


/*

**************************************************************

// Second Way of Solving

package Searching_and_Sorting;

import java.util.Scanner;

public class Solution {

    static class Pair {
        int start;
        int last;
    }

    public static Pair findFirstLastPosition(int[] arr, int n, int x){
        Pair ans = new Pair();
        ans.start = arr[0];
        ans.last = arr[1];

        int low = 0;
        int high = arr.length - 1;

        // To find first index
        while (low <= high){
            int mid = (low + high) / 2;

            if (x > arr[mid]){
                low = mid + 1;
            }else if (x < arr[mid]){
                high = mid - 1;
            }else {
                ans.start = mid;

                // Continue searching left part
                high = mid - 1;
            }
        }

        // To find last index
        low = 0;
        high = arr.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (x > arr[mid]){
                low = mid + 1;
            }else if (x < arr[mid]){
                high = mid - 1;
            }else {
                ans.last = mid;

                // Continue searching right part
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        int x = s.nextInt();
        Pair ans = findFirstLastPosition(input,n,x);
        System.out.println(ans.start);
        System.out.println(ans.last);
    }
}

 */

/*

**************************************************************

// Third Way of Solving

package Searching_and_Sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static class Pair {
        int start;
        int last;
    }

    public static Pair findFirstLastPosition(ArrayList<Integer> arr, int n, int x){
        Pair ans = new Pair();
        ans.start = arr.get(0);
        ans.last = arr.get(1);

        int low = 0;
        int high = arr.size() - 1;

        // To find first index
        while (low <= high){
            int mid = (low + high) / 2;

            if (x > arr.get(mid)){
                low = mid + 1;
            }else if (x < arr.get(mid)){
                high = mid - 1;
            }else {
                ans.start = mid;

                // Continue searching left part
                high = mid - 1;
            }
        }

        // To find last index
        low = 0;
        high = arr.size() - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (x > arr.get(mid)){
                low = mid + 1;
            }else if (x < arr.get(mid)){
                high = mid - 1;
            }else {
                ans.last = mid;

                // Continue searching right part
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> input = new ArrayList<Integer>(n);
        for(int i = 0; i < n; i++) {
            input.add(i, s.nextInt());
        }
        int x = s.nextInt();
        Pair ans = findFirstLastPosition(input,n,x);
        System.out.println(ans.start);
        System.out.println(ans.last);
    }
}


 */