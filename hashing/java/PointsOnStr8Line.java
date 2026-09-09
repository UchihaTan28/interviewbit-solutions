public class Solution {
    public int maxPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n=A.size();
        int ans=2;
        if(n==0||n==1||n==2)return n;
        
        HashMap<Double, Integer> M= new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)continue;
                int x=A.get(i); int y=B.get(i);
                double slope= B.get(j)-y;
                int den=A.get(j)-x;
                
                if(den==0)slope= Double.MAX_VALUE;
                else slope=slope/den;
                
                M.put(slope, M.getOrDefault(slope, 0)+1);
                ans=Math.max(ans, M.get(slope)+1);
            }
            M.clear();
        }
        return ans;
    }
}