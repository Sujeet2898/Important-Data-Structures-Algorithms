import java.util.Scanner;

public class ShellRotate_5 {

    public static void rotateShell(int[][] arr, int s, int r){  // s-shell and r-rotate
        int[] oneD = fillOneDFromShell(arr, s);
        rotate(oneD, r);
        fillShellFromOneD(arr, s, oneD);
    }

    public static int[] fillOneDFromShell(int[][] arr, int s) {
        int minRow = s - 1;
        int minCol = s - 1;
        int maxRow = arr.length - s;
        int maxCol = arr[0].length - s;
        // int size = leftWall + bottomWall + rightWall + topWall - 4;  4 corners overlap
        // => int size = 2 * leftWall + 2 * bottomWall - 4;
        int size = 2 * (maxRow - minRow + 1) + 2 * (maxCol - minCol + 1) - 4;

        int[] oneD = new int[size];

        int idx = 0;
        // leftWall
        for (int i = minRow, j = minCol; i <= maxRow; i++){
            oneD[idx] = arr[i][j];
            idx++;
        }
        // bottomWall
        for (int i = maxRow, j = minCol + 1; j <= maxCol; j++){
            oneD[idx] = arr[i][j];
            idx++;
        }
        // rightWall
        for (int i = maxRow - 1, j = maxCol; i >= minRow; i--){
            oneD[idx] = arr[i][j];
            idx++;
        }
        // topWall
        for (int i = minRow, j = maxCol - 1; j >= minCol + 1; j--){
            oneD[idx] = arr[i][j];
            idx++;
        }
        return oneD;
    }

    public static void fillShellFromOneD(int[][] arr, int s, int[] oneD) {
        int minRow = s - 1;
        int minCol = s - 1;
        int maxRow = arr.length - s;
        int maxCol = arr[0].length - s;

        int idx = 0;
        // leftWall
        for (int i = minRow, j = minCol; i <= maxRow; i++){
            arr[i][j] = oneD[idx];
            idx++;
        }
        // bottomWall
        for (int i = maxRow, j = minCol + 1; j <= maxCol; j++){
            arr[i][j] = oneD[idx];
            idx++;
        }
        // rightWall
        for (int i = maxRow - 1, j = maxCol; i >= minRow; i--){
            arr[i][j] = oneD[idx];
            idx++;
        }
        // topWall
        for (int i = minRow, j = maxCol - 1; j >= minCol + 1; j--){
            arr[i][j] = oneD[idx];
            idx++;
        }
    }

    public static void rotate(int[] oneD, int r) {
        r = r % oneD.length;       //put modulus first
        if(r < 0) {
            r = r + oneD.length;
        }

        // part 1
        reverse(oneD, 0, oneD.length - r - 1);

        //part 2
        reverse(oneD, oneD.length - r, oneD.length - 1);

        //all
        reverse(oneD, 0, oneD.length - 1);
    }

    public static void reverse(int[] oneD, int li, int ri){
        while (li < ri){
            int temp = oneD[li];
            oneD[li] = oneD[ri];
            oneD[ri] = temp;
            li++;
            ri--;
        }
    }

    public static void display(int[][] arr){
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
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        int s = scn.nextInt(); // which shells do you want to rotate
        int r = scn.nextInt(); // by what value do you want to rotate
        rotateShell(arr, s, r);
        display(arr);
    }
}

/*
Input:
5
7
11 12 13 14 15 16 17
21 22 23 24 25 26 27
31 32 33 34 35 36 37
41 42 43 44 45 46 47
51 52 53 54 55 56 57
2
3

Output:
11 12 13 14 15 16 17
21 25 26 36 46 45 27
31 24 33 34 35 44 37
41 23 22 32 42 43 47
51 52 53 54 55 56 57
 */