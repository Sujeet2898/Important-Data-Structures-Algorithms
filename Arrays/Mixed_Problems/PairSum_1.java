/*

Link: https://www.youtube.com/watch?v=4t9jv9AkVdE

Problem Statement: Pair Sum
You are given an integer array 'ARR' of size 'N' and an integer 'S'. Your task is to return the list of all pairs of elements such that each sum of elements of each pair equals 'S'.
 */

package Mixed_Problems;

import java.util.Arrays;
import java.util.Scanner;

public class PairSum_1 {

    /*
    Time Complexity: O(nlogn) as O(nlogn) + O(n) = O(nlogn)

    Ques: a1 b1 c1 d1 a2 b2 c2 d2
    PairSum:   a1 b1   where a1 < b1
               a2 b2   where a2 < b2
               a2 b2   where a2 < b2
               Also a1 < a2 < a3
     */
    public static void pairSum(int[] arr, int s){
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            if (arr[left] + arr[right] < s){
                left++;
            }else if (arr[left] + arr[right] > s){
                right--;
            }else {
                System.out.println(arr[left] + " " + arr[right]);
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        pairSum(arr,target);
    }
}

/*
Input:
5
1 2 3 4 5
5
Output:
1 4
2 3


Input:
5
2 -3 3 3 -2
0
Output:
-3 3
-2 2

 */