public class Solution {
    public TreeNode solve(TreeNode A, TreeNode B) {
        if(A == null) return B;
        if(B == null) return A;
        
        A.val += B.val;
        A.left = solve(A.left, B.left);
        A.right = solve(A.right, B.right); 
        return A;
    }
}
