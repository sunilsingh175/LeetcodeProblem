class PermutationString {

public static void main(String[] args) {
       String s1 = "ab";
       String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1 , s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[]  first=new int[26],second = new int[26];

        for(char c:s1.toCharArray())
        {
            first[c-'a']+=1;
        }
        int window = s1.length()-1;
        for(int i=0; i<s2.length(); i++)
        {
            second[s2.charAt(i)-'a']+=1;
            if(i>=window)
            {
                if(match(first,second))  return true;

                second[s2.charAt(i-window)-'a'] -=1;
            }
        }
        return false;
    }
    private static boolean match(int[] first, int[] second)
    {
        for(int i=0;i<26;i++)
        {
            if(first[i]!=second[i]) return false;
        }
        return true;
    }
}