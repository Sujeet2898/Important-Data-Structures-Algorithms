import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SubStringCharacters_1 {

/*

Link: https://www.youtube.com/watch?v=e1HlptlipB0&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=8

Question 1: Smallest Substring Of A String Containing All Characters Of Another String

1. You are given two strings s1 and s2 containing lowercase english alphabets.
2. You have to find the smallest substring of s1 that contains all the characters of s2.
3. If no such substring exists, print blank string("").

 */

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

                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){   // less or equal
                    matchCount++;
                }
                f1 = true;
            }

            // collect answer and release
            while (j < i && matchCount == desireMatchCount){
                // collect ans
                String potentialAns = s1.substring(j + 1, i + 1);
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

    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(SmallestSubstringAllCharactersAnother(s1,s2));
    }

    Input:
    timetopractice
    toc
    Output:
    toprac

     */

/*

Link: https://www.youtube.com/watch?v=pbUNTDdxomI&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=9

Question 2: Smallest Substring Of A String Containing All Unique Characters Of Itself

1. You are given a string str.
2. You have to find the smallest window length that contains all the unique characters of the given string.

 */

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

    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(SmallestSubstringAllUniqueCharacters(str));
    }

    Input:
     aabcbcdbca

    Output:
    4

     */

/*

Link: https://www.youtube.com/watch?v=9Kc0eZBGL1U&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=10

Question 3: Longest Substring With Non Repeating Characters i.e unique character

1. You are given a string.
2. You have to find the length of the longest substring of the given string that contains all non-repeating characters.

 */

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

    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(LongestSubstringNonRepeatingCharacters(str));
    }

    Input:
    aabcbcdbca

    Output:
    4

     */

/*

Link: https://www.youtube.com/watch?v=Auk0E3E8G7c&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=11

Question 4: Count of Substring With Non Repeating Characters i.e unique character

1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.

 */

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

    /*
    Input:
    aabcbcdbca
    Output:
    24

     */
}
