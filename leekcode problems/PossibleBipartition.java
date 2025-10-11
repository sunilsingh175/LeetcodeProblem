import java.util.*;

public class PossibleBipartition {

    // Function to check if bipartition is possible
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] d : dislikes) {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }

        int[] color = new int[n + 1]; 

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(graph, color, i, 1)) {
                return false;
            }
        }
        return true;
    }

    // DFS to assign colors
    private static boolean dfs(List<List<Integer>> graph, int[] color, int node, int c) {
        color[node] = c;
        for (int nei : graph.get(node)) {
            if (color[nei] == c) return false;
            if (color[nei] == 0 && !dfs(graph, color, nei, -c)) return false;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        int n1 = 4;
        int[][] dislikes1 = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println("Example 1 Output: " + possibleBipartition(n1, dislikes1));
        // Expected: true

        int n2 = 3;
        int[][] dislikes2 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println("Example 2 Output: " + possibleBipartition(n2, dislikes2));
        // Expected: false
    }
}
