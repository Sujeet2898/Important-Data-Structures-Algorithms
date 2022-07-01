package Mixed_Problems;

import java.util.Scanner;

public class SecondLargestElement_7 {

    // Time Complexity: O(n)

    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }
        return secondLargest;
    }

    /**
     * public static void main(String[] args) {
     * Scanner scn = new Scanner(System.in);
     * int n = scn.nextInt();
     * int arr[] = new int[n];
     * for(int i = 0; i < n; i++) {
     * arr[i] = scn.nextInt();
     * }
     * System.out.println(findSecondLargest(arr));
     * }
     * <p>
     * Input:
     * 6
     * 12 1 35 10 34 1
     * Output:
     * 34
     * <p>
     * Input:
     * 5
     * 10 10 10 10 10
     * Output:
     * -1
     */

    public static int findSecondSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest && arr[i] != smallest) {
                secondSmallest = arr[i];
            }
        }
        if (secondSmallest == Integer.MAX_VALUE) {
            return -1;
        }
        return secondSmallest;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(findSecondSmallest(arr));
    }
}

/*

Input:
6
12 1 35 10 34 1
Output:
10

Input:
5
10 10 10 10 10
Output:
-1


 */