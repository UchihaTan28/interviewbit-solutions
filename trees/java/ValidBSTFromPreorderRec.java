public class Solution {
    private boolean solveHelper(ArrayList<Integer> A, int l, int r, int max, int min)
    {
        if(l>= A.size() || l >= r)return true;
        if(A.get(l) >= max || A.get(l) <= min)return false;
        
        int i=l+1;
        while(i<r && A.get(l)>=A.get(i))
        {
            if(A.get(i)==A.get(l))return false;  
            i++;
        }
        
        return solveHelper(A, l+1, i, A.get(l), min) && solveHelper(A, i, r, max, A.get(l));
        
        //return true;
    }
    public int solve(ArrayList<Integer> A) {
        return solveHelper(A, 0, A.size(), Integer.MAX_VALUE, Integer.MIN_VALUE)==true?1:0;
    }
}