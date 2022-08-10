/*
Heap Time Complexity:
1. Add: logn
2. Remove: logn
3. Peek: logn

Below is Space Heap Sort
 */

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _6_HeapSort {

    // Increasing Order
    public static void increasingHeapSort(int[] arr){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : arr){   // nlogn
            pq.add(val);
        }

        while (pq.size() > 0){   // nlogn
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }


    // Decreasing Order
    public static void decreasingHeapSort(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int val : arr){   // nlogn
            pq.add(val);
        }

        while (pq.size() > 0){    // nlogn
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        increasingHeapSort(arr);
        System.out.println();
        decreasingHeapSort(arr);
    }
}

/*
Input:
7
22 99 3 11 88 4 1

Output:
1 3 4 11 22 88 99
99 88 22 11 4 3 1

 */