/*
Link: https://www.youtube.com/watch?v=e1HlptlipB0&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=8
Question : Smallest Substring Of A String Containing All Characters Of Another String
1. You are given two strings s1 and s2 containing lowercase english alphabets.
2. You have to find the smallest substring of s1 that contains all the characters of s2.
3. If no such substring exists, print blank string("").
 */

import java.util.HashMap;
import java.util.Scanner;

public class _8_MinimumWindowSubstring {

    public static String SmallestSubstringAllCharactersAnother(String s1, String s2){
        String ans = "";

        // Creating frequencyMap of s2
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);    // take character
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        int matchCount = 0;
        int desireMatchCount = s2.length();
        // Creating frequencyMap of s1
        HashMap<Character, Integer> map1 = new HashMap<>();
        int i = -1;
        int j = -1;

        while (true){
            boolean f1 = false;
            boolean f2 = false;

            // Acquire
            while (i < s1.length() - 1 && matchCount < desireMatchCount){
                i++;
                char ch = s1.charAt(i);    // hold character
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

                // checking acquired character
                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){   // less or equal
                    matchCount++;
                }
                f1 = true;
            }

            // collect answer and release
            while (j < i && matchCount == desireMatchCount){
                // collect ans
                String potentialAns = s1.substring(j + 1, i + 1); // j = -1 to i as i + 1 is not included in subString
                if (ans.length() == 0 || potentialAns.length() < ans.length()){
                    ans = potentialAns;
                }

                j++;
                char ch = s1.charAt(j); // hold character
                // release character
                if (map1.get(ch) == 1){
                    map1.remove(ch);
                }else {
                    map1.put(ch, map1.get(ch) - 1);
                }

                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){  // not equal
                    matchCount--;
                }
                f2 = true;
            }

            if (f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(SmallestSubstringAllCharactersAnother(s1,s2));
    }
}

/*
Input:
timetopractice
toc
Output:
toprac

Input:
dbaecbbabdcaafbddca
abbcdc
Output:
cbbabdc
 */
