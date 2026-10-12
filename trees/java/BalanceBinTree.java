public class Solution {
    private int isBalancedHelper(TreeNode A)
    {
        //if height diff <=1 : return height
        //else return -1
        if(A == null) return 0;
        
        int left = isBalancedHelper(A.left);
        int right = isBalancedHelper(A.right);
        
        if(left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
    
    private int maxDepth(TreeNode A)
    {
        if(A == null) return 0;
        
        int left = -1, right = -1;
        left = maxDepth(A.left);
        right = maxDepth(A.right);
        
        if(left == -1 || right == -1 || Math.abs(right - left) > 1) return -1;
        return 1 + Math.max(left, right);
    }
    public int isBalanced(TreeNode A) {
        return maxDepth(A) == -1? 0 : 1;
        
        //return isBalancedHelper(A) == -1? 0: 1;
    }
}