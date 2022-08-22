/*
Link:
Question: Number Of Employees Under Every Manager
1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
2. An employee directly reports to only one manager.
3. All managers are employees but the reverse is not true.
4. An employee reporting to himself is the CEO of the company.
5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _1_NumberOfEmployeesUnderEveryManager {

    public static void findCount(HashMap<String, String> map){
        HashMap<String, HashSet<String>> tree = new HashMap<>();
        // key of hashMap is Manager and in front of manager, in the hashSet is the Employee.

        String ceo = ""; // root

        for (String employee : map.keySet()){
            String manager = map.get(employee);

            // finding root
            if (manager.equals(employee)){
                ceo = manager;
            }else {
                if (tree.containsKey(manager)){
                    HashSet<String> employees  = tree.get(manager);
                    employees.add(employee);
                }else {
                    HashSet<String> employees  = new HashSet<>();
                    employees.add(employee);
                    tree.put(manager, employees);
                }
            }
        }
        HashMap<String, Integer> result = new HashMap<>();
        getSize(tree, ceo, result);

        for (String employee : result.keySet()){
            System.out.println(employee + " " + result.get(employee));
        }
    }

    private static int getSize(HashMap<String,HashSet<String>> tree, String manager, HashMap<String,Integer> result) {
        //BaseCase
        if (tree.containsKey(manager) == false){
            result.put(manager, 0);
            return 1;
        }

        int size = 0;
        for (String employee : tree.get(manager)) {
            int childSize = getSize(tree, employee, result);
            size += childSize;
        }
        result.put(manager, size);
        return size + 1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(scn.next(), scn.next());
        }
        findCount(map);
    }
}

/*
Input:
6
A C
B C
C F
D E
E F
F F
Output:
A 0
B 0
C 2
D 0
E 1
F 5

 */