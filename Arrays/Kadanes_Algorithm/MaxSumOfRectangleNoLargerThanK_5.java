/*
Question: Max Sum of Rectangle No Larger Than K
Given an m x n matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.
It is guaranteed that there will be a rectangle with a sum no larger than k.

Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).

Input: matrix = [[2,2,-1]], k = 3
Output: 3
 */

public class MaxSumOfRectangleNoLargerThanK_5 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int temp[] = new int[rows];
        int ans = 0;

        for (int left = 0; left < cols; left++){
            for (int i = 0; i < rows; i++){
                temp[i] = 0;
            }
            for (int right = left; right < cols; right++){
                // filling the row sum
                for (int i = 0; i < rows; i++){
                    temp[i] += matrix[i][right];
                }
                ans = Math.max(ans, maxSubarraySum(temp, k));
            }
        }
        return ans;
    }

    public int maxSubarraySum(int[] arr, int k){
        int currentSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){

            // Join the incoming train if it is +ve
            if (currentSum >= 0){
                currentSum += arr[i];
            }else{
                // Form a new train if the incoming train is -ve
                currentSum = arr[i];
            }

            // Updating the overall sum
            if (currentSum <= k){
                res = Math.max(res,currentSum);
            }
        }
        return res;
    }
}
