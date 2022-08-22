/*
Link: https://www.youtube.com/watch?v=9Kc0eZBGL1U&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=10
Question : Longest Substring With Non Repeating Characters i.e unique character
1. You are given a string.
2. You have to find the length of the longest substring of the given string that contains all non-repeating characters.
 */

import java.util.HashMap;
import java.util.Scanner;

public class _10_LongestSubstringNonRepeatingCharacters {

    public static int LongestSubstringNonRepeatingCharacters(String str) {
        int ans = 0;

        // Creating frequencyMap of str
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // Acquire till you become invalid
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);    // find character
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                // Checking repeating character
                if (map.get(ch) == 2){
                    break;

                }else {
                    // update ans
                    int length = i - j;
                    if (length > ans){
                        ans = length;
                    }
                }
            }

            // release till you become valid
            while (j < i) {
                f2 = true;
                j++;
                char ch = str.charAt(j); // hold character
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1) {
                    break;
                }
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(LongestSubstringNonRepeatingCharacters(str));
    }
}

/*
Input:
aabcbcdbca
Output:
4
 */