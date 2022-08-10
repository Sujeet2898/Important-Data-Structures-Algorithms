/*
Link: https://www.youtube.com/watch?v=HPSykge6EGw&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=5
Question: Get Common Elements - 1
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2). Make sure to not print duplicates (a2 may have same value present many times).
 */

import java.util.HashMap;
import java.util.Scanner;

public class _3_GetCommonElement1 {

    public static void getCommonElement1(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int val : arr1) {
            if (map.containsKey(val)) {
                int oldFrequency = map.get(val);
                int newFrequency = oldFrequency + 1;
                map.put(val, newFrequency);
            } else {
                map.put(val, 1);
            }
        }

        for (int val : arr2) {
            if (map.containsKey(val)){
                System.out.println(val); // 1. print
                map.remove(val); // 2. remove (so that it can't be printed again)
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < a1.length; i++){
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < a2.length; i++){
            a2[i] = scn.nextInt();
        }
        getCommonElement1(a1,a2);
    }
}

/*
Input:
9
5 5 9 8 5 5 8 0 3
18
9 7 1 0 3 6 5 9 1 1 8 0 2 4 2 9 1 5
Output:
9
0
3
5
8
 */