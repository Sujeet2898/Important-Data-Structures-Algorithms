/*
Link: https://www.youtube.com/watch?v=iUtmQ66IC_0&t=501s
Question: Iterative Depth First Traversal
1. You are given a graph, and a source vertex.
2. You are required to do a iterative depth first traversal and print which vertex is reached via which path, starting from the source.

Note -> For output, check the sample output and question video. Iterative depth first traversal
               should mimic "Reverse preorder" i.e. nbr with highest value should be visited first and
               should be printed on the way down in recursion.
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class _17_IterativeDepthFirstTraversal {

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
        String pathSoFar;

        Pair(int vertex, String pathSoFar){
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }
    }

    public static void iterativeDepthFirstTraversal(ArrayList<Edge>[] graph, int src, int vertices){
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(src, src + ""));
        boolean[] visited = new boolean[vertices];

        while (stack.size() > 0){

            // r m* w a*
            // 1. Remove
            Pair remove = stack.pop();

            // 2. Mark Star (means visited)
            if (visited[remove.vertex] == true){    // no work is done anymore if it is already visited
                continue;
            }
            visited[remove.vertex] = true;  // mark visited if it is not visited

            // 3. Work
            System.out.println(remove.vertex + "@" + remove.pathSoFar);

            // 4. Add Star
            for (Edge edge : graph[remove.vertex]){
                if (visited[edge.neighbour] == false){
                    stack.push(new Pair(edge.neighbour, remove.pathSoFar + edge.neighbour));
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

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(scn.nextLine());
        iterativeDepthFirstTraversal(graph, src, vtces);
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
2
Output:
2@2
3@23
4@234
6@2346
5@23465
0@230
1@2301

 */