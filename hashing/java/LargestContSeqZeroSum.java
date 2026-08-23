public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> S= new ArrayList<Integer>();
        int n=A.size(),sum=0, zero_index=-1;
        for(int i=0;i<n;i++){sum+=A.get(i);S.add(sum);}
        
        HashMap<Integer, Integer> M= new HashMap<Integer, Integer>();
        M.put(0, -1);
        ArrayList<Integer> ans= new ArrayList<Integer>(Collections.nCopies(2,0));
        ArrayList<Integer> res= new ArrayList<Integer>();
        
        for(int i=0;i<n;i++){
            if(M.containsKey(S.get(i))==false)M.put(S.get(i), i);
            else
            {
                if(S.get(i)==0&&i>=ans.get(1)-ans.get(0)){ans.set(0, -1);ans.set(1, i);}
                else if(i-M.get(S.get(i))>ans.get(1)-ans.get(0)){ans.set(0, M.get(S.get(i)));ans.set(1, i);}
            }
        }
        for(int i=ans.get(0)+1;i<=ans.get(1);i++)res.add(A.get(i));
        return res;
    }
}
