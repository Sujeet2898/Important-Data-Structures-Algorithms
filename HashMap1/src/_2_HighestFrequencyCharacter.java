/*
Link: https://www.youtube.com/watch?v=ea8L1x_JSvM&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=3
Question: Highest Frequency Character
1. You are given a string str.
2. You are required to find the character with maximum frequency.

 */

import java.util.HashMap;
import java.util.Scanner;

public class _2_HighestFrequencyCharacter {

    public static void highestFrequencyCharacter(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if (map.containsKey(ch)){
                int oldFrequency = map.get(ch);
                int newFrequency = oldFrequency + 1;
                map.put(ch, newFrequency);
            }else {
                map.put(ch, 1);
            }
        }

        char maxFrequencyCharacter = str.charAt(0);
        for (Character key : map.keySet()){
            if (map.get(key) > map.get(maxFrequencyCharacter)){
                maxFrequencyCharacter = key;
            }
        }
        System.out.println(maxFrequencyCharacter);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        highestFrequencyCharacter(str);
    }
}


/*
Input:
zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
Output:
q
 */