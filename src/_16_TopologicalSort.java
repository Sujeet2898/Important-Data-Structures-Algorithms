/*
Link: https://www.youtube.com/watch?v=6Vi5Td_a8B8&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=18
Question: TopologicalSort (Order Of Compilation)
1. You are given a directed acyclic graph. The vertices represent tasks and edges represent dependencies between tasks.
2. You are required to find and print the order in which tasks could be done. The task that should be
    done at last should be printed first and the task which should be done first should be printed last.
    This is called topological sort. Check out the question video for details.

Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort if
                                    for all directed edges uv, u appears before v in the graph
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class _16_TopologicalSort {

    static class Edge{
        int source;
        int neighbour;

        Edge(int source, int neighbour){
            this.source = source;
            this.neighbour = neighbour;
        }
    }

    public static void topologicalSortAlgorithm(ArrayList<Edge>[] graph, int vertices, boolean[] visited){
        Stack<Integer> stack = new Stack<>();
        for (int v = 0; v < vertices; v++){
            if (visited[v] == false){
                topologicalSort(graph, v, visited, stack);
            }
        }

        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> stack){

        visited[src] = true;
        for (Edge edge : graph[src]){
            if (visited[edge.neighbour] == false){
                topologicalSort(graph, edge.neighbour, visited, stack);
            }
        }
        stack.push(src);
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

        boolean[] visited = new boolean[vtces];
        topologicalSortAlgorithm(graph, vtces, visited);
    }
}

/*
Input:
7
7
0 1
1 2
2 3
0 3
4 5
5 6
4 6

Output:
4
5
6
0
1
2
3

 */