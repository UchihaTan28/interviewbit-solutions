public class Solution {
    private boolean foundB, foundC;
    
    private int lcaUtil(TreeNode A, int B, int C)
    {
        if(A == null) return -1;
        
        if(A.val == B) foundB = true;
        if(A.val == C) foundC = true;
        
        int left = -1, right = -1;
        
        left = lcaUtil(A.left, B , C);
        right = lcaUtil(A.right, B, C);
        
        if(A.val == B || A.val == C || (left != -1 && right != -1)) return A.val;
        
        if(left != -1) return left;
        if(right != -1) return right;
        return -1;  
    }
    
    public int lca(TreeNode A, int B, int C) {
        foundB= false; foundC = false;
        int ans = lcaUtil(A, B, C);
        return (foundB && foundC)? ans : -1;
    }
}
