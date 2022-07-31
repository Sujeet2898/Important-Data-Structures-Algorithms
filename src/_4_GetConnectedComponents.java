/*
Link: https://www.youtube.com/watch?v=8UBwFE8H4Mc&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=5
Question: Get Connected Components Of A Graph
1. You are given a graph.
2. You are required to find and print all connected components of the graph.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class _4_GetConnectedComponents {

    static class Edge{
        int source;
        int neighbour;
        int weight;

        Edge(int source, int neighbour, int weight){
            this.source = source;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    public static void getConnectedComponent(ArrayList<Edge>[] graph, int vertices){
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++){
            if (visited[i] == false){
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerate(graph, i, comp, visited);
                components.add(comp);
            }
        }
        System.out.println(components);
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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int vtces = Integer.parseInt(scn.nextLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(scn.nextLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = scn.nextLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        getConnectedComponent(graph, vtces);
    }
}

/*
Input:
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

Output:
[[0, 1], [2, 3], [4, 5, 6]]

 */