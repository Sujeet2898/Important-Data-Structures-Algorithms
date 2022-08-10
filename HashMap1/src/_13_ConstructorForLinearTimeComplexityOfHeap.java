import java.util.ArrayList;

public class _13_ConstructorForLinearTimeComplexityOfHeap {

    public static class PriorityQueue {
        ArrayList<Integer> arr;

        public PriorityQueue(int[] array) {
            arr = new ArrayList<>();
            for(int val : array){
                arr.add(val);
            }

            for (int i = arr.size()/2 - 1; i >= 0; i--){
                downheapify(i);
            }
        }

        /*
        Time Complexity: O(n)
        ----------------------
        T(n) = 2^0*h + 2^1*(h-1) + 2^2*(h-2) + ..... + 2^(h-2)*1 + 2^(h-1)*0   ---(1)
        => 2T(n) = 2^1*h + 2^2*(h-1) + 2^3*(h-2) + ..... + 2^(h-1)*1    -------------(2)
        Now, (2)-(1)
        T(n) = -2^0*h + 2^1 + 2^2 + 2^3 + ....... + 2^(h-1)
        => T(n) = -h + (-2^0 + 2^0) + 2^1 + 2^2 + 2^3 + ....... + 2^(h-1)
        => T(n) = -h - 2^0 + (1*2^h - 1)/(2-1) where a = 2^0 = 1; r = 2; n = h
        => T(n) = -h - 1 + (2^h-1)
        => T(n) = 2^h - h - 2
        => T(n) = 2^logn - logn - 2
        => T(n) = n - logn - 2
        => T(n) = O(n)

         */

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
        int[] array = {10, 2, 3, 18, 9, 22};
        PriorityQueue pq = new PriorityQueue(array);

        while (pq.size() > 0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}

/*
Output:
2
3
9
10
18
22

 */