import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramsInString_3 {

/*

Question 1 : Find All Anagrams In A String

Link: https://www.youtube.com/watch?v=slDyFUnGtoU&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=19

Problem Statement: Find All Anagrams In A String
1. You are given two strings s1 and s2.
2. You have to find the count of s2's anagrams that are present in s1.
3. Also, you have to print the start indices of such anagrams in s1.
   Both s1 ad s2 consist of lowercase English letters only.
Note:
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase. We can generalise this in string processing by saying that an anagram of a string is another string with the same quantity of each character in it, in any order.

Source > Pattern
 */

    public static boolean compare(HashMap<Character, Integer> patternMap, HashMap<Character, Integer> sourceMap){
        for (char sourceCh : sourceMap.keySet()){
            if (patternMap.getOrDefault(sourceCh, 0) != sourceMap.get(sourceCh)){
                return false;
            }
        }
        return true;
    }

    public static void findAnagrams(String source, String pattern) {
        HashMap<Character, Integer> sourceMap = new HashMap<>();
        HashMap<Character, Integer> patternMap = new HashMap<>();

        // frequency map for pattern
        for (int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        // frequency map for source having size equal to pattern
        for (int i = 0; i < pattern.length(); i++){
            char ch = source.charAt(i);
            sourceMap.put(ch, sourceMap.getOrDefault(ch, 0) + 1);
        }

        int i = pattern.length();  // needed for acquiring
        // i - pattern.length() is needed for releasing
        int count = 0;
        String ans = "";

        // Work is done till pattern reaches end of the source while maintaining patternSize = sourceSize
        while (i < source.length()){
            if (compare(patternMap, sourceMap) == true){
                count++;
                ans += i - pattern.length() + " ";
            }

            // Acquire 1
            char chAcquire = source.charAt(i);
            sourceMap.put(chAcquire, sourceMap.getOrDefault(chAcquire, 0) + 1);
            // Release 1
            char chRelease = source.charAt(i - pattern.length());
            if (sourceMap.get(chRelease) == 1){
                sourceMap.remove(chRelease);
            }else {
                sourceMap.put(chRelease, sourceMap.get(chRelease) - 1);
            }

            i++;
        }
        // Comparison for rest character in source
        if (compare(patternMap, sourceMap) == true){
            count++;
            ans += i - pattern.length() + " ";
        }
        System.out.println(count);
        System.out.println(ans);
    }

    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String source = scn.next();
        String pattern = scn.next();
        findAnagrams(source, pattern);
    }

     Input:
     cbaebabacd
     abc
     Output:
     2
     0 6

     */

/*

Question 2: K Anagrams

Link: https://www.youtube.com/watch?v=VyQbl13RGiw&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=20

Problem Statement: Check if two Strings are K Anagrams
1. You are given two strings s1, s2, and a number K.
2. You have to find if two strings are K-anagrams of each other or not.
3. Two strings are called K-anagrams if
   -> Both s1 and s2 have the same number of characters.
   -> After changing K characters in any string, s1 and s2 become anagram of each other.
Note -> Both s1 ad s2 consist of lowercase English letters only.

 */

    public static boolean areKAnagrams(String str1, String str2, int k){

        if (str1.length() != str2.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // frequency map for str1
        for (int i = 0; i < str1.length(); i++){
            char ch = str1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // frequency map for str2 used in same map
        for (int i = 0; i < str2.length(); i++){
            char ch = str2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0){
                map.put(ch, map.get(ch) - 1);
            }
        }

        int count = 0;
        for (char ch : map.keySet()){
            count += map.get(ch);
        }

        if (count > k){
            return false;
        }else {
            return true;
        }
    }

    /**

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str1 = scn.next();
        String str2 = scn.next();
        int k = scn.nextInt();
        System.out.println(areKAnagrams(str1, str2, k));
    }
     Input:
     fodr
     gork
     2
     Output:
     true

     */

/*

Question 3: Find Anagram Mappings

Link: https://www.youtube.com/watch?v=jBkTf43X198&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=21

Problem Statement: Find Anagrams Mappings using Hashmaps
1. You are given two integer arrays(A and B), where B is an anagram of A.
2. B is an anagram of A means B is made by randomizing the order of the elements in A.
3. For every element in A, you have to print the index of that element in B.
Note -> Both arrays(A and B) are of the same length.

 */

    public static class Pair{
        int idx;
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static int[] anagramMappings(int[] arr1, int[] arr2){
        HashMap<Integer, Pair> map = new HashMap<>();

        // Firstly process arr2
        for (int i = 0; i < arr2.length; i++){

            // map -> pair
            if (map.containsKey(arr2[i])){
                // don't make pair, instead get from map & add into pair
                Pair p = map.get(arr2[i]);
                p.list.add(i); // Making pair ready

                // pair -> map
            }else {
                Pair p = new Pair(); // with idx & empty arraylist
                p.list.add(i); // Making pair ready
                map.put(arr2[i], p); // adding pair in front of arr2 in map
            }
        }

        // Secondly process arr1
        int[] ans = new int[arr1.length];
        // Values are found always as it is anagram
        for (int i = 0; i < arr1.length; i++){
            Pair p = map.get(arr1[i]);
            // adding indexValue of pairArraylist into ans
            ans[i] = p.list.get(p.idx);
            p.idx++; // increasing idx for getting other same value
        }
        return ans;
    }

    /**

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        for (int j = 0; j < b.length; j++) {
            b[j] = s.nextInt();
        }
        int[] res = anagramMappings(a, b);
        for (int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }
    }

     Input:
     6
     1 2 3 4 5 2
     4 3 2 1 5 2
     Output:
     3 2 1 0 4 5

     */

/*

Link: https://www.youtube.com/watch?v=m7kLirMTp04&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=22

Question 4: Valid Anagram

1. You are given two strings s1 and s2.
2. You have to determine if s2 is an anagram of s1.

 */

    public static boolean ValidAnagram(String s1, String s2){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);

            if (map.containsKey(ch) == false){
                return false;
            }else if (map.get(ch) == 1){
                map.remove(ch);
            }else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        return map.size() == 0;
    }

    /**

     public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(ValidAnagram(s1,s2));
    }

     Input:
     pepcoding
     codingpep

     Output:
     true

     */

/*

Link: https://www.youtube.com/watch?v=NNBQik4phMI&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=23

Question 5: Group Anagrams

1. You are given an array of strings.
2. You have to group anagrams together.
Note -> Every string consists of lower-case English letters only.

 */

    public static ArrayList<ArrayList<String>> groupAnagrams(String[] bigString) {

        // Make a Hashmap of FrequencyMap of Character & Integer as key and Arraylist of String as value
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bigMap = new HashMap<>();

        // Make freqMap of each string of bigString
        for (String individualString : bigString){
            HashMap<Character, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < individualString.length(); i++){
                char ch = individualString.charAt(i);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }

            // Make new arraylist of String for eachFirst freqMap of bigMap
            if (bigMap.containsKey(freqMap) == false){
                ArrayList<String> list = new ArrayList<>();
                list.add(individualString);
                bigMap.put(freqMap, list);   // putting into bigMap is compulsory as we have created new arraylist

            }else {
                // if arraylist is already there
                ArrayList<String> list = bigMap.get(freqMap);
                list.add(individualString);
                // putting into bigMap is not compulsory as arraylist is already there
            }
        }

        // Note: Use .keySet() for taking all keys from hashMap and use .values for taking all values from hashMap

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        // Getting values from bigMap
        for (ArrayList<String> val : bigMap.values()){
            result.add(val);
        }
        return result;
    }

    /**

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        ArrayList<ArrayList<String>> output = groupAnagrams(arr);
        for (ArrayList<String> lst : output) {
            System.out.println(lst);
        }
    }

     Input:
     5
     pepcoding codingpep pepper rapper repepp

     Output:
     [rapper]
     [pepcoding, codingpep]
     [pepper, repepp]

     */

/*

Link: https://www.youtube.com/watch?v=uEXJSRLqoKY&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=24

Question 6: Group Shifted String

1. You are given an array of strings.
2. You have to group the given strings in such a way that all strings in a group are shifted versions of each other.
3. Two strings s1 and s2 are shifted if -
   -> Length of both the strings is the same.
   -> The difference between ASCII values of every character of s1 and s2 is constant.
Note -> Every string consists of lower-case English letters only.

 */

    public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] bigString) {
        // Creating hashMap of String as key and Arraylist of String as value
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : bigString){
            // bringing key of each string of bigString
            String key = getKey(str);

            // key is not there
            if (map.containsKey(key) == false){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);  // putting into map is compulsory as we have created new arraylist

                // key is there
            }else {
                ArrayList<String> list = map.get(key);
                list.add(str);
                // putting into map is not compulsory as arraylist is already there
            }
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        // Getting values from map
        for (ArrayList<String> val : map.values()){
            result.add(val);
        }
        return result;
    }

    // Making key of hashMap from String
    public static String getKey(String str){
        String key = "";

        for (int i = 1; i < str.length(); i++){
            char current = str.charAt(i);
            char previous = str.charAt(i - 1);
            int diff = current - previous;

            if (diff < 0){
                diff += 26;
            }
            key += diff + "#";
        }
        key += ".";  // not compulsory

        return key;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
        for (ArrayList<String> lst : shiftedGroup) {
            System.out.println(lst);
        }
    }
}

/*
Input:
9
acd dfg wyz yab mop bdfh a x moqs

Output:
[bdfh, moqs]
[acd, dfg, wyz, yab, mop]
[a, x]

 */