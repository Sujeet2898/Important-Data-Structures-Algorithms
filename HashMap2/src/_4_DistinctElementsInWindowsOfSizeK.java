/*
Link:
Question: Count Distinct Elements In Every Window Of Size K
1. You are given an array(arr) of integers and a number K.
2. You have to find the count of distinct numbers in all windows of size k.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class _4_DistinctElementsInWindowsOfSizeK {

    public static ArrayList<Integer> distinctElements(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        while (i < k - 1){  // windowSize = k
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            i++;
        }

        i--;
        int j = -1;

        // keep j = 0 for acquiring and i = k - 1 for releasing
        while (i < arr.length - 1){
            // Acquire
            i++;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            // Work
            list.add(map.size());

            // Release
            j++;
            int freq = map.get(arr[j]);
            if (freq == 1){
                map.remove(arr[j]);
            }else {
                map.put(arr[j], freq - 1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> ans = distinctElements(arr,k);
        for(int a : ans){
            System.out.print(a + " ");
        }
    }
}

/*

Input:
7
1 2 1 3 4 2 3
4

Output:
3 4 4 3

*/