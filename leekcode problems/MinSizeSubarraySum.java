class MinSizeSubarraySum {

public static void main(String[] args) {
       int target = 7;
int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target , nums));
    }
    public  static int minSubArrayLen(int target, int[] nums) {
        int minLenWindow = Integer.MAX_VALUE;
        int currentSum = 0;

        int low = 0;
        int high = 0;

        while(high<nums.length)
        {
            currentSum += nums[high];
            high++;

            while(currentSum >= target)
            {
                int currentWindowSize = high-low;
                minLenWindow = Math.min(minLenWindow, currentWindowSize);
                currentSum -= nums[low];
                low++;

            }
        }
        return minLenWindow == Integer.MAX_VALUE?0:minLenWindow;
    }
}