public class Solution {
    public TreeNode buildTree(int[] A, int[] B) {
        int n = A.length;
        if(n == 0) return null;
        
        TreeNode root = new TreeNode(A[0]);
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        int inPtr = 0;
        
        for(int preIndex = 1; preIndex < n; preIndex++)
        {
            TreeNode node = stk.peek();
            if(node.val != B[inPtr])
            {
                node.left = new TreeNode(A[preIndex]);
                stk.push(node.left);
            }
            else
            {
                while(stk.empty()==false && stk.peek().val == B[inPtr])
                {
                    node = stk.pop();
                    inPtr++;
                }
                node.right = new TreeNode(A[preIndex]);
                stk.push(node.right);
            }
        }
        return root;
    }
}