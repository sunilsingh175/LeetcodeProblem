import java.util.Arrays;
class ThreeSumClosest {

 public static void main(String[] args)
{
  int [] nums = {-4,-1,0,3,10};
int target = 1;
     System.out.println((threeSumClosest(nums , target)));

}
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] +nums[2];

        int min = Integer.MAX_VALUE;

        for(int i = 0; i<nums.length-2; i++)
        {
            int left = i+1;
            int right = nums.length-1;

            while(left<right)
            {
                int sum = nums[i] + nums[left] +nums[right];

                if(sum==target)
                {
                return target;
                }
                if(sum<target)
                {
                left++;
                }
                else
                {
                    right--;
                }
                int Target = Math.abs(sum-target);
                if(Target < min)
                {
                    result =sum;
                    min = Target;
                }
            }
        }
        return result;
    }
}