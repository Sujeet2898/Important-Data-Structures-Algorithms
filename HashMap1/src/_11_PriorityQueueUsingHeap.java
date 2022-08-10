/*
Link: https://www.youtube.com/watch?v=RIjxT24gUv4&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=20
Question: Write Priority Queue Using Heap (Implace Heap sort)
1. You are required to complete the code of our Priority Queue class using the heap data structure.
2. Here is the list of functions that you are supposed to complete:
    2.1. add -> Should accept new data.
    2.2. remove -> Should remove and return smallest value, if available or print
     "Underflow" otherwise and return -1.
     2.3. peek -> Should return smallest value, if available or print "Underflow"
     otherwise and return -1.
     2.4. size -> Should return the number of elements available.
3. Input and Output is managed for you.

** Heap Order Priority: Priority of parent is higher than its children everywhere. But there is no priority between left and right child.
                     Use- We get higher priority element at root so that peek() is implemented in O(1).

** Complete Binary Tree (CBT): (h-1) level is completely filled and h level will be filled from left to right.
                     Use- Add and Remove is implemented in logn.

** Important happening due to CBT: 1. height = O(logn)
                                   2. CBT -> ArrayList -> IndexFormula -> Parent -> UpHeapify -> add in O(logn).
                                   - Due to CBT, we are able to implement Arraylist.
                                   - Due to Arraylist, IndexFormula is applicable.
                                   - Due to IndexFormula, we are able to proceed towards Parent.
                                   - By these, we are able to do UpHeapify and UpHeapify is equal to height of CBT.
                                   - So, add is O(logn).

** IndexFormula: leftChildIndex = 2 * parentIndex + 1
                 rightChildIndex = 2 * parentIndex + 2
                 parentIndex = (childIndex - 1) / 2
 */

import java.util.ArrayList;

public class _11_PriorityQueueUsingHeap {

    public static class PriorityQueue {
        ArrayList<Integer> arr;

        public PriorityQueue() {
            arr = new ArrayList<>();
        }

        /* Add */

        public void add(int val) {
            arr.add(val);
            upheapify(arr.size() - 1);
        }

        private void upheapify(int i) {
            if (i == 0){
                return;
            }
            int pi = (i - 1)/2;
            if (arr.get(i) < arr.get(pi)){
                swap(i, pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j){
            int ith = arr.get(i);
            int jth = arr.get(j);
            arr.set(i, jth);
            arr.set(j, ith);
        }

        /* Remove */

        public int remove() {
            if (this.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            swap(0, arr.size() - 1);
            int val = arr.remove(arr.size() - 1);
            downheapify(0);
            return val;
        }

        private void downheapify(int pi) {
            int minIndex = pi;

            int leftIndex = 2 * pi + 1;
            if (leftIndex < arr.size() && arr.get(leftIndex) < arr.get(minIndex)){
                minIndex = leftIndex;
            }

            int rightIndex = 2 * pi + 2;
            if (rightIndex < arr.size() && arr.get(rightIndex) < arr.get(minIndex)){
                minIndex = rightIndex;
            }

            if (minIndex != pi){
                swap(pi, minIndex);
                downheapify(minIndex);
            }
        }

        /* Peek */

        public int peek() {
            if (this.size() == 0){
                System.out.println("Underflow");
                return -1;
            }
            return arr.get(0);  // return root
        }

        /* Size */

        public int size() {
            return arr.size();
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(40);
        System.out.println(pq.peek());  // 10
        pq.add(50);
        System.out.println(pq.peek());  // 10
        System.out.println(pq.remove()); // 10
        System.out.println(pq.peek());  // 20
        System.out.println(pq.remove()); // 20
        System.out.println(pq.peek());  // 30
        System.out.println(pq.remove()); //30
        System.out.println(pq.peek()); // 40
        System.out.println(pq.remove()); // 40
        System.out.println(pq.peek()); //50
    }
}

/*
Output:
10
10
10
20
20
30
30
40
40
50

 */