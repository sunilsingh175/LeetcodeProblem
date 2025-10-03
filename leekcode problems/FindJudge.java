public class FindJudge {

    public static int findJudge(int n, int[][] trust) {
        int[] trustBalance = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            trustBalance[a]--;
            trustBalance[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustBalance[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n1 = 2;
        int[][] trust1 = { {1, 2} };
        int result1 = findJudge(n1, trust1);
        System.out.println("Example 1 Output: " + result1);

        int n2 = 3;
        int[][] trust2 = { {1, 3}, {2, 3} };
        int result2 = findJudge(n2, trust2);
        System.out.println("Example 2 Output: " + result2);
    }
}
