/*

Link: https://www.youtube.com/watch?v=gREVHiZjXeQ

Problem Statement: Product Of Array Except Self
You have been given an integer array/list (ARR) of size N. You have to return an array/list PRODUCT such that PRODUCT[i] is equal to the product of all the elements of ARR except ARR[i]

 */

package Prefix_and_Suffix_Sum;

import java.util.Scanner;

public class ProductOfArrayExceptSelf_3 {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int[] getProductArrayExceptSelf(int[] arr){
        int n = arr.length;
        int[] output = new int[n];

        if(n < 1){
            return output;
        }

        // Calculating cumulative multiplication from left to right and storing into outputArray
        int product = 1;
        for (int i = 0; i < n; i++){
            product *= arr[i];
            output[i] = product;
        }

        // Traversing from right and updating the outputArray as well as the product
        // cumulative multiplication from right to left is stored in product variable
        product = 1;
        for (int i = n - 1; i > 0; i--){
            // updating the outputArray
            output[i] = output[i - 1] * product;
            // updating the product
            product *= arr[i];
        }

        // Boundary case where there is no elements to the left-hand side and product is storing the multiplication of all right-hand side elements
        output[0] = product;

        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

    }
}

/*
Input:
3
1 2 3
Output:
6 3 2

Input:
3
5 2 2
Output:
4 10 10

 */