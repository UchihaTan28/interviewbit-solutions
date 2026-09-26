public class Solution {
    private int ans = 0;
    
    private void preorder(TreeNode A)
    {
        if(A == null) return;
        
        if(A.left != null && (A.left.val == A.val + 1 || A.left.val == A.val - 1)) ans++;
        if(A.right != null && (A.right.val == A.val + 1 || A.right.val == A.val - 1)) ans++;
        
        preorder(A.left);
        preorder(A.right);
    }
    
    private int postorder(TreeNode A)
    {
        if(A == null) return 0;
        
        int left = 0, right = 0;
        left = postorder(A.left);
        right = postorder(A.right);
        
        if(A.left != null && (A.left.val == A.val + 1 || A.left.val == A.val - 1)) left++;
        if(A.right != null && (A.right.val == A.val + 1 || A.right.val == A.val - 1)) right++;
        return left + right;
    }
    
    public int consecutiveNodes(TreeNode A) {
        return postorder(A);
        //preorder(A);
        //return ans;
    }
}