/*
Problem Statement: Quicksort using the Dutch national flag algorithm
You are given an array/list of integers. You are supposed to sort the array in non-decreasing order by applying Quicksort using the Dutch national flag algorithm.
The Dutch National Flag algorithm is used to sort an array/list consisting of only three distinct elements in one iteration by placing all occurrences of the smallest element at the beginning of the array and all occurrences of the biggest element at the end of the array.
 Time Complexity: O(nlogn)
 */

package Dutch_National_Flag_Algorithm;

import java.util.Scanner;

public class QuicksortUsingDutch {

    public static void quickSortUsingDutchNationalFlag(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int a[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pivotIndex = partition(a, si, ei);
        quickSort(a, si, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, ei);
    }

    private static int partition(int a[], int si, int ei) {
        int pivotElement = a[si];
        int smallerNumCount = 0;
        for (int i = si + 1; i <= ei; i++) {
            if (a[i] < pivotElement) {
                smallerNumCount++;
            }
        }
        int temp = a[si + smallerNumCount];
        a[si + smallerNumCount] = pivotElement;
        a[si] = temp;

        // Take i = si & j = ei to avoid runtimeError (ArrayIndexOutOfBoundsException)
        int i = si;
        int j = ei;
        while (i < j) {
            if (a[i] < pivotElement) {
                i++;
            } else if (a[j] >= pivotElement) {
                j--;
            } else {
                temp = a[i];      // If both above condition is incorrect
                a[i] = a[j];      // So, we swap both wrong elements left and right of pivotElement
                a[j] = temp;
                i++;
                j--;
            }
        }
        return si + smallerNumCount;    // return pivotIndex
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for(int i = 0; i < n; i++){
            a[i]=sc.nextInt();
        }
        quickSortUsingDutchNationalFlag(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

/*
Input:
5
4 2 1 4 2
Output:
1 2 2 4 4

Input:
5
5 2 7 3 5
Output:
2 3 5 5 7

 */

/*
******************************************************************
package Dutch_National_Flag_Algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static ArrayList<Integer> quickSortUsingDutchNationalFlag(ArrayList<Integer> arr){
        quickSort(arr, 0, arr.size() - 1);
        return arr;
    }

    private static void quickSort(ArrayList<Integer> a, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pivotIndex = partition(a, si, ei);
        quickSort(a, si, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, ei);

    }

    private static int partition(ArrayList<Integer> a, int si, int ei) {
        int pivotElement = a.get(si);
        int smallerNumCount = 0;
        for (int i = si + 1; i <= ei; i++) {
            if (a.get(i) < pivotElement) {
                smallerNumCount++;
            }
        }
        int temp = a.get(si + smallerNumCount);
        a.set(si + smallerNumCount, pivotElement);
        a.set(si, temp);

        // Take i = si & j = ei to avoid runtimeError (ArrayIndexOutOfBoundsException)
        int i = si;
        int j = ei;
        while (i < j) {
            if (a.get(i) < pivotElement) {
                i++;
            } else if (a.get(j) >= pivotElement) {
                j--;
            } else {
                temp = a.get(i);      // If both above condition is incorrect
                a.set(i, a.get(j));      // So, we swap both wrong elements left and right of pivotElement
                a.set(j, temp);
                i++;
                j--;
            }
        }
        return si + smallerNumCount;    // return pivotIndex
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>(n);

        for(int i = 0; i < n; i++){
            a.set(i, sc.nextInt());
        }
        quickSortUsingDutchNationalFlag(a);
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
    }
}

Input:
5
4 2 1 4 2
Output:
1 2 2 4 4

Input:
5
5 2 7 3 5
Output:
2 3 5 5 7

 */
