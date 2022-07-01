/*

Link: https://www.youtube.com/watch?v=QM0klnvTQzk

Problem Statement: Count all sub-arrays having sum divisible by k
Given an array ‘ARR’ and an integer ‘K’, your task is to find all the count of all sub-arrays whose sum is divisible by the given integer ‘K’.

 */

package Prefix_and_Suffix_Sum;

import java.util.HashMap;
import java.util.Scanner;

public class CountSubArraysWithSumDivisibleByK_4 {

    public static int subArrayCount(int[] arr, int k){
        int ans = 0;

        // Creating HasMap whose first is "integer" (i.e remainder) stored in array & second is "frequency" of that remainder stored in array
        HashMap<Integer, Integer> map = new HashMap<>();

        // Start
        map.put(0,1);
        int sum = 0;
        int rem = 0;

        for (int i = 0; i < arr.length; i++){
            sum += arr[i];  // update sum
            rem = sum % k;  // calculate remainder

            // Making +ve remainder whenever -ve remainder comes
            if (rem < 0){
                rem += k;
            }

            // Checking remainder in map
            if (map.containsKey(rem)){
                ans += map.get(rem);
                map.put(rem, map.get(rem) + 1);  // for more than one rem
            }else {
                map.put(rem, 1);  // only for one rem
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subArrayCount(arr, k));
    }
}

/*

Input:
4
1 2 3 4
1
Output:
10

Input:
3
2 3 1
2
Output:
3

 */

/*

***************************************************************
package Prefix_and_Suffix_Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static int subArrayCount(ArrayList< Integer > arr, int k){
        int ans = 0;

        // Creating HasMap whose first is "integer" (i.e remainder) stored in array & second is "frequency" of that remainder stored in array
        HashMap<Integer, Integer> map = new HashMap<>();

        // Start
        map.put(0,1);
        int sum = 0;
        int rem = 0;

        for (int i = 0; i < arr.size(); i++){
            sum += arr.get(i);  // update sum
            rem = sum % k;  // calculate remainder

            // Making +ve remainder whenever -ve remainder comes
            if (rem < 0){
                rem += k;
            }

            // Checking remainder in map
            if (map.containsKey(rem)){
                ans += map.get(rem);
                map.put(rem, map.get(rem) + 1);  // for more than one rem
            }else {
                map.put(rem, 1);  // only for one rem
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList< Integer > arr = new ArrayList< Integer >(n);

        for(int i = 0; i < n; i++){
            arr.add(i, sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(subArrayCount(arr, k));
    }
}
 */