/*

Link: https://www.youtube.com/watch?v=awMDD7sGWVU&t=61s

 */


package Prefix_and_Suffix_Sum;

import java.util.Scanner;

public class SearchElementInInfiniteSortedArray_1 {

    // Time Complexity: O(logn) as  O(logn) + O(logn) = O(logn)

    public static int searchInfinite(int[] arr, int key){
        int low = 0;
        int high = 1;

        while (arr[high] < key){
            low = high;
            high = 2 * high;
        }
        return binarySearch(arr, key);
    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (key > arr[mid]) {
                low = mid + 1;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                key = mid;
            }
        }
        return key;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];

        for(int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int key = sc.nextInt();
        System.out.println(searchInfinite(a,key));
    }
}


/*
Input:
10
1 3 7 8 12 58 72 85 96 97
58
Output:
5

 */