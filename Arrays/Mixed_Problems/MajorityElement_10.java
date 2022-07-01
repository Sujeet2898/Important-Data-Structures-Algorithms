/*

Link: https://www.youtube.com/watch?v=U1-mSBZFvqw

Problem: Majority Element N/2
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than n / 2 times.
Note: You may assume that the majority element always exists in the array.
Follow-up: Could you solve the problem in linear time and in O(1) space?

 */

package Mixed_Problems;

import java.util.ArrayList;
import java.util.Scanner;

public class MajorityElement_10 {

    public static int majorityElementNBy2(int[] nums) {
        int candidate = Integer.MIN_VALUE;
        int life = 0;  // initially candidate has no life

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == candidate){
                life++;
            }else if(life == 0){
                candidate = nums[i];
                life = 1;
            }else {
                life--;
            }
        }
        return candidate;
    }
    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(majorityElementNBy2(arr));
    }
     Input:
     3
     3 2 3
     Output:
     3

     Input:
     7
     2 2 1 1 1 2 2
     Output:
     2

     */

/*

Link: https://www.youtube.com/watch?v=U1-mSBZFvqw

Problem: Majority Element N/3
Given an integer array of size n, find all elements that appear more than n/3 times.
Follow-up: Could you solve the problem in linear time and in O(1) space?

Note: Maximum 3 Winner
      Minimum 0 Winner

 */

    public static ArrayList<Integer> majorityElementNBy3(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        int life1 = 0;  // initially candidate1 has no life
        int life2 = 0;  // initially candidate2 has no life

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == candidate1){
                life1++;

            }else if (nums[i] == candidate2){
                life2++;

            }else if(life1 == 0){
                candidate1 = nums[i];
                life1 = 1;

            }else if(life2 == 0){
                candidate2 = nums[i];
                life2 = 1;

            }else {
                life1--;
                life2--;
            }
        }

        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++){
            if (candidate1 == nums[i]){
                count1++;
            }
            if (candidate2 == nums[i]){
                count2++;
            }
        }

        if (count1 > nums.length/3){
            ans.add(candidate1);
        }
        if (count2 > nums.length/3){
            ans.add(candidate2);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(majorityElementNBy3(arr));
    }
}

/*
Input:
7
3 2 2 1 5 2 3
Output:
[2]

Input:
5
7 4 4 9 7
Output:
[7, 4]

 */