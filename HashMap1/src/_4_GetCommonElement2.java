/*
Link: https://www.youtube.com/watch?v=jMwLFkI2Zbc&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=7
Question: Get Common Elements - 2
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to find the intersection of a1 and a2. To get an idea check the example below:

if a1 -> 1 1 2 2 2 3 5
and a2 -> 1 1 1 2 2 4 5
intersection is -> 1 1 2 2 5

Note -> Don't assume the arrays to be sorted.

 */

import java.util.HashMap;
import java.util.Scanner;

public class _4_GetCommonElement2 {

    public static void getCommonElement2(int[] arr1, int[] arr2){
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
            if (map.containsKey(val) && map.get(val) > 0){
                System.out.println(val); // 1. print
                int oldFrequency = map.get(val);
                int newFrequency = oldFrequency - 1;
                map.put(val, newFrequency);
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
        getCommonElement2(a1,a2);
    }
}

/*
Input:
7
1 1 2 2 2 3 5
7
1 1 1 2 2 4 5
Output:
1
1
2
2
5
 */