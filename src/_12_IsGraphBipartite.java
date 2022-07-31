/*
Link: https://www.youtube.com/watch?v=ZBhZ1DXGrhA&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=13
Question: Is Graph Bipartite
1. You are given a graph.
2. You are required to find and print if the graph is bipartite

Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually exclusive and exhaustive vertices such that all edges are across sets.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _12_IsGraphBipartite {

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
        int level;

        Pair(int vertex, String pathSoFar, int level){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
            this.level = level;
        }
    }

    public static boolean isGraphBipartite(ArrayList<Edge>[] graph, int vertices){
        int[] visited = new int[vertices];  // for writing level
        Arrays.fill(visited, -1);

        for (int v = 0; v < vertices; v++){

            if (visited[v] == -1){   // not visited
                boolean isComponentBipartite = checkComponentForBipartiteness(graph, v, visited);

                if (isComponentBipartite == false){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkComponentForBipartiteness(ArrayList<Edge>[] graph, int src, int[] visited){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + "", 0));

        while (queue.size() > 0){

            // r m* w a*
            // 1. Remove
            Pair remove = queue.removeFirst();

            // 2. Mark Star (means visited)
            if (visited[remove.vertex] != -1){    // no work is done anymore if it is already visited

                if (visited[remove.vertex] != remove.level){  // odd cycle is not bipartite
                    return false;
                }
            }else {
                visited[remove.vertex] = remove.level;  // mark visited if it is not visited
            }
            // 3. Work
            // No work

            // 4. Add Star
            for (Edge edge : graph[remove.vertex]){
                if (visited[edge.neighbour] == -1){  // not visited
                    queue.add(new Pair(edge.neighbour, remove.pathSoFar + edge.neighbour, remove.level + 1));
                }
            }
        }
        return true;
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
        System.out.println(isGraphBipartite(graph, vtces));
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

Output:
false

Input:
4
4
0 1 10
1 2 10
2 3 10
0 3 10

Output:
true

 */