/*

Link: 1. https://www.youtube.com/watch?v=yCQN096CwWM
      2. https://www.youtube.com/watch?v=pbajVSlZYDA
Problem Statement: Maximum Sum Rectangle
You are given a matrix ‘ARR’ with ‘N’ rows and ‘M’ columns. Your task is to find the maximum sum rectangle in the matrix.
Maximum sum rectangle is a rectangle with the maximum value for the sum of integers present within its boundary, considering all the rectangles that can be formed from the elements of that matrix.

 Time Complexity: O(cols*cols*row)
 Space Complexity: O(rows)
 */

package Kadanes_Algorithm;

import java.util.Scanner;

public class MaximumSumRectangle_4 {

    public static int maxSumRectangle(int[][] arr, int n, int m){
        return maxSumRec(arr);
    }

    public static int maxSumRec(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        int temp[] = new int[rows];
        int ans = 0;

        for (int left = 0; left < cols; left++){
            for (int i = 0; i < rows; i++){
                temp[i] = 0;
            }
            for (int right = left; right < cols; right++){
                // filling the row sum
                for (int i = 0; i < rows; i++){
                    temp[i] += arr[i][right];
                }
                ans = Math.max(ans, maxSubarraySum(temp));
            }
        }
        return ans;
    }

    public static int maxSubarraySum(int[] arr){
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] rectangle = new int[rows][cols];

        //input
        //rows
        for(int i=0; i<rows; i++) {
            //columns
            for(int j=0; j<cols; j++) {
                rectangle[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxSumRectangle(rectangle, rows, cols));
    }
}

/*
Input:
4
5
1 2 -1 -4 -20
-8 -3  4 2 1
3  8 10 1 3
-4 -1 1 7 -6
Output:
29

Input:
2
2
-1 1
2 2
Output:
4

 */