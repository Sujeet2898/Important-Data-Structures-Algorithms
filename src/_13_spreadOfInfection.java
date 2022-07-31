/*
Link: https://www.youtube.com/watch?v=3A1XJbRs_6A&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=14
Question: Spread Of Infection
1. You are given a graph, representing people and their connectivity.
2. You are also given a src person (who got infected) and time t.
3. You are required to find how many people will get infected in time t, if the infection spreads to neighbors of infected person in 1 unit of time.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class _13_spreadOfInfection {

    static class Edge{
        int source;
        int neighbour;

        Edge(int source, int neighbour){
            this.source = source;
            this.neighbour = neighbour;
        }
    }

    static class Pair{
        int vertex;
        int time;

        Pair(int vertex, int time){
            this.vertex = vertex;
            this.time = time;
        }
    }

    public static int spreadInfection(ArrayList<Edge>[] graph, int src, int time, int[] visited){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, 1));
        int count = 0;  // for calculating how many people are ill

        while (queue.size() > 0){

            // r m* w a*
            // 1. Remove
            Pair remove = queue.removeFirst();

            // 2. Mark Star (means visited)
            if (visited[remove.vertex] > 0){    // no work is done anymore if it is already visited i.e ill ( >0 means ill and =0 means not ill)
                continue;
            }
            visited[remove.vertex] = remove.time;  // mark visited if it is not visited

            if (remove.time > time){
                break;
            }
            count++;

            // 3. Work
            // No work

            // 4. Add Star
            for (Edge edge : graph[remove.vertex]){
                if (visited[edge.neighbour] == 0){  // not visited i.e not ill
                    queue.add(new Pair(edge.neighbour, remove.time + 1));
                }
            }
        }
        return count;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(scn.nextLine());
        int time = Integer.parseInt(scn.nextLine());
        int[] visited = new int[vtces];
        System.out.println(spreadInfection(graph, src, time, visited));
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
6
3

Output:
4

 */