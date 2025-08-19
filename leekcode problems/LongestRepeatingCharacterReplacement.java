class LongestRepeatingCharacterReplacement {

public static void main(String[] args) {
        String s = "ABAB";
      int k = 2;
        System.out.println(characterReplacement(s , k));
    }
    public  static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left =0;
        int maxfreq = 0;
        int maxWindow  =0;

        for(int right = 0; right < s.length(); right++)
        {
            freq[s.charAt(right) - 'A']++;

            maxfreq = Math.max(maxfreq ,  freq[s.charAt(right)- 'A']);
            int windowLength = right - left +1;

            if(windowLength -maxfreq>k)
            {
                 freq[s.charAt(left) - 'A']--;
                 left++;
            }
            windowLength = right - left + 1;
            maxWindow = Math.max(maxWindow , windowLength);
        }
        return maxWindow;
    }
}