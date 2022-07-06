import java.util.*;

public class TripletsWithZeroSum_2 {

/*

Link: https://www.youtube.com/watch?v=onLoX6Nhvmg
timeSpan: 11:00

Problem Statement: Find All Triplets With Zero Sum

You are given an array Arr consisting of n integers, you need to find all the distinct triplets present in the array which adds up to zero.
An array is said to have a triplet {arr[i], arr[j], arr[k]} with 0 sum if there exists three indices i, j and k such that i!=j, j!=k and i!=k and arr[i] + arr[j] + arr[k] = 0.
Note :
1. You can return the list of values in any order. For example, if a valid triplet is {1, 2, -3}, then (2, -3, 1), (-3, 2, 1) etc is also valid triplet. Also, the ordering of different triplets can be random i.e if there are more than one valid triplets, you can return them in any order.
2. The elements in the array need not be distinct.
3. If no such triplet is present in the array, then return an empty list, and the output printed for such a test case will be "-1".

 */

    // Time Complexity: O(n^2)

    public static ArrayList<ArrayList<Integer>> tripletsWithZeroSum(int[] arr){
        // let a+b+c = 0

        // Firstly sort the array
        Arrays.sort(arr);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Pointer for 'a' while satisfying triplet
        for (int i = 0; i <= arr.length - 3; i++){

            // Avoiding duplicates of 'a'
            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])){

                // Keep lowPointer for 'b' and highPointer for 'c'
                int low = i + 1;
                int high = arr.length - 1;
                // Calculate -a which is the sum here
                int sum = 0 - arr[i];  // -a = b + c

                // Applying twoPointerApproach
                while (low < high){

                    // Case 1: b + c = -a
                    if (arr[low] + arr[high] == sum){

                        // Adding foundedTriplet into resultArraylist
                        ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(arr[i], arr[low], arr[high]));
                        result.add(triplet);

                        // Avoiding duplicates of 'b' while traversing
                        while (low < high && arr[low] == arr[low + 1]){
                            low++;
                        }
                        // Avoiding duplicates of 'c' while traversing
                        while (low < high && arr[high] == arr[high - 1]){
                            high--;
                        }

                        // For standing with different 'b' and 'c'
                        low++;
                        high--;
                    }

                    // Case 2: b + c < -a
                    else if (arr[low] + arr[high] < sum){
                        low++;
                    }

                    // Case 3: b + c < -a
                    else {
                        high--;
                    }
                }
            }
        }
        return result;
    }

    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(tripletsWithZeroSum(arr));
    }

     Input:
     6
     1 2 3 -1 -2 -3

     Output:
     [[-3, 1, 2], [-2, -1, 3]]

     */

    public static boolean sumOfTwoElementsEqualsThird(int[] arr, int target){
        boolean found = false;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++){
            int low = i + 1;
            int high = arr.length - 1;

            while (low < high){
                int current = arr[i] + arr[low] + arr[high];

                if (current == target){
                    found = true;
                }

                if (current < target){
                    low++;
                }
                // current > target
                else {
                    high--;
                }
            }
        }
        if (found){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(sumOfTwoElementsEqualsThird(arr, target));
    }
}


/*

Input:
6
12 3 7 1 6 9
24

Output:
true

 */