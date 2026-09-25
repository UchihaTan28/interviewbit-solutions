public class Solution {
    private boolean hasPathSumHelper(TreeNode A, int sum)
    {
        if(A == null) return false;
        sum-=A.val;
        if(A.left==null && A.right==null) {
            if(sum==0)return true;
        }
        return (hasPathSumHelper(A.left, sum) || hasPathSumHelper(A.right, sum));    
    }
    public int hasPathSum(TreeNode A, int B) {
        B-=A.val;
        if(A.left==null && A.right==null) {
            if(B == 0) return 1;
        }
        
        int left = 0, right = 0;
        if(A.left!=null) left = hasPathSum(A.left, B);
        if(left == 1) return 1; 
        if(A.right!=null) right = hasPathSum(A.right, B);
        if(right == 1) return 1;
        
        return 0;
        //return hasPathSumHelper(A, B)? 1: 0; 
    }
}