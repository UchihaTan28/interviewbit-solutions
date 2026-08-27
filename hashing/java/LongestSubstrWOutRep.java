public class Solution {
    public int lengthOfLongestSubstring(String A) {
        int n=A.length();
        if(n==0||n==1)return 1;
        int i=0, ans=1;
        //HashSet<Integer>S= new HashSet<>();
        HashMap<Character, Integer> M= new HashMap<>(); 
        //S.add(A.charAt(0));
        M.put(A.charAt(0), 0);
        
        for(int j=1;j<n;j++)
        {
            //S.add(A.charAt(j));
            if(M.containsKey(A.charAt(j))==true)
            {
                while(i<n&&A.charAt(i)!=A.charAt(j))
                {
                    M.remove(A.charAt(i)); i++;
                }
                if(i>=n)return ans;
                M.remove(A.charAt(i));i++;
            }
            else ans=Math.max(ans, j-i+1);
            M.put(A.charAt(j), j);
        }
        return ans;
    }
}