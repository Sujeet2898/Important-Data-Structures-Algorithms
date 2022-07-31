/*
Link: https://www.youtube.com/watch?v=ErPZFxugYkI&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=7
Question: Number Of Islands
1. You are given a 2d array where 0's represent land and 1's represent water.
     Assume every cell is linked to it's north, east, west and south cell.
2. You are required to find and count the number of islands.
 */

import java.util.Scanner;

public class _6_NumberOfIslands {

    public static void countNumberOfIslands(int[][] arr){
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] == 0 && visited[i][j] == false){
                    drawTreeForComponent(arr, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void drawTreeForComponent(int[][] arr, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j] == true){
            return;
        }

        visited[i][j] = true;
        drawTreeForComponent(arr, i - 1, j, visited);  // North
        drawTreeForComponent(arr, i, j + 1, visited);  // East
        drawTreeForComponent(arr, i, j - 1, visited);  // West
        drawTreeForComponent(arr, i + 1, j, visited);  // South
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int m = Integer.parseInt(scn.nextLine());
        int n = Integer.parseInt(scn.nextLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++){
            String parts = scn.nextLine();
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        countNumberOfIslands(arr);
    }
}

/*
Input:
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0

Output:
3

 */