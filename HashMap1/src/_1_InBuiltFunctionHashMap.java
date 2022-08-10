
// Link: https://www.youtube.com/watch?v=ukTRZD-WJH4&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=1

// Time Complexity: O(1) for all inbuilt function

import java.util.HashMap;
import java.util.Set;

public class _1_InBuiltFunctionHashMap {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 135);
        map.put("China", 200);
        map.put("Pak", 30);
        map.put("US", 20);
        map.put("UK", 10);

        System.out.println(map);   // {China=200, UK=10, Pak=30, US=20, India=135}    Demerit: Order is changed

        map.put("Nigeria", 5);
        map.put("US", 25);

        System.out.println(map);  // {China=200, UK=10, Pak=30, Nigeria=5, US=25, India=135}

        System.out.println(map.get("India"));  // 135
        System.out.println(map.get("Utopia"));  // null

        System.out.println(map.containsKey("India"));  // true
        System.out.println(map.containsKey("Utopia"));  // false

        Set<String> keys = map.keySet();
        System.out.println(keys);    // [China, UK, Pak, Nigeria, US, India]

        for (String key : map.keySet()){
            Integer val = map.get(key);              // Demerit: Order is changed
            System.out.println(key + " " + val);     // China 200
                                                     // UK 10
                                                     // Pak 30
                                                     // Nigeria 5
                                                     // US 25
                                                     // India 135
        }
    }
}
