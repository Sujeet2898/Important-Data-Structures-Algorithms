/*
Link: https://www.youtube.com/watch?v=Auk0E3E8G7c&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=11
Question : Count of Substring With Non Repeating Characters i.e unique character
1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.
 */

import java.util.HashMap;
import java.util.Scanner;

public class _11_CountOfSubstringsUniqueCharacters {

    // No. of Substring = n(n+1)/2
    public static int CountOfSubstringsUniqueCharacters(String str) {
        int ans = 0;

        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (true) {
            // For terminating
            boolean f1 = false;
            boolean f2 = false;

            // Acquire till you become invalid
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);    // find character
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                // Checking repeating character
                if (map.get(ch) == 2) {
                    break;

                } else {
                    // update ans
                    ans += i - j;
                }
            }

            // release till you become valid
            while (j < i) {
                f2 = true;
                j++;
                char ch = str.charAt(j); // hold character
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 1) {
                    ans += i - j;
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
        System.out.println(CountOfSubstringsUniqueCharacters(str));
    }
}

/*
Input:
aabcbcdbca
Output:
24
 */