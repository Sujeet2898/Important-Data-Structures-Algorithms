/*
Link: https://www.youtube.com/watch?v=37MdIo-MaSU&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=7
Question: Largest Subarray With Contiguous Elements
1. You are given an array(arr) of integers. Values may be duplicated.
2. You have to find the length of the largest subarray with contiguous elements.

Note -> The contiguous elements can be in any order(not necessarily in increasing order).
 */

import java.util.HashSet;
import java.util.Scanner;

public class _7_LargestSubarrayWithContiguousElements {

    public static int largestSubarrayWithContiguousElements (int[] arr) {
        int ans = 0;

        for (int i = 0; i < arr.length - 1; i++){

            // At start
            int min = arr[i];
            int max = arr[i];

            // For duplicate
            HashSet<Integer> checkDuplicate = new HashSet<>();
            checkDuplicate.add(arr[i]);

            for (int j = i + 1; j < arr.length; j++){
                if (checkDuplicate.contains(arr[j])){
                    break;
                }
                checkDuplicate.add(arr[j]);
                
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if (max - min == j - i){
                    int length = j - i + 1;
                    if (length > ans){
                        ans = length;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(largestSubarrayWithContiguousElements(arr));
    }
}

/*
Input:
4
9 2 1 5 6 23 24 22 23 19 17 16 18 39 0
Output:
4

 */