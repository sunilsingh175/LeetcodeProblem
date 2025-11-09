public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length(), count = 0;
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aaa";
        System.out.println(sol.countSubstrings(s)); // Output: 6
    }
}
