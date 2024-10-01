package Chapter29;

import java.util.Arrays;

public class DjikstraAdjacencyMatrix {

    public static void dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];  // The output array. dist[i] will hold the shortest distance from src to i
        boolean[] sptSet = new boolean[V];  // sptSet[i] will be true if vertex i is included in the shortest path tree

        // Initialize all distances as INFINITE and stpSet[] as false
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(sptSet, false);

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < V; v++) {
                // Update dist[v] only if it is not in sptSet, there is an edge from u to v,
                // and total weight of path from src to v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the constructed distance array
        printSolution(dist);
    }

    // A utility function to find the vertex with minimum distance value, from
    // the set of vertices not yet included in shortest path tree
    public static int minDistance(int[] dist, boolean[] sptSet) {
        // Initialize min value
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // A utility function to print the constructed distance array
    public static void printSolution(int[] dist) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        // Adjacency matrix representation of the graph
        int[][] graph = new int[][]{
                {0, 10, 0, 0, 0, 0},
                {10, 0, 5, 0, 0, 15},
                {0, 5, 0, 20, 0, 0},
                {0, 0, 20, 0, 10, 5},
                {0, 0, 0, 10, 0, 5},
                {0, 15, 0, 5, 5, 0}
        };

        DjikstraAdjacencyMatrix.dijkstra(graph, 0);
    }
}
