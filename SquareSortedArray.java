import java.util.Arrays;

class SquareSortedArray {

      public static void main(String[] args)
{
  int [] nums = {-4,-1,0,3,10};
     System.out.println(Arrays.toString(sortedSquares(nums)));

}
    public  static int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
     int result[] = new int[nums.length];
        for(int i = 0; i<nums.length; i++)
        {
              nums[i]= nums[i] * nums[i];
        }

        for( int pos = nums.length-1; pos>=0; pos--)
        {
            if(nums[start]>nums[end])
            {
                result[pos] = nums[start];
                start++;
            }
            else
            {
                result[pos]=nums[end];
                end--;
            }
        }
        return result;
    }
}