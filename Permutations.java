import java.util.*;

class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    private static void backtrack(List<List<Integer>> resultList,
                                  List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int number : nums) {
            if (tempList.contains(number)) continue;

            tempList.add(number);
            backtrack(resultList, tempList, nums);
            tempList.remove(tempList.size() - 1); // backtrack
        }
    }
}
