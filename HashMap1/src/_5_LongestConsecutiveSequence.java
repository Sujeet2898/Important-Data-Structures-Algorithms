/*
Link: https://www.youtube.com/watch?v=YWXbu5uyGXs
Problem Statement: Longest Consecutive Sequence
You are given an unsorted array/list 'ARR' of 'N' integers. Your task is to return the length of the longest consecutive sequence.
The consecutive sequence is in the form ['NUM', 'NUM' + 1, 'NUM' + 2, ..., 'NUM' + L] where 'NUM' is the starting integer of the sequence and 'L' + 1 is the length of the sequence.
Note:
If there are any duplicates in the given array we will count only one of them in the consecutive sequence.
// Time Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Scanner;

public class _5_LongestConsecutiveSequence {

    public static void longestConsecutiveSequence(int[] arr){

        HashMap<Integer, Boolean> map = new HashMap<>();

        // Assuming each value is start of sequence which is initialized with true
        for (int val : arr){
            map.put(val, true);
        }

        // value is not a start of sequence if it follows pre-smaller-value, and it should be marked with false
        for (int val : arr){
            if (map.containsKey(val - 1)){
                map.put(val, false);
            }
        }

        int maxStartPoint = 0;
        int maxLength = 0;

        // Work only for true value
        for (int val : arr) {
            if (map.get(val) == true) {
                int tempLength = 1;
                int tempStartPoint = val;

                while (map.containsKey(tempStartPoint + tempLength)) {
                    tempLength++;   // increasing sequence
                }

                // update startPoint & length
                if (tempLength > maxLength) {
                    maxStartPoint = tempStartPoint;
                    maxLength = tempLength;
                }
            }
        }

        // printing LongestConsecutiveSequence
        for (int i = 0; i < maxLength; i++){
            System.out.print(maxStartPoint + i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        longestConsecutiveSequence(arr);
    }
}

/*
Input:
17
12 5 1 2 10 2 13 7 11 8 9 11 8 9 5 6 11
Output:
5 6 7 8 9 10 11 12 13

 */