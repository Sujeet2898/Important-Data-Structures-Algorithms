/*
Link: https://www.youtube.com/watch?v=sD0lLYlGCJE&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=15
Question: Dijkstra Algorithm (The Shortest Path In Weights)
1. You are given a graph and a source vertex. The vertices represent cities and the edges represent distance in kms.
2. You are required to find the shortest path to each city (in terms of kms) from the source city along with the total distance on path from source to destinations.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _14_DijkstraAlgorithm {

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
        String pathSoFar;
        int weightSoFar;

        Pair(int vertex, String pathSoFar, int weightSoFar){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
            this.weightSoFar = weightSoFar;
        }

        public int compareTo(Pair o) {
            return this.weightSoFar - o.weightSoFar;
        }
    }

    public static void dijkstraAlgorithm(ArrayList<Edge>[] graph, int src, boolean[] visited){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, src + "", 0));

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
            System.out.println(remove.vertex + " via " + remove.pathSoFar + " @ " + remove.weightSoFar);

            // 4. Add Star
            for (Edge edge : graph[remove.vertex]){
                if (visited[edge.neighbour] == false){
                    pq.add(new Pair(edge.neighbour, remove.pathSoFar + edge.neighbour, remove.weightSoFar + edge.weight));
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

        int src = Integer.parseInt(scn.nextLine());
        boolean[] visited = new boolean[vtces];
        dijkstraAlgorithm(graph, src, visited);
    }
}

/*
Input:
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0

Output:
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
5 via 0125 @ 25
4 via 01254 @ 28
6 via 01256 @ 28
3 via 012543 @ 30

 */