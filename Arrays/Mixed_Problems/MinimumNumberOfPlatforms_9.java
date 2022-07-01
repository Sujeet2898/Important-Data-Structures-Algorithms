/*

Link: https://www.youtube.com/watch?v=dxVcMDI7vyI

Problem Statement: Minimum Number of Platforms
You have been given two arrays, 'AT' and 'DT', representing the arrival and departure times of all trains that reach a railway station.
Your task is to find the minimum number of platforms required for the railway station so that no train needs to wait.
Note :
1. Every train will depart on the same day and the departure time will always be greater than the arrival time. For example, A train with arrival time 2240 and departure time 1930 is not possible.
2. Time will be given in 24H format and colons will be omitted for convenience. For example, 9:05AM will be given as "905", or 9:10PM will be given as "2110".
3. Also, there will be no leading zeroes in the given times. For example, 12:10AM will be given as “10” and not as “0010”.

 */

package Mixed_Problems;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberOfPlatforms_9 {

    public static int calculateMinPlatforms(int[] arrivalTime, int[] departureTime, int n){
        Arrays.sort(arrivalTime);
        Arrays.sort(departureTime);

        int platformNeeded = 1;
        int result = 1;
        int i = 1;    // pointer for next arrival of train in arrivalTimeArray
        int j = 0;    // pointer for first departure of train throughout the day in departureTimeArray

        while (i < n && j < n){

            // 1. Arrival train is coming before the departure train. So, a platform will be required.
            // 2. Arrival train and departure train at same time also require a platform.
            if (arrivalTime[i] <= departureTime[j]){
                platformNeeded++;
                i++;
            }

            // Departure train moves before an arrival train. So, a platform goes vacant.
            else if (arrivalTime[i] > departureTime[j]){
                platformNeeded--;
                j++;
            }

            // Update the result
            if (platformNeeded > result){
                result = platformNeeded;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arrivalTime = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTime[i] = scn.nextInt();
        }
        int[] departureTime = new int[n];
        for (int i = 0; i < n; i++) {
            departureTime[i] = scn.nextInt();
        }
        System.out.println(calculateMinPlatforms(arrivalTime,departureTime,n));
    }
}

/*
Input:
6
900 940 950 1100 1500 1800
910 1200 1120 1130 1900 2000
Output:
3
Explanation:
Train 1 arrived at 900 on platform 1.
Train 1 departed at 910 from platform 1.
Train 2 arrived at 940 on platform 1.
Train 3 arrived at 950 on platform 2 (since platform 1 was already occupied by train 1).
Train 4 arrived at 1100 on platform 3 (since both platforms 1 and 2 were occupied by trains 2 and 3 respectively).
Train 3 departed at 1120 from platform 2 (platform 2 becomes vacant).
Train 4 departed at 1130 from platform 3 (platform 3 also becomes vacant).
Train 2 departed at 1200 from platform 1 (platform 1 also becomes vacant).
Train 5 arrived at 1500 on platform 1.
Train 6 arrived at 1800 on platform 2.
Train 5 departed at 1900 from platform 1.
Train 6 departed at 2000 from platform 2.
Thus, minimum 3 platforms are needed for the given input.

Input:
4
100 200 300 400
200 300 400 500
Output:
2
Explanation:
Train 1 arrived at 100 on platform 1.
Train 2 arrived at 200 from platform 2 (as platform 1 is occupied by train 1).
Train 1 departed at 200 from platform 1.
Train 3 arrived at 300 on platform 1.
Train 2 departed at 300 from platform 2.
Train 4 arrived at 400 on platform 2.
Train 3 departed at 400 from platform 1.
Train 4 departed at 500 from platform 2.
Thus, 2 platforms are needed for the given input.

 */