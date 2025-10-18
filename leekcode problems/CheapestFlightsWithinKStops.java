import java.util.*;

public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = dist.clone();
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {
            {0,1,5},
            {1,2,5},
            {0,3,2},
            {3,1,2},
            {1,4,1},
            {4,2,1}
        };
        int src = 0, dst = 2, k = 2;
        System.out.println(findCheapestPrice(n, flights, src, dst, k)); 
    }
}
