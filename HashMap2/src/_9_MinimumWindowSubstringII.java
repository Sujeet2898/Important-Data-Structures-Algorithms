/*
Link: https://www.youtube.com/watch?v=pbUNTDdxomI&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=9
Question : Smallest Substring Of A String Containing All Unique Characters Of Itself
1. You are given a string str.
2. You have to find the smallest window length that contains all the unique characters of the given string.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _9_MinimumWindowSubstringII {

    public static int SmallestSubstringAllUniqueCharacters(String str) {
        int initialLength = str.length();

        // finding unique characters in string
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            set.add(ch);
        }

        // Creating frequencyMap of str
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // Acquire till it is invalid ( map.size() < set.size() )
            while (i < str.length() - 1 && map.size() < set.size()) {
                i++;
                char ch = str.charAt(i);    // find character
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                f1 = true;
            }

            // collect answer and release
            while (j < i && map.size() == set.size()) {
                // collect ans
                int potentialAns = i - j;
                if (potentialAns < initialLength) {
                    initialLength = potentialAns;
                }

                j++;
                char ch = str.charAt(j); // hold character
                // release character
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }

                f2 = true;
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }
        return initialLength;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(SmallestSubstringAllUniqueCharacters(str));
    }
}

/*
Input:
aabcbcdbca
Output:
4
 */