/*
Q.  Running Median
-----------------------------------------------
Time Complexity: O(N * logN)
-----------------------------------------------
You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers, print the resulting median.
Print only the integer part of the median.
-----------------------------------------------
Input Format :
The first line of input contains an integer 'N', denoting the number of integers in the stream.
The second line of input contains 'N' integers separated by a single space.
-----------------------------------------------
Output Format :
Print the running median for every integer added to the running list in one line (space-separated)
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class _9_MedianPriorityQueue {
    public static void findMedian(int arr[])  {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());  // smaller half of data
        PriorityQueue<Integer> min = new PriorityQueue<>();  // greater half of data

        for(int val : arr) {

            // add()

            // For adding in Min PriorityQueue, it should not be empty
            // And value which is going to be added must be larger than peek value
            if (min.size() > 0 && val > min.peek()) {
                min.add(val);

            } else {

                // Generally adding is done on Max PriorityQueue
                max.add(val);
            }

            // Balancing is necessary if difference of size is greater than 1
            if (max.size() - min.size() == 2) {
                min.add(max.remove());
            } else if (min.size() - max.size() == 2) {
                max.add(min.remove());
            }

            // peek()

            if(max.size() > min.size()) {
                System.out.print(max.peek() + " ");
            }
            else if(max.size() < min.size()) {
                System.out.print(min.peek() + " ");
            }
            else {
                System.out.print( (max.peek() + min.peek()) / 2 + " ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 2, 1, 3, 7, 5};
        findMedian(arr);
    }
    /*
    Output:
    6 4 2 2 3 4
     */
}


/**
Link: https://www.youtube.com/watch?v=dshWERdcAdg&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=16
Question: Median Priority Queue
1. You are required to complete the code of our MedianPriorityQueue class. The class should mimic the behaviour of a PriorityQueue and give highest priority to median of it's data.
2. Here is the list of functions that you are supposed to complete
2.1. add -> Should accept new data.
2.2. remove -> Should remove and return median value, if available or print "Underflow" otherwise and return -1
2.3. peek -> Should return median value, if available or print "Underflow" otherwise and return -1
2.4. size -> Should return the number of elements available
3. Input and Output is managed for you.

Note -> If there are even number of elements in the MedianPriorityQueue, consider the smaller median as median value.
 */

/**
import java.io.*;
import java.util.*;

public class Main {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }

    public void add(int val) {
      if(right.size() > 0 && val > right.peek()){
        right.add(val);
      } else {
        left.add(val);
      }

      handleBalance();
    }

    private void handleBalance(){
      if(left.size() - right.size() == 2){
        right.add(left.remove());
      } else if(right.size() - left.size() == 2){
        left.add(right.remove());
      }
    }

    public int remove() {
      if (this.size() == 0) {
        System.out.println("Underflow");
        return -1;
      } else if (left.size() >= right.size()) {
        return left.remove();
      } else {
        return right.remove();
      }
    }

    public int peek() {
      if (this.size() == 0) {
        System.out.println("Underflow");
        return -1;
      } else if (left.size() >= right.size()) {
        return left.peek();
      } else {
        return right.peek();
      }
    }

    public int size() {
      return left.size() + right.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
 */

/*
Input:
add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit

Output:
20
30
30
20
20
40
40
10
10
50

 */