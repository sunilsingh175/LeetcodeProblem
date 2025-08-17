import java.util.*;
class FindAllAnagrams {

 public static void main(String[] args)
{
   String s = "cbaebabacd";
        String p = "abc";
     System.out.println((findAnagrams(s , p)));

}


    public static List<Integer> findAnagrams(String s, String p) {
        int[] countA = new int[26];
        int[] countB = new int[26];
        List<Integer> result = new ArrayList<>();
        
        for(char c:p.toCharArray())
        {
            countA[c-'a']++;
        }

        for(int i = 0; i<s.length(); i++)
        {
            countB[s.charAt(i) - 'a']++;

            if(i>=p.length())
            {
                countB[s.charAt(i-p.length())-'a']--;
            }

            if(Arrays.equals(countA, countB))
            {
                result.add(i-p.length() +1);
            }
        }
        return result;
     }
}