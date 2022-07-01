/*
Problem Statement: Maximum subarray sum after K concatenation
You have been given a vector/list 'ARR' consisting of ‘N’ integers. You are also given a positive integer ‘K’.
Let’s define a vector/list 'CONCAT' of size 'N * K' formed by concatenating 'ARR' ‘K’ times. For example, if 'ARR' = [0, -1, 2] and 'K' = 3, then 'CONCAT' is given by [0, -1, 2, 0, -1, 2, 0, -1, 2].
Your task is to find the maximum possible sum of any non-empty subarray (contagious) of 'CONCAT'.
 */

package Kadanes_Algorithm;

import java.util.Scanner;

public class MaximumSubarraySumAfterKConcatenation_3 {

    public static int kadanes(int[] arr) {
        int currentSum = arr[0];
        int overAllSum = arr[0];

        for (int i = 1; i < arr.length; i++) {

            // Join the incoming train if it is +ve
            if (currentSum >= 0) {
                currentSum += arr[i];
            } else {
                // Form a new train if the incoming train is -ve
                currentSum = arr[i];
            }

            // Updating the overall sum
            if (currentSum > overAllSum) {
                overAllSum = currentSum;
            }
        }
        return overAllSum;
    }

    public static int kadanesOfTwo(int[] arr) {
        int[] newArr = new int[arr.length * 2];
        // 1st Copy
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        // 2nd Copy
        for (int i = 0; i < arr.length; i++) {
            newArr[i + arr.length] = arr[i];
        }
        return kadanes(newArr);
    }

    public static long maxSubSumKConcat(int[] arr, int k, long sum) {
        if (k == 1) {
            return kadanes(arr);

        } else if (sum < 0) {
            return kadanesOfTwo(arr);

        } else {
            // sum >= 0
            return kadanesOfTwo(arr) + (k - 2) * sum;
        }
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        System.out.println(maxSubSumKConcat(arr, k, sum));
    }
}

/*

Input:
// sum lie in combination of kadanes
5
3 -2 -3 -1 2
2
Output:
5

Input:
// sum lie in ist kadanes, but we take combination of kadanes
5
2 3 -2 -3 -1
2
Output:
5

Input:
3
1 -2 1
2
Output:
2

Input:
2
1 3
3
Output:
12

 */


/* *************************************************************** */

/*
Problem Statement: Maximum subarray sum after K concatenation
You have been given a vector/list 'ARR' consisting of ‘N’ integers. You are also given a positive integer ‘K’.
Let’s define a vector/list 'CONCAT' of size 'N * K' formed by concatenating 'ARR' ‘K’ times. For example, if 'ARR' = [0, -1, 2] and 'K' = 3, then 'CONCAT' is given by [0, -1, 2, 0, -1, 2, 0, -1, 2].
Your task is to find the maximum possible sum of any non-empty subarray (contagious) of 'CONCAT'.
 */
/*
    public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k){
        long sum = 0;
        return kadanesKConcat(arr,k,sum);
    }

    public static int kadanes(ArrayList<Integer> arr){
        int currentSum = arr.get(0);
        int overAllSum = arr.get(0);

        for (int i = 1; i < arr.size(); i++){

            // Join the incoming train if it is +ve
            if (currentSum >= 0){
                currentSum += arr.get(i);
            }else{
                // Form a new train if the incoming train is -ve
                currentSum = arr.get(i);
            }

            // Updating the overall sum
            if (currentSum > overAllSum){
                overAllSum = currentSum;
            }
        }
        return overAllSum;
    }

    public static int kadanesOfTwo(ArrayList<Integer> arr){
        ArrayList<Integer> newArr = new ArrayList<>(arr.size() * 2);     //int[arr.length * 2];
        // 1st Copy
        for (int i = 0; i < arr.size(); i++){
            newArr.set(i, arr.get(i));
        }
        // 2nd Copy
        for (int i = 0; i < arr.size(); i++){
            newArr.set(i + arr.size(), arr.get(i));
        }
        return kadanes(newArr);
    }

    public static long kadanesKConcat(ArrayList<Integer> arr, int k, long sum){
        if (k == 1){
            return kadanes(arr);

        }else if (sum < 0){
            return kadanesOfTwo(arr);

        }else {
            // sum >= 0
            return kadanesOfTwo(arr) + (k - 2) * sum;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr.add(i, scn.nextInt());
            sum += arr.get(i);
        }
        int k = scn.nextInt();
        System.out.println(maxSubSumKConcat(arr,n,k));
    }

 */
//}

/*
Input:
3
1 -2 1
2
Output:
2

Input:
2
1 3
3
Output:
12

 */

