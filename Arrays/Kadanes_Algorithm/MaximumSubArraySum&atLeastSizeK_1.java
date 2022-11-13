/*  Link:   https://www.youtube.com/watch?v=VMtyGnNcdPw

Problem Statement: Maximum SubArray Sum
You are given an array (ARR) of length N, consisting of integers. You have to find the sum of the subarray (including empty subarray) having maximum sum among all subarrays.
A subarray is a contiguous segment of an array. In other words, a subarray can be formed by removing 0 or more integers from the beginning, and 0 or more integers from the end of an array.
Note :
The sum of an empty subarray is 0.

Kadane’s Algorithm:
The idea of Kadane’s algorithm is to maintain a maximum subarray sum ending at every index ‘i’ of the given array and update the maximum sum obtained by comparing it with the maximum sum of the subarray ending at every index ‘i’.

Time complexity: O(N), where N is the number of elements in the array, as we traverse the array once to get the maximum subarray sum.
Space complexity: O(1), as no extra space is required.

*/

    package Kadanes_Algorithm;

    import java.util.Scanner;

    public class MaximumSubArraySum_1 {

/*
    public static long maxSubarraySum(int[] arr, int n){
        int currentSum = arr[0];
        int overAllSum = arr[0];

        for (int i = 1; i < arr.length; i++){

            // Join the incoming train if it is +ve
            if (currentSum >= 0){
                currentSum += arr[i];
            }else{
                // Form a new train if the incoming train is -ve
                currentSum = arr[i];
            }

            // Updating the overall sum
            if (currentSum > overAllSum){
                overAllSum = currentSum;
            }
        }
        return overAllSum;
    }
    */
        //     OR

        public static long maxSubarraySum(int[] arr, int n){
            int currentSum = arr[0];
            int overAllSum = arr[0];

            for (int i = 1; i < arr.length; i++){

                // Join the incoming train if it is +ve
                    // Form a new train if the incoming train is -ve
                currentSum = Math.max(arr[i], currentSum + arr[i]);

                // Updating the overall sum
                overAllSum = Math.max(overAllSum, currentSum);
            }
            return overAllSum;
        }
        
-----------------------------------------------------------------------------
    Question: Maximum Sum Subarray with at least Size K
-----------------------------------------------------------------------------
    public static long maxSubarraySumWithAtLeastKSize(int[] arr, int k){
        int ans = Integer.MIN_VALUE;
        int[] maxSum = new int[arr.length];
        int currentSum = arr[0];
        maxSum[0] = currentSum;
        
        for (int i = 1; i < arr.length; i++){

            // Join the incoming train if it is +ve
            if (currentSum >= 0){
                currentSum += arr[i];
            }else{
                // Form a new train if the incoming train is -ve
                currentSum = arr[i];
            }

            maxSum[i] = currentSum;
        }
        
        // Window for 1st k size
        int exactK = 0;
        for(int i = 0; i < k; i++){
            exactK += arr[i];
        }
        // Updating ans
        if(exactK > ans){
            ans = exactK;
        }
        
        // Moving exactK window forward
        for (int i = k; i < arr.length; i++){
            exactK = exactK + arr[i] - arr[i - k];
            
            // Also Updating ans inside
            if(exactK > ans){
               ans = exactK;
            }
            
            // AtLeast K size
            int moreThanK = maxSum[i - k] + exactK;
            if(moreThanK > ans){
               ans = moreThanK;
            }
        }
        
       return ans;
     }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSubarraySum(arr,n));
    }
}

/*

Input:
18
4 3 -2 6 -14 7 -1 4 5 7 -10 2 9 -10 -5 -9 6 1
Output:
23

Input:
19
4 3 -2 6 7 -10 -10 4 5 9 -3 4 7 -28 2 9 3 2 11
Output:
27

 */
