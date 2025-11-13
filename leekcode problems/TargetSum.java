import java.util.*;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) return 0;
        int s = (sum + target) / 2;
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = s; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[s];
    }

    public static void main(String[] args) {
        TargetSum sol = new TargetSum();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(sol.findTargetSumWays(nums, target)); // Output: 5
    }
}
