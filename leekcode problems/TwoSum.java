import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[]args)
    {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums,9)));

    }
    public static int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> hm=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            int req_nums=target-nums[i];
            if(hm.containsKey(req_nums))
            {
                int[] arr= {hm.get(req_nums),i};
                return arr;
            }
            hm.put(nums[i],i);
        }
        return null;
    }
}