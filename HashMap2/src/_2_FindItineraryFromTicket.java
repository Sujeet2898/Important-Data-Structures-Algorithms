/*
Link: https://www.youtube.com/watch?v=4mi2rO4D_Xk&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=2
Question: Find Itinerary From Tickets
1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
2. You have to find the itinerary in order using the given list of tickets.

Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.
 */

import java.util.HashMap;
import java.util.Scanner;

public class _2_FindItineraryFromTicket {

    public static void reconstructItinerary(HashMap<String, String> map){
        HashMap<String, Boolean> potentialSrc = new HashMap<>();
        for (String src : map.keySet()){
            String dest = map.get(src);

            potentialSrc.put(dest, false);
            if (potentialSrc.containsKey(src) == false){
                potentialSrc.put(src, true);
            }
        }

        String src = "";
        for (String potential : potentialSrc.keySet()){
            Boolean val = potentialSrc.get(potential);
            if (val == true){
                src = potential;
                break;
            }
        }
        while (true){
            if (map.containsKey(src) == true){
                System.out.print(src + " -> ");
                src = map.get(src);  // updating the src
            }else {
                System.out.print(src + ".");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int noofpairs_src_des = scn.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < noofpairs_src_des; i++) {
            String s1 = scn.next();
            String s2 = scn.next();
            map.put(s1, s2);
        }
        reconstructItinerary(map);
    }
}

/*
Input:
4
Chennai Banglore
Bombay Delhi
Goa Chennai
Delhi Goa

Output:
Bombay -> Delhi -> Goa -> Chennai -> Banglore.

 */