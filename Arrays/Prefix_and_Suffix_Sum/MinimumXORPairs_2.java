/*

Link: https://www.youtube.com/watch?v=OZ2jghS0t24&t=56s

Problem: Min XOR Pairs
You are given an array of distinct integers.
You have to print all pairs of integers in the array whose XOR values is minimum.

Note: Bitwise XOR operation takes two numbers and performs XOR operation on every bit of those two numbers. For example, consider two numbers 2 and 3 their bitwise XOR will be 1. Because the binary representation of 2 is '10' and the binary representation of 3 is '11'. And XOR of '10' and '11' will be '01'(because XOR evaluates to 0 if the corresponding bits are the same in both the operands, otherwise it evaluates to 1), which is equal to 1.

// Time Complexity: O(nlogn + n)

 */

package Prefix_and_Suffix_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumXORPairs_2 {

    public static void minimumXORPairs(int[] arr){

        // firstly sort the array
        Arrays.sort(arr);

        // Store the result in string so that equal xor pair
        ArrayList<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++){

            // min xor will be of immediate pair
            // if a <= b <= c, then a^b < a^c or b^c < a^c
            int xor = arr[i] ^ arr[i + 1];
            if (xor < min){
                min = xor;
                result = new ArrayList<>();
                result.add(arr[i] + ", " + arr[i + 1]);
            }else if (xor == min){
                result.add(arr[i] + ", " + arr[i + 1]);
            }
        }

        for (String val : result){
            System.out.println(val);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];

        for(int i = 0; i < n; i++){
            arr[i]=sc.nextInt();
        }
        minimumXORPairs(arr);
    }
}

/*

Input:
4
2 0 5 7
Output:
0, 2
5, 7

 */