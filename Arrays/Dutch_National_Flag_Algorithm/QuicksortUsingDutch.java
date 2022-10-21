/*
Problem Statement: Quicksort using the Dutch national flag algorithm
You are given an array/list of integers. You are supposed to sort the array in non-decreasing order by applying Quicksort using the Dutch national flag algorithm.
The Dutch National Flag algorithm is used to sort an array/list consisting of only three distinct elements in one iteration by placing all occurrences of the smallest element at the beginning of the array and all occurrences of the biggest element at the end of the array.
 Time Complexity: O(nlogn)
 */

package Dutch_National_Flag_Algorithm;

import java.util.Scanner;

public class QuicksortUsingDutch {
 
 // Time Complexity: O(nlogn)
 // Space Complexity: O(logn) or O(1)

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

----------MergeSort-----------------

// Time Complexity: O(nlogn)
// Space Complexity: O(n)

    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length-1);
        return nums;
    }

    public void mergesort(int[] nums, int si, int ei){
        if(si == ei){
            return;
        }
        int mid = (si + ei) / 2;
        mergesort(nums, si, mid);
        mergesort(nums, mid + 1, ei);
        merge(nums, si, mid, ei);

    }

    public void merge(int[] nums, int si, int mid, int ei){
        int i = si;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[ei - si + 1];
        while( i <= mid && j <= ei){
            if (nums[i] < nums[j]){
                temp[k] = nums[i];
                k++;
                i++;
            }
            else{
                temp[k] = nums[j];
                k++;
                j++;
            }
        }

        //copy remaining elements
        while (i <= mid) {
            temp[k] = nums[i];
            k++;
            i++;
        }
        //copy remaining elements
        while (j <= ei) {
            temp[k] = nums[j];
            k++;
            j++;
        }

        // putting element in sorted array in original array
        k = 0;
        for (k = 0; k < temp.length; k++){
            nums[si + k] = temp[k];
        }
    }



----------BubbleSort-----------------
/* Logic: We fill the heaviest element from last so that the length of the array to be sorted decreases from end.
In bubble sort, we run n-1 times loop. In the first loop, we pick the heaviest element from the array and push them at the end. 
In the second loop, we pick the second heaviest element and push them at the second last and so on, so that elements get arranged from the end. 
And we are only left with the nth element which is the lightest one which automatically gets placed at the beginning. 
And everytime, we get the heaviest element by swapping the elements pairwise. 
Disadvantage: Unnecessary swapping is done at each iteration unlike selection sort.
Advantage: It is In-Place sort. It is also stable as it does not change the relative order of elements with equal keys.
*/
 
// Time Complexity: O(n^2)
// Space Complexity: O(1)
 
 public static void bubble(int[] arr) {
       for(int i = 0; i < arr.length - 1; i++) {
           for(int j = 0; j < arr.length - 1 - i; j++) {
               if(arr[j] > arr[j + 1]) {
                   //swap
                   int temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j +1 ] = temp;
               }
           }
       }
   }

 
----------SelectionSort-----------------
/* Logic: We fill the smallest element from the beginning so that the length of the array to be sorted decreases from front.
In selection sort, we pick the smallest element from the array and push them at the beginning.
We also run a n-1 times loop. In the first loop, we assume the 0th index of the array as the smallest element and keep comparing it with the next element 
to find the appropriate position of the smallest element of the array. And swap that smallest element with the 0th index element. 
In the second loop, we assume the 1th index of the array as the smallest element and continue the same process for it and so on.
Advantage: One swapping per iteration unlike bubble sort. And In-Place sort.
*/

// Time Complexity: O(n^2)
// Space Complexity: O(1)
 
   public static void selection(int[] arr) {
       for(int  i= 0; i < arr.length - 1; i++) {
           int smallest = i;                     
           for(int j = i + 1; j < arr.length; j++) {
               if(arr[j] < arr[smallest]) {
                   smallest = j;
               }
           }
           //swap
           int temp = arr[smallest];
           arr[smallest] = arr[i];   
           arr[i] = temp;
       }
   }

 
 
----------InsertionSort-----------------
/* In insertion sort, we generally divide the array into sorted and unsorted parts. After that we start picking elements one by one from the unsorted array, 
and place it in its correct position in the sorted array. In this way, the sorted array slowly increases and the unsorted array slowly decreases. And at the end, the whole array gets sorted.
Advantage: Stable sort, In-Place sort, Number of swaps reduced unlike bubble sort, Total no. of steps is also reduced for partially sorted array.
Disadvantage: It is generally used when the value of n is small. For larger values of n, it is inefficient.
*/
 
// Time Complexity: O(n^2)
// Space Complexity: O(1)
 
    public static void selection(int[] arr) {
       for(int i = 1; i < arr.length; i++) {    // run in unsorted array
           int current = arr[i];  // picking the current element
           int j = i - 1;         // pick the last index of sorted part
           while(j >= 0 && current < arr[j]) {   // move in the sorted part with help of j till it is greater than 0 and compare current element with index of j element
                //Keep swapping
                arr[j + 1] = arr[j];    //making space for bigger value than current value
                j--;
           }
               //place the element in the correct position if the condition dissatisfied
           arr[j + 1] = current;
       }
   }



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
