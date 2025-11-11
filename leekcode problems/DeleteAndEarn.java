import java.util.*;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        int[] points = new int[max + 1];
        for (int num : nums) points[num] += num;
        int prev = 0, curr = 0;
        for (int i = 0; i <= max; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + points[i]);
            prev = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        DeleteAndEarn sol = new DeleteAndEarn();
        int[] nums = {2, 2, 3, 3, 3, 4};
        System.out.println(sol.deleteAndEarn(nums)); // Output: 9
    }
}
