/*
Link: https://www.youtube.com/watch?v=0nF-BMYy7tc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=19
Question: Arrange Buildings
1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
 */

import java.util.Scanner;

public class _12_ArrangeBuildings {

    public static long arrangeBuildings(long n){
        long oldBuilding = 1;
        long oldSpace = 1;

        for (int i = 2; i <= n; i++){
            long newBuilding = oldSpace;
            long newSpace = oldSpace + oldBuilding;

            oldSpace = newSpace;
            oldBuilding = newBuilding;
        }

        long total = oldSpace + oldBuilding;
        total = total * total;
        return total;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextInt();
        System.out.println(arrangeBuildings(n));
    }
}

/*
Input:
6
Output:
441
 */