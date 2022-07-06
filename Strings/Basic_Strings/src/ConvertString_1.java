/*

Link: https://www.youtube.com/watch?v=cxdW7mejw9s

Problem Statement
You are given a string 'STR'. You have to convert the first alphabet of each word in a string to UPPER CASE.
Note:
'STR' will contain only space and alphabets both uppercase and lowercase. The words will be separated by space.

 */

import java.util.Scanner;

public class ConvertString_1 {

    public static String convertString(String str){

        // Add blank space at start
        str = " " + str;

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++){

            // finding character one by one
            char ch = str.charAt(i);

            if (ch == ' '){
                resultBuilder.append(ch);  // result += ch;
                i++;
                ch = str.charAt(i);
                resultBuilder.append(Character.toUpperCase(ch));   // result += Character.toUpperCase(ch);
            }else {
                resultBuilder.append(ch);  // result += ch;
            }
        }
        String result = resultBuilder.toString();
        // for removing extra space at start and end
        result = result.trim();
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(convertString(str));
    }
}

/*
Input:
they are playing cricket
Output:
They Are Playing Cricket

 */