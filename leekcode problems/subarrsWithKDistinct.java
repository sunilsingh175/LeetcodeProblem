import java.util.*;
class subarrsWithKDistinct {

public static void main(String[] args) {
       int k = 2;
int[] nums = {1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(nums , k));
    }
    public  static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private static int atMostK(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n + 1];  
        int left = 0, count = 0, distinct = 0;

        for (int right = 0; right < n; right++) {
            if (freq[nums[right]] == 0) distinct++;
            freq[nums[right]]++;

            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) distinct--;
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }
}
