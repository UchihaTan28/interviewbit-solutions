public class Solution {
    ArrayList<Integer> ans= null;
    int minIndex = Integer.MAX_VALUE, maxIndex = -1;
    private int maxDepth(TreeNode A)
    {
        if(A == null) return 0;
        return 1 + Math.max(maxDepth(A.left), maxDepth(A.right));
    }
    
    private void verticalSumUtil(TreeNode A, int n)
    {
        //if(depth == 0) return;
        //if(A != null) {ans.set(n, ans.get(n) + A.val); minIndex = Math.min(minIndex, n); maxIndex = Math.max(maxIndex, n);}
        
        if(A == null) return ;
        ans.set(n, ans.get(n) + A.val); minIndex = Math.min(minIndex, n); maxIndex = Math.max(maxIndex, n);
        
        //verticalSumUtil((A == null? null: A.left), n-1);
        //verticalSumUtil((A == null? null: A.right), n+1);
        
        verticalSumUtil(A.left, n-1);
        verticalSumUtil(A.right, n+1);
        return;
    }
    
    public ArrayList<Integer> verticalSum(TreeNode A) {
        int maxDepth = maxDepth(A);
        ans = new ArrayList<Integer>(Collections.nCopies( 4*maxDepth+1, 0));
        verticalSumUtil(A, maxDepth*2);
        
        int n = ans.size(); ArrayList<Integer> res = new ArrayList<Integer>();
        //for(int i=0; i<minIndex; i++) ans.remove(0);
        //for(int i=n-1; i>maxIndex; i--) ans.remove(ans.size()-1);
         
        for (int i = minIndex; i <= maxIndex; i++) res.add(ans.get(i)); 
        return res;
    }
}