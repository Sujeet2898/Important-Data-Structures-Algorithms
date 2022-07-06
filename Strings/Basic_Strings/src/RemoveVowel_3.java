/*

Link: https://www.youtube.com/watch?v=kRV7dsaCZ6E

Problem Statement: Remove Vowels
You are given a string STR of length N. Your task is to remove all the vowels present in that string and print the modified string.
English alphabets ‘a’, ‘e’, ‘i’, ‘o’, ‘u’ are termed as vowels. All other alphabets are called consonants.
Note: You have to only remove vowels from the string. There will be no change in the relative position of all other alphabets.

 */

import java.util.Scanner;

public class RemoveVowel_3 {

    public static String removeVowels(String str){
        str = str.replaceAll("[AEIOUaeiou]", "");
        return str;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(removeVowels(str));
    }
}


/*
Input:
Mobile
Output:
Mbl

Input:
Where are you?
Output:
Whr r y?

 */