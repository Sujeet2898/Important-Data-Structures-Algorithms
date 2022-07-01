/*
Problem Statement: Form a Triangle
You are given an integer of array/list 'ARR' of length ‘N. You are supposed to return true if it is possible to construct at least one non-degenerate triangle using values of array/list as sides of the triangle, otherwise, return false.

You don’t need to print anything; It has already been taken care of. Just implement the given function.
 */

package Searching_and_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FormATriangle_2 {

    public static boolean possibleToMakeTriangle(int[] arr, int n){

        // If number of elements are less than 3, then no triangle is possible
        if (n < 3){
            return false;
        }

        // first sort the array
        Arrays.sort(arr);

        // loop for all 3 consecutive triplets
        for (int i = 0; i < n - 2; i++){

            // If triplet satisfies triangle condition
            if (arr[i] + arr[i + 1] > arr[i + 2]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];

        for(int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        if (possibleToMakeTriangle(a,n)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}

/*
Input:
5
4 2 1 3 2
Output:
YES

Input:
5
12 3 7 4 28
Output:
NO

 */


/*
***************************************************************
package Searching_and_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static boolean possibleToMakeTriangle(ArrayList<Integer> arr){
        return possibleToMakeTriangle(arr, arr.size());
    }

    public static boolean possibleToMakeTriangle(ArrayList<Integer> arr, int n){

        // If number of elements are less than 3, then no triangle is possible
        if (n < 3){
            return false;
        }

        // Sorting ArrayList in ascending Order
        Collections.sort(arr);

        // loop for all 3 consecutive triplets
        for (int i = 0; i < n - 2; i++){

            // If triplet satisfies triangle condition
            if (arr.get(i) + arr.get(i + 1) > arr.get(i + 2)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>(n);

        for(int i = 0; i < n; i++){
            a.add(i, sc.nextInt());
        }
        if (possibleToMakeTriangle(a,n)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}

Input:
5
4 2 1 3 2
Output:
YES

Input:
5
12 3 7 4 28
Output:
NO

 */