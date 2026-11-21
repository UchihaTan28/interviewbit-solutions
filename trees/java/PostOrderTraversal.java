public class Solution {
    public int[] postorderTraversal(TreeNode A) {
        Deque<TreeNode> stk = new ArrayDeque<>();
        int[] ans = new int[1000000];
        stk.push(A); int i=0;
        
        while(stk.isEmpty() == false)
        {
            TreeNode curr = stk.pop();
            ans[i++] = curr.val;
            if(curr.left!=null) stk.push(curr.left);
            if(curr.right!=null) stk.push(curr.right);
        }
        ans = Arrays.copyOf(ans, i);
        for(int j=0; j<i/2; j++)
        {
            ans[j] += ans[i-1-j];
            ans[i-1-j] = ans[j] - ans[i-1-j];
            ans[j] = ans[j] - ans[i-1-j];
        }
        return ans; 
    }
}