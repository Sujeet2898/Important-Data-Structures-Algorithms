/*
Question : Longest Substring With Exactly K Unique Characters
Link: https://www.youtube.com/watch?v=SIh3RfFPQwU&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=12
Problem Statement: Longest Substring With Exactly K Unique Characters
1. You are given a string(str) and a number K.
2. You have to find length of the longest substring that has exactly k unique characters.
3. If no such substring exists, print "-1".
 */

import java.util.HashMap;
import java.util.Scanner;

public class _12_LongestSubstringExactlyKUniqueCharacters {

    public static int getLengthOfLongestSubstringExactlyKUniqueCharacters(String str, int k){
        int ans = 0;
        int i = -1;
        int j = -1;

        HashMap<Character, Integer> map = new HashMap<>();
        while (true){
            boolean f1 = false;
            boolean f2 = false;

            // Acquire
            while (i < str.length() - 1){
                f1 = true;
                i++;
                char ch = str.charAt(i);  // take character
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() < k) {
                    continue;
                }else if (map.size() == k){
                    int length = i - j;
                    if (length > ans){
                        ans = length;
                    }
                }else {
                    break;
                }
            }

            // Release
            while (j < i){
                f2 = true;
                j++;
                char ch = str.charAt(j);
                if (map.get(ch) == 1){
                    map.remove(ch);
                }else {
                    map.put(ch, map.get(ch) - 1);
                }

                if (map.size() > k){
                    continue;
                }else if (map.size() == k){
                    int length = i - j;
                    if (length > ans){
                        ans = length;
                    }
                    break;
                }
            }

            if (f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(getLengthOfLongestSubstringExactlyKUniqueCharacters(str,k));
    }
}

/*
Input:
aabcbcdbca
2
Output:
4
 */