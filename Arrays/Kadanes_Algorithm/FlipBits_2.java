/*
Problem Statement: Flip Bits
You are given an array of integers ARR[] of size N consisting of zeros and ones. You have to select a subset and flip bits of that subset. You have to return the count of maximum one’s that you can obtain by flipping chosen sub-array at most once.
A flip operation is one in which you turn 1 into 0 and 0 into 1.
 */

package Kadanes_Algorithm;

import java.util.Scanner;

public class FlipBits_2 {

    public static int flipBits(int[] arr, int n) {
        int totalOnes = 0;
        int currentSum = 0;
        int overAllSum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1) {
                totalOnes++;
            }

            // Converting into max SubArray Sum Problem and let us solve using Kadane’s Algorithm
            int val = arr[i] == 1 ? -1 : 1;

            // Join the incoming train if it is +ve
            if (currentSum >= 0){
                currentSum += val;

            }else{
                // Form a new train if the incoming train is -ve
                currentSum = val;
            }

            // Updating the overall sum
            if(currentSum > overAllSum){
                overAllSum = currentSum;
            }
        }
        return totalOnes + overAllSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(flipBits(arr,n));
    }
}

/*
Input:
5
1 0 0 1 0
Output:
4
Explanation: We can perform a flip operation in the range [1,2]. After the flip operation, the array is: 1 1 1 1 0 and so the answer will be 4

Input:
4
1 1 1 0
Output:
4
Explanation: We can perform a flip operation in the range [3,3]. After the flip operation, the array is: 1 1 1 1 and so the answer will be 4.
 */



