/*

Link: https://www.youtube.com/watch?v=6Qkail843d8&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=25

Question 1: Isomorphic Strings

1. You are given two strings s1 and s2.
2. You have to determine if they are isomorphic or not.
3. Two strings are called isomorphic if -
   -> Every character of s1 can be mapped with characters of s2.
   -> A character of s1 can be mapped to only one character.
   -> All occurrences of a character must be replaced with another character while preserving the order of characters.
Note -> Length of s1 is equal to the length of s2.

 */

import java.util.HashMap;
import java.util.Scanner;

public class StringsMapping_4 {

    // Isomorphic Strings: follow one to one, not follow one to many or many to one

    public static boolean isIsomorphic(String str, String target) {

        if (str.length() != target.length()){
            return false;
        }

        // Creating first map for mapping characters of first string with second string
        HashMap<Character, Character> map1 = new HashMap<>();

        // Creating second map for checking the left characters of second string for using
        HashMap<Character, Boolean> map2 = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            // taking one character from both string
            char ch1 = str.charAt(i);
            char ch2 = target.charAt(i);

            // When string is mapped with target
            if (map1.containsKey(ch1) == true){

                // Checking mapping of character
                if (map1.get(ch1) != ch2){
                    return false;
                }
            }
            // When string is not mapped with target, then making mapping of string with target possible, and for this, ch2 must be unused.
            else {
                // ch2 is already used
                if (map2.containsKey(ch2) == true){
                    return false;
                }
                // ch2 is not used
                else {
                    map1.put(ch1, ch2); // mapping is ch1 with ch2 is done in map1
                    map2.put(ch1, true); // ch2 has been used for mapping
                }
            }
        }
        return true;
    }

    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String A = scn.next();
        String B = scn.next();
        System.out.print(isIsomorphic(A, B));
    }

     Input:
     pepcoding
     sosherlok

     Output:
     false

     */

/*

Link: https://www.youtube.com/watch?v=L-Kw6unCGQ4&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=26

Question 2: Word Pattern

1. You are given two strings S1 and S2. S1 represents a word of length N and S2 represents N space-separated words.
2. You have to find if the words in S2 follow the exact order as characters in S1.
Note -> Every string consists of lower-case English letters only.

 */

    public static boolean wordPattern(String pattern, String str) {

        // Using split function for converting string into words and storing into array of string
        String[] words = str.split(" ");

        // Creating first map for mapping character of pattern with word of string
        HashMap<Character, String> map1 = new HashMap<>();

        // Creating second map for checking the used 'word' of string for not using it again
        HashMap<String, Boolean> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++){
            // taking character from pattern
            char ch = pattern.charAt(i);

            // When character is mapped with word
            if (map1.containsKey(ch) == true){

                // Checking mapping of character with word
                String mWith = map1.get(ch);
                if (mWith.equals(words[i]) == false){     // Only difference is here from 1 question
                    return false;
                }
            }
            // When character is not mapped with word, then making mapping of character with word possible, and for this, word must be unused.
            else {
                // word is already used
                if (map2.containsKey(words[i]) == true){
                    return false;
                }
                // word is not used
                else {
                    map1.put(ch, words[i]); // mapping is character with word is done in map1
                    map2.put(words[i], true); // word has been used for mapping
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pattern = scn.nextLine();
        String words = scn.nextLine();
        System.out.println(wordPattern(pattern,words));
    }
}

/*
Input:
abab
pep coding pep coding

Output:
true

 */