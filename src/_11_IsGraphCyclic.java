/*
Link: https://www.youtube.com/watch?v=qbQq-k75bcY&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=12
Question: Is Graph Cyclic
1. You are given a graph.
2. You are required to find and print if the graph is cyclic.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class _11_IsGraphCyclic {

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

    static class Pair{
        int vertex;
        String pathSoFar;

        Pair(int vertex, String pathSoFar){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }
    }

    public static boolean isGraphCyclic(ArrayList<Edge>[] graph, int vertices){
        boolean[] visited = new boolean[vertices];

        for (int v = 0; v < vertices; v++){

            if (visited[v] == false){
                boolean cycle = isCyclic(graph, v, visited);

                if (cycle){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));

        while (queue.size() > 0){

            // r m* w a*
            // 1. Remove
            Pair remove = queue.removeFirst();

            // 2. Mark Star (means visited)
            if (visited[remove.vertex] == true){    // no work is done anymore if it is already visited
                return true;
            }
            visited[remove.vertex] = true;  // mark visited if it is not visited

            // 3. Work
            // No work

            // 4. Add Star
            for (Edge edge : graph[remove.vertex]){
                if (visited[edge.neighbour] == false){
                    queue.add(new Pair(edge.neighbour, remove.pathSoFar + edge.neighbour));
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

        boolean[] visited = new boolean[vtces];
        System.out.println(isGraphCyclic(graph, vtces));

    }
}

/*
Input:
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10

Output:
false

 */
