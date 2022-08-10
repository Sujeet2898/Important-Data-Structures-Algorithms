/*
Link: https://www.youtube.com/watch?v=pptk8cUHHUg&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=14
Question: Sort K-sorted Array
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. The array is nearly sorted. Every element is at-max displaced k spots left or right to it's position in the sorted array. Hence it is being called k-sorted array.
4. You are required to sort and print the sorted array.

Note -> You can use at-max k extra space and nlogk time complexity.
 */

import java.util.PriorityQueue;

public class _8_SortNearlySortedArray {

    public static void sortKSorted(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding first (K + 1) elements into funnel (PriorityQueue)
        for (int i = 0; i <= k; i++){
            pq.add(arr[i]);
        }

        // Maintaining the funnel (PriorityQueue) of k + 1 size by removing & adding one element
        for (int i = k + 1; i < arr.length; i++) {

            // Remove & print the minElement of the funnel (PriorityQueue)
            System.out.print(pq.remove() + " ");

            // Adding next element of K into funnel (PriorityQueue)
            pq.add(arr[i]);
        }

        // Remove & print the left elements of funnel (PriorityQueue)
        while (pq.size() > 0){
            System.out.print(pq.remove() + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,4,1,9,6,8};
        int k = 3;
        sortKSorted(arr, k);
    }
}

/*
Output:
1 2 4 6 8 9
*/