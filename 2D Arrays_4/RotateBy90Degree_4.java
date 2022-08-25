import java.util.Scanner;

public class RotateBy90Degree_4 {

    public static void rotate90(int[][] arr, int n){

        // Transpose
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Reversing each rows
        for(int i = 0; i < arr.length; i++){
            int li = 0;
            int ri = arr[i].length - 1;

            while (li < ri){
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;
                li++;
                ri--;
            }
        }

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        rotate90(arr, n);
    }
}

/*
Input:
3
11 12 13
21 22 23
31 32 33

Output:

 */