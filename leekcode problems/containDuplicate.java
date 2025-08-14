import java.util.HashMap;
import java.util.Map;

public class containDuplicate {
public static void main(String[] args) {
    
    int nums[] = {1,1,1,3,3,4,3,2,4,2};
    System.out.println(containsduplicate(nums));

    
}
public static boolean containsduplicate(int[] nums) {
    Map<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (hm.containsKey(nums[i])) {
            return true; // Duplicate found
        }
        hm.put(nums[i], i); // Store the index of the number
    }
    return false; // No duplicates found
}
}