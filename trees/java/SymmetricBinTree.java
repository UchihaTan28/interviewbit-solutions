public class Solution {
    private boolean isSymmetricHelper(TreeNode A, TreeNode B)
    {
        if(A==null && B==null) return true;
        if(A == null || B == null) return false;
        if(A.val != B.val) return false;
        
        boolean leftA = false, rightA = false;
        leftA = isSymmetricHelper(A.left, B.right);
        rightA = isSymmetricHelper(A.right, B.left);
        
        return leftA && rightA;   
    }
    
    public int isSymmetric(TreeNode A) {
        return (isSymmetricHelper(A, A) == true)? 1 : 0;
    }
}