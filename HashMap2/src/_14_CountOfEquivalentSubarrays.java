/*
Link: https://www.youtube.com/watch?v=ceRJzjBrhPU&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=14
Question: Equivalent Subarrays
1. You are given an array of integers(arr).
2. You have to find the count of equivalent subarrays.
3. A subarray is equivalent if, count of unique integers in the subarray = count of unique integers in the given array.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _14_CountOfEquivalentSubarrays {

    public static void countOfEquivalentSubarrays(int[] arr){

        // finding unique characters in string
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int k = set.size();

        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (true){
            boolean f1 = false;
            boolean f2 = false;

            // Acquire
            while (i < arr.length - 1){
                f1 = true;

                i++;
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

                if (map.size() == k){
                    ans += arr.length - i;
                    break;
                }
            }

            // Release
            while (j < i){
                f2 = false;

                j++;
                if (map.get(arr[j]) == 1){
                    map.remove(arr[j]);
                }else {
                    map.put(arr[j], map.get(arr[j] - 1));
                }

                if (map.size() == k){
                    ans += arr.length - i;
                }else {
                    break;
                }
            }

            if (f1 == false && f2 == false){
                break;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        countOfEquivalentSubarrays(arr);
    }
}

/*
Input:
5
2 1 3 2 3

Output:
5

 */