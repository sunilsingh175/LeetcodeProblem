import java.util.*;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = reconstructQueue(people);
        for (int[] p : result) {
            System.out.print(Arrays.toString(p) + " ");
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][]);
    }
}
