public class Solution {
    public TreeNode buildTree(int[] A, int[] B) {
        int n = A.length;
        if(n == 0) return null;
        Stack<TreeNode> stk = new Stack<>();
        int inIndex = n-1;
        TreeNode root = new TreeNode(B[n-1]);
        stk.push(root);
        
        for(int postIndex = n-2; postIndex >=0 ; postIndex--)
        {
            TreeNode node = stk.peek();
            if(node.val != A[inIndex])
            {
              node.right = new TreeNode(B[postIndex]); 
              stk.push(node.right);
            }
            else
            {
              while(stk.empty()==false && stk.peek().val == A[inIndex])
              {
                node = stk.pop();
                inIndex--;
              }
              node.left = new TreeNode(B[postIndex]);
              stk.push(node.left);    
            }
        }
        return root;  
    }
}