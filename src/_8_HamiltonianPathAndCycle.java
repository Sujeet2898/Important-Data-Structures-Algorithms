/*
Link: https://www.youtube.com/watch?v=nUgp0RG57wQ&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=9
Question: Hamiltonian Path And Cycle
1. You are given a graph and a src vertex.
2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."

Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
Note -> Print in lexicographically increasing order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class _8_HamiltonianPathAndCycle {

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

    public static void hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String pathSoFar, int originalSrc) {

        // BaseCase
        // Visited: all previous visit excluding present visit
        // PathSoFar: all previous visit including present visit
        if (visited.size() == graph.length - 1){
            System.out.print(pathSoFar);

            boolean closingEdgeFound = false;
            for (Edge edge : graph[src]){
                if (edge.neighbour == originalSrc){
                    closingEdgeFound = true;
                    break;
                }
            }
            if (closingEdgeFound == true){
                System.out.println("*");      // cycle
            }else {
                System.out.println(".");      // path
            }

            return;
        }

        visited.add(src);  // visit source

        // Graph is an array of arraylists. So, graph of source gives arraylists. Loop over arraylists give Edge.
        for (Edge edge : graph[src]){
            if (visited.contains(edge.neighbour) == false) {
                hamiltonian(graph, edge.neighbour, visited, pathSoFar + edge.neighbour, originalSrc);
            }
        }
        visited.remove(src);
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

        HashSet<Integer> visited = new HashSet<>();
        hamiltonian(graph, src, visited, src + "", src);

    }
}

/*
Input:
7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0

Output:
0123456.
0123465.
0125643*
0346521*

 */