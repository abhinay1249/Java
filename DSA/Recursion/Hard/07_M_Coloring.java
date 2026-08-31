// Problem Statement: Given an undirected graph and a number m, determine if the graph can be colored with at most m colors
// such that no two adjacent vertices of the graph are colored with the same color.

// Example 1:

// Input: N = 4, M = 3, E = 5  
// Edges[] = { (0, 1), (1, 2), (2, 3), (3, 0), (0, 2) }  
// Output: 1  
// Explanation: It is possible to color the given graph using 3 colors, so the answer is 1 (possible).

// Example 2:

// Input: N = 3, M = 2, E = 3  
// Edges[] = { (0, 1), (1, 2), (0, 2) }  
// Output: 0  
// Explanation: It is not possible to color the graph using 2 colors as it forms a triangle, which requires at least 3 colors.
// Hence, the answer is 0 (not possible).

import java.util.ArrayList;
import java.util.List;

class Main{

    // ================================== Only Approach ===========================================

        private static boolean isPossible(int node, int col, List<List<Integer>> graph, int[] color){

            for(int neighbour : graph.get(node)){
                if(color[neighbour] == col){
                    return false;
                }
            }

            return true;

        }

        public static boolean coloring(int node, int n, int m, List<List<Integer>> graph, int[] color){

            if(node == n){
                return true;
            }

            for(int col = 1 ; col <= m ; col++){
                if(isPossible(node, col, graph, color)){
                    color[node] = col;
                    if(coloring(node+1, n, m, graph, color)){
                        return true;
                    }                  
                    color[node] = 0;
                }
            }

            if(color[graph.size()-1] == 1){
                return true;
            }

            return false;
        }

        public static boolean edgesColoring(int n, int m, int[][] edges){

            List<List<Integer>> graph = new ArrayList<>();

            int[] color = new int[n];

            int node = 0;

            for(int index = 0 ; index < n ; index++){
                graph.add(new ArrayList<>());
            }

            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            // graph.get(0).add(1);
            // graph.get(1).add(0);

            // graph.get(1).add(2);
            // graph.get(2).add(1);

            // graph.get(2).add(3);
            // graph.get(3).add(2);

            // graph.get(3).add(0);
            // graph.get(0).add(3);

            // graph.get(0).add(2);
            // graph.get(2).add(0);


            return coloring(node, n, m, graph, color);

        }
    
    public static void main(String[] args) {
        
        int n = 4;

        int m = 2;

        int[][] edges = {{0,1}, {1,2},{2,3},{3,0},{0,2}};
        
        boolean result = edgesColoring(n, m, edges);

        System.out.println(result);

    }
}