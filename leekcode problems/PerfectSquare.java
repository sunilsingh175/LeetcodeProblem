import java.util.*;
public class PerfectSquare {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = Integer.MAX_VALUE;
        
        for (int i = 1; i * i <= n; i++) {
            int sq = i * i;
            for (int j = sq; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - sq] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquare sol = new PerfectSquare();
        System.out.println(sol.numSquares(12)); // 3
        System.out.println(sol.numSquares(13)); // 2
    }
}
