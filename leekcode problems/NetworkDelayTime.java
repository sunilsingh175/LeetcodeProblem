import java.util.*;

public class NetworkDelayTime {

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

            if (time > dist[node]) continue;

            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int neighbor = edge[0];
                    int newTime = time + edge[1];

                    if (newTime < dist[neighbor]) {
                        dist[neighbor] = newTime;
                        pq.offer(new int[]{neighbor, newTime});
                    }
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[][] times1 = {{2,1,1},{2,3,1},{3,4,1}};
        int n1 = 4, k1 = 2;
        System.out.println(networkDelayTime(times1, n1, k1)); // Output: 2

        int[][] times2 = {{1,2,1}};
        int n2 = 2, k2 = 1;
        System.out.println(networkDelayTime(times2, n2, k2)); // Output: 1

        int[][] times3 = {{1,2,1}};
        int n3 = 2, k3 = 2;
        System.out.println(networkDelayTime(times3, n3, k3)); // Output: -1
    }
}
