import java.util.Scanner;

public class ContainerWithMostWater_3 {

/*
Link: https://www.youtube.com/watch?v=ZHQg07n_tbg

Problem Statement: Container With Most Water

Given a sequence of ‘N’ space-separated non-negative integers A[1],A[2],A[3],......A[i]…...A[n]. Where each number of the sequence represents the height of the line drawn at point 'i'. Hence on the cartesian plane, each line is drawn from coordinate ('i',0) to coordinate ('i', 'A[i]'), here ‘i’ ranges from 1 to ‘N’. Find two lines, which, together with the x-axis forms a container, such that the container contains the most area of water.
Note :
1. You can not slant the container i.e. the height of the water is equal to the minimum height of the two lines which define the container.
2. Do not print anything, you just need to return the area of the container with maximum water.

 */

    // Time Complexity: O(n)

    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int maxAr = 0;

        // Applying twoPointerApproach
        while (left < right){
            int leftHeight = height[left];
            int rightHeight = height[right];

            int minHeight = Math.min(leftHeight, rightHeight);
            int length = right - left;
            int currArea = minHeight * length;

            maxAr = Math.max(maxAr, currArea);
            if (leftHeight < rightHeight){
                left++;
            }else {
                right--;
            }
        }
        return maxAr;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(maxArea(arr));
    }
}


/*

Input:
5
4 3 2 1 4

Output:
16

 */