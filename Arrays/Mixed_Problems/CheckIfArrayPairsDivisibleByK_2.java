/*

Link: https://www.youtube.com/watch?v=BvKv-118twg

Problem Statement: Check If Array Pairs Are Divisible by k
Given an array of integers arr of even length n and an integer k.
We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
Return true If you can find a way to do that or false otherwise.

 */

package Mixed_Problems;

import java.util.HashMap;
import java.util.Scanner;

public class CheckIfArrayPairsDivisibleByK_2 {

    // Time Complexity: O(n)

    public static boolean canArrange(int[] arr, int k){
        HashMap<Integer, Integer> remFreqMap = new HashMap<>();

        for (int val : arr){
            int rem = val % k;

            int oldFreq = remFreqMap.getOrDefault(rem, 0);
            remFreqMap.put(rem, oldFreq + 1);
        }

        for (int val : arr){
            int rem = val % k;

            if (rem == 0){
                int freq = remFreqMap.get(rem);
                if (freq % 2 == 1){  // odd freq
                    return false;
                }

            }else if (2 * rem == k){
                int freq = remFreqMap.get(rem);
                if (freq % 2 == 1){  // odd freq
                    return false;
                }

            }else {
                int freq = remFreqMap.get(rem);
                int otherFreq = remFreqMap.getOrDefault(k - rem,0);
                if (freq != otherFreq){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(canArrange(arr,k));
    }
}

/*
Input:
10
1 2 3 4 5 10 6 7 8 9
5
Output:
true
Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).

Input:
6
1 2 3 4 5 6
7
Output:
true
Explanation: Pairs are (1,6),(2,5) and(3,4).

Input:
6
1 2 3 4 5 6
10
Output:
false
Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.

 */