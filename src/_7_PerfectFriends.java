/*
Link: https://www.youtube.com/watch?v=_q4hA01ZcVQ&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=8
Question: Perfect Friends
1. You are given a number n (representing the number of students). Each student will have an id from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are from different clubs.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class _7_PerfectFriends {

    static class Edge{
        int source;
        int neighbour;

        Edge(int source, int neighbour){
            this.source = source;
            this.neighbour = neighbour;
        }
    }

    public static void perfectFriends(ArrayList<Edge>[] graph, int vertices){
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++){
            if (visited[i] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerate(graph, i, comp, visited);
                components.add(comp);
            }
        }
        int pairs = 0;
        for (int i = 0; i < components.size(); i++){
            for (int j = i + 1; j < components.size(); j++){
                int count = components.get(i).size() * components.get(j).size();
                pairs += count;
            }
        }
        System.out.println(pairs);
    }

    public static void drawTreeAndGenerate(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited){
        visited[src] = true;
        comp.add(src);
        // Graph is an array of arraylists. So, graph of source gives arraylists. Loop over arraylists give Edge.
        for (Edge edge : graph[src]){
            if (visited[edge.neighbour] == false) {
                drawTreeAndGenerate(graph, edge.neighbour, comp, visited);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int vtces = Integer.parseInt(scn.nextLine());

        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int k = Integer.parseInt(scn.nextLine());
        for (int i = 0; i < k; i++) {
            String[] parts = scn.nextLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }
        perfectFriends(graph, vtces);
    }
}

/*
Input:
7
5
0 1
2 3
4 5
5 6
4 6

Output:
16

 */