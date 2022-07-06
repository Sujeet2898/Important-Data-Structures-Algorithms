import java.util.Scanner;

public class LongestMountainSubarray_1 {

/*

Link: https://www.youtube.com/watch?v=VXeukMTbxkw

Question : Longest Mountain Subarray

You are given an array of 'N' integers denoting the heights of the mountains. You need to find the length of the longest subarray which has the shape of a mountain.
A mountain subarray is defined as a subarray which consists of elements that are initially in ascending order until a peak element is reached and beyond the peak element all other elements of the subarray are in decreasing order.

 */

    public static int longestMountain(int arr[], int n){
        int ans = 0;

        // 1 to n-2 are possible peek of mountain except 0 & n-1
        for (int i = 1; i <= n - 2; i++){
            // condition for peek : peek must be greater than its neighbours
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]){

                int count = 1;
                // traversing left of mountain
                int j = i;
                while (j > 0 && arr[j] > arr[j - 1]){
                    j--;
                    count++;
                }

                // traversing right of mountain
                while (i < n - 1 && arr[i] > arr[i + 1]){
                    i++;
                    count++;
                }

                ans = Math.max(count, ans);

            }else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(longestMountain(arr, n));
    }
}

/*

Input:
6
1 3 1 4 3 1

Output:
4

 */