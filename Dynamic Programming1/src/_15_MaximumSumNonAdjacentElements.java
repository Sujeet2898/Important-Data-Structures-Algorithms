/*
Link: https://www.youtube.com/watch?v=VT4bZV24QNo&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=22
Question: Maximum Sum Non Adjacent Elements
1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.
 */

import java.util.Scanner;

public class _15_MaximumSumNonAdjacentElements {

    public static int maximumSumNonAdjacentElements(int[] arr){
        int include = arr[0];
        int exclude = 0;

        for (int i = 1; i < arr.length; i++){
            int newInclude = exclude + arr[i];
            int newExclude = Math.max(include, exclude);

            include = newInclude;
            exclude = newExclude;
        }
        int ans = Math.max(include, exclude);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(maximumSumNonAdjacentElements(arr));
    }
}

/*
Input:
6
5 10 10 100 5 6

Output:
116

 */