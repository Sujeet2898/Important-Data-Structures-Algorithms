/*
Link: https://www.youtube.com/watch?v=mlnnJd9k7oE&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=2&t=472s
Question: Has Path?
1. You are given a graph, a src vertex and a destination vertex.
2. You are required to find if a path exists between src and dest. If it does, print true otherwise print false.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class _1_HasPath {

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

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if (src == dest){
            return true;
        }

        visited[src] = true;
        // Graph is an array of arraylists. So, graph of source gives arraylists. Loop over arraylists give Edge.
        for (Edge edge : graph[src]){
            if (visited[edge.neighbour] == false) {
                boolean hasNeighbourPath = hasPath(graph, edge.neighbour, dest, visited);
                if (hasNeighbourPath == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
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

        int src = Integer.parseInt(scn.nextLine());
        int dest = Integer.parseInt(scn.nextLine());

        boolean[] visited = new boolean[vtces];
        boolean path = hasPath(graph, src, dest, visited);
        System.out.println(path);
    }
}

/*
Input:
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6

Output:
true

 */