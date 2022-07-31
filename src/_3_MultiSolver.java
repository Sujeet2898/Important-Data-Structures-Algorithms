/*
Link: https://www.youtube.com/watch?v=PSy0yJQx050&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=4
Question: Multisolver - Smallest, Longest, Ceil, Floor, Kthlargest Path
1. You are given a graph, a src vertex and a destination vertex.
2. You are give a number named "criteria" and a number "k".
3. You are required to find and print the values of
3.1 Smallest path and it's weight separated by an "@"
3.2 Largest path and it's weight separated by an "@"
3.3 Just Larger path (than criteria in terms of weight) and it's weight separated by an "@"
3.4 Just smaller path (than criteria in terms of weight) and it's weight separated by an "@"
3.5 Kth largest path and it's weight separated by an "@"
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _3_MultiSolver {

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

    static class Pair implements Comparable<Pair>{
        int weightSoFar;
        String pathSoFar;

        Pair(int weightSoFar, String pathSoFar){
            this.weightSoFar = weightSoFar;
            this.pathSoFar = pathSoFar;
        }

        public int compareTo(Pair o) {
            return this.weightSoFar - o.weightSoFar;
        }
    }

    static String smallestPath;
    static Integer smallestPathWeight = Integer.MAX_VALUE;
    static String largestPath;
    static Integer largestPathWeight = Integer.MIN_VALUE;
    static String ceilPath;
    static Integer ceilPathWeight = Integer.MAX_VALUE;
    static String floorPath;
    static Integer floorPathWeight = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String pathSoFar, int weightSoFar){

        if (src == dest){

            if (weightSoFar < smallestPathWeight){
                smallestPathWeight = weightSoFar;
                smallestPath = pathSoFar;
            }

            if (weightSoFar > largestPathWeight){
                largestPathWeight = weightSoFar;
                largestPath = pathSoFar;
            }

            if (weightSoFar < ceilPathWeight && weightSoFar > criteria){
                ceilPathWeight = weightSoFar;
                ceilPath = pathSoFar;
            }

            if (weightSoFar > floorPathWeight && weightSoFar < criteria){
                floorPathWeight = weightSoFar;
                floorPath = pathSoFar;
            }

            if (pq.size() < k){
                pq.add(new Pair(weightSoFar, pathSoFar));
            }else {
                if (weightSoFar > pq.peek().weightSoFar){
                    pq.remove();
                    pq.add(new Pair(weightSoFar, pathSoFar));
                }
            }

            return;
        }

        visited[src] = true;
        // Graph is an array of arraylists. So, graph of source gives arraylists. Loop over arraylists give Edge.
        for (Edge edge : graph[src]){
            if (visited[edge.neighbour] == false) {
                multiSolver(graph, edge.neighbour, dest, visited, criteria, k,pathSoFar + edge.neighbour, weightSoFar + edge.weight);
            }
        }
        visited[src] = false;
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

        int criteria = Integer.parseInt(scn.nextLine());
        int k = Integer.parseInt(scn.nextLine());

        boolean[] visited = new boolean[vtces];
        multiSolver(graph, src, dest, visited, criteria, k, src + "", 0);

        System.out.println("Smallest Path = " + smallestPath + "@" + smallestPathWeight);
        System.out.println("Largest Path = " + largestPath + "@" + largestPathWeight);
        System.out.println("Just Larger Path than " + criteria + " = " + ceilPath + "@" + ceilPathWeight);
        System.out.println("Just Smaller Path than " + criteria + " = " + floorPath + "@" + floorPathWeight);
        System.out.println(k + "th largest path = " + pq.peek().pathSoFar + "@" + pq.peek().weightSoFar);
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
6
30
4

Output:
Smallest Path = 01256@28
Largest Path = 032546@66
Just Larger Path than 30 = 012546@36
Just Smaller Path than 30 = 01256@28
4th largest path = 03456@48

 */