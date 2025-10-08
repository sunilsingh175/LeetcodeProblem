import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();


        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else if (start.equals(end)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, start, end, 1.0, visited);
            }
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String curr, String target, double acc, Set<String> visited) {
        visited.add(curr);
        if (curr.equals(target)) return acc;

        for (Map.Entry<String, Double> neighbor : graph.get(curr).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double res = dfs(graph, neighbor.getKey(), target, acc * neighbor.getValue(), visited);
                if (res != -1.0) return res;
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision sol = new EvaluateDivision();

        List<List<String>> equations = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};

        List<List<String>> queries = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "e"),
            Arrays.asList("a", "a"),
            Arrays.asList("x", "x")
        );

        double[] result = sol.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
      
    }
}
