/*
Link: https://www.youtube.com/watch?v=CBSeilNvZHs&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=13
Question : Count Of Substrings With Exactly K Unique Characters
1. You are given a string(str) and a number K.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has exactly K unique characters.

 */

import java.util.HashMap;
import java.util.Scanner;

public class _13_CountOfSubstringsExactlyKUniqueCharacters {

    public static int CountOfSubstringsExactlyKUniqueCharacters(String str, int k){
        int ans = 0;

        if (k == 1){
            return solutionForK1(str);
        }

        HashMap<Character, Integer> mapBig = new HashMap<>();
        HashMap<Character, Integer> mapSmall = new HashMap<>();

        // Two acquiring points
        int is = -1;  // iSmall
        int ib = -1;  // iBig

        // Releasing point is same for both
        int j = -1;

        while (true){

            // for terminating, we use 3 flag
            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;

            // First Big Map will Acquire
            while (ib < str.length() - 1){
                f1 = true;
                ib++;
                char ch = str.charAt(ib);  // take character
                mapBig.put(ch, mapBig.getOrDefault(ch, 0) + 1);

                if (mapBig.size() == k + 1) {
                    removeInMap(mapBig, ch);
                    ib--;
                    break;
                }
            }

            // Second Small Map will Acquire
            while (is < ib){
                f2 = true;
                is++;
                char ch = str.charAt(is);  // take character
                mapSmall.put(ch, mapSmall.getOrDefault(ch, 0) + 1);

                if (mapSmall.size() == k) {
                    removeInMap(mapSmall, ch);
                    is--;
                    break;
                }
            }

            // Release
            while (j < is){  // j will not move beyond iSmall
                f3 = true;

                if (mapBig.size() == k && mapSmall.size() == k - 1){
                    ans += ib - is;
                }

                j++;
                char ch = str.charAt(j);
                removeInMap(mapSmall, ch);
                removeInMap(mapBig, ch);

                // Invalid case
                if (mapSmall.size() < k - 1 || mapBig.size() < k){
                    break;
                }
            }

            if (f1 == false && f2 == false && f3 == false){
                break;
            }
        }
        return ans;
    }

    private static int solutionForK1(String str) {
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true){
            // for terminating, we use 2 flag
            boolean f1 = false;
            boolean f2 = false;

            // Acquire
            while (i < str.length() - 1){
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() == 2){
                    removeInMap(map, ch);
                    i--;
                    break;
                }
            }

            // Release
            while (j < i){
                f2 = true;
                if (map.size() == 1){
                    ans += i - j;
                }
                j++;
                char ch = str.charAt(j);
                removeInMap(map, ch);

                if (map.size() == 0){
                    break;
                }
            }
            if (f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }

    public static void removeInMap(HashMap<Character, Integer> map, char ch){
        if (map.get(ch) == 1){
            map.remove(ch);
        }else {
            map.put(ch, map.get(ch) - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(CountOfSubstringsExactlyKUniqueCharacters(str,k));
    }
}

/*
Input:
aabcbcdbca
2
Output:
12
 */
