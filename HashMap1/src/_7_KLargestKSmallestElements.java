/*
Link: https://www.youtube.com/watch?v=taL2G6jDLog&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=12
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are given a number k.
4. You are required to find and print the k largest elements of array in increasing order.
 */
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class _7_KLargestKSmallestElements {

    public static ArrayList<Integer> kLargest(int input[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < input.length; i++){

            // Adding first K elements into funnel (PriorityQueue)
            if (i < k){
                pq.add(input[i]);

            }else {

                // If minElement of funnel (PriorityQueue) is smaller than the next element of K
                // then, remove the minElement & add next element of K into funnel (PriorityQueue)
                if (input[i] > pq.peek()){
                    pq.remove();
                    pq.add(input[i]);
                }
            }
        }

        ArrayList<Integer> output = new ArrayList<>();
        // Remove & print the elements as long as funnel (PriorityQueue) is empty
        while (pq.size() > 0){
            output.add(pq.remove());
        }
        return output;
    }

    public static ArrayList<Integer> kSmallest(int[] input, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());       // Max Priority Queue

        for (int i = 0; i < input.length; i++){

            // Adding first K elements into funnel (PriorityQueue)
            if (i < k){
                pq.add(input[i]);

            }else {

                // If maxElement of funnel (PriorityQueue) is greater than the next element of K
                // then, remove the maxElement & add next element of K into funnel (PriorityQueue)
                if (input[i] < pq.peek()){
                    pq.remove();
                    pq.add(input[i]);
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        // Remove & print the elements as long as funnel (PriorityQueue) is empty
        while (pq.size() > 0){
            output.add(pq.remove());
        }
        return output;
    }


    public static void main(String[] args) {
        int arr[] = {2,4,1,9,6,8};
        int k = 3;
        System.out.println(kLargest(arr, k));
        System.out.println(kSmallest(arr, k));
    }
}

/*
Output:
[6, 8, 9]
[4, 2, 1]
 */