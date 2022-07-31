/*
Link: https://www.youtube.com/watch?v=Vw-sktU1zmc&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=16
Question: Prim's Algorithm (Minimum Wire Required To Connect All Pcs)
1. You are given a graph and a source vertex. The vertices represent computers and the edges represent length of LAN wire required to connect them.
2. You are required to find the minimum length of wire required to connect all PCs over a network.
     Print the output in terms of which all PCs need to be connected, and the length of wire between them.

 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _15_PrimsAlgorithm {

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

    static class Pair implements Comparable<Pair> {
        int vertex;
        int acquiringVertex;
        int weight;

        Pair(int vertex, int acquiringVertex, int weight){
            this.vertex = vertex;
            this.acquiringVertex = acquiringVertex;
            this.weight = weight;
        }

        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public static void primsAlgorithm(ArrayList<Edge>[] graph, boolean[] visited){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));  // imaginary pair

        while (pq.size() > 0){

            // r m* w a*
            // 1. Remove
            Pair remove = pq.remove();

            // 2. Mark Star (means visited)
            if (visited[remove.vertex] == true){    // no work is done anymore if it is already visited
                continue;
            }
            visited[remove.vertex] = true;  // mark visited if it is not visited

            // 3. Work
            if (remove.acquiringVertex != -1) {
                System.out.println("[" + remove.vertex + "-" + remove.acquiringVertex + "@" + remove.weight + "]");
            }

            // 4. Add Star
            for (Edge edge : graph[remove.vertex]){
                if (visited[edge.neighbour] == false){
                    pq.add(new Pair(edge.neighbour, remove.vertex, edge.weight));
                }
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
        primsAlgorithm(graph, visited);
    }
}

/*
Input:
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8

Output:
[1-0@10]
[2-1@10]
[3-2@10]
[4-3@2]
[5-4@3]
[6-5@3]

 */