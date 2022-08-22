/*
Link:  https://www.youtube.com/watch?v=C9-n_H7dsvU&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=6
Question: Count Of All Subarrays With Zero Sum
1. You are given an array(arr) of integers.
2. You have to find the count of all subarrays with sum 0.
 */

import java.util.HashMap;

public class _6_CountOfZeroSumSubarray {

    public static int countOfZeroSumSubArray(int[] arr){
        int count = 0;

        // HashMap contains sum and frequency of that sum
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int i = -1;

        // Put frequency 1 at sum 0
        map.put(0, 1);

        while (i < arr.length - 1){
            i++;
            sum += arr[i];

            if (map.containsKey(sum)){
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,8,-3,-5,2,-4,6,1,2,1,-3,4,-1,-3};
        System.out.println(countOfZeroSumSubArray(arr));
    }
}

/*
output:
11
 */