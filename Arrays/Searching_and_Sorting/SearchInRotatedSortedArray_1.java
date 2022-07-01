/*

Link:  https://www.youtube.com/watch?v=1uu3g_uu8O0&t=429s

Problem Statement: Search In Rotated Sorted Array
Aahad and Harshit always have fun by solving problems. Harshit took a sorted array consisting of distinct integers and rotated it clockwise by an unknown amount. For example, he took a sorted array = [1, 2, 3, 4, 5] and if he rotates it by 2, then the array becomes: [4, 5, 1, 2, 3].
After rotating a sorted array, Aahad needs to answer Q queries asked by Harshit, each of them is described by one integer Q[i]. which Harshit wanted him to search in the array. For each query, if he found it, he had to shout the index of the number, otherwise, he had to shout -1.
For each query, you have to complete the given method where 'key' denotes Q[i]. If the key exists in the array, return the index of the 'key', otherwise, return -1.
Note:
Can you solve each query in O(logN) ?
 */

package Searching_and_Sorting;

import java.util.Scanner;

public class SearchInRotatedSortedArray_1 {

    public static int search(int arr[], int key){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){
            int mid = (low + high)/2;

            // Case 1: mid itself is the key
            if (arr[mid] == key){
                return mid;
            }
            // Case 2: low to mid is sorted
            else if (arr[low] <= arr[mid]){

                if (key >= arr[low] && key < arr[mid]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
            // Case 3: mid to high is sorted
            else if (arr[mid] <= arr[high]){

                if (key > arr[mid] && key <= arr[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];

        for(int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        int key = sc.nextInt();
        System.out.println(search(a,key));
    }
}

/*
Input:
4
2 5 -3 0
5
Output:
1

Input:
5
100 -2 6 10 11
100
Output:
0

 */


/*

*************************************************

Binary Search:
--------------
import java.util.*;
public class Main{

    public static int binarySearch(int a[], int si, int ei, int x){
       if (si > ei) {
           return -1;
       }
       int midIndex = (si + ei)/2;
       if (a[midIndex] == x) {
           return midIndex;
       } else if (a[midIndex] < x) {
           return binarySearch(a, midIndex + 1, ei, x);
       } else {
           return binarySearch(a, si, midIndex - 1, x);
       }
    }

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]=new int[n];

       for(int i = 0; i < n; i++){
           a[i]=sc.nextInt();
          }
       int x = sc.nextInt();
		System.out.println(binarySearch(a, 0, a.length - 1, x));
	}
}

input:
5
2 5 8 9 6
5

output:
1

 */