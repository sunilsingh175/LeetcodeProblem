import java.util.*;

public class KthSmallestElementSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) pq.offer(new int[]{matrix[i][0], i, 0});

        int count = 0, res = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            res = curr[0];
            int r = curr[1], c = curr[2];
            count++;
            if (count == k) break;
            if (c + 1 < n) pq.offer(new int[]{matrix[r][c + 1], r, c + 1});
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,5,9},
            {10,11,13},
            {12,13,15}
        };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }
}
