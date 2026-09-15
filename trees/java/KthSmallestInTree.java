public class Solution {
    public int kthsmallest(TreeNode A, int B) {
        TreeNode curr = A; 
        Deque<TreeNode> stk = new ArrayDeque<>();
        
        while(stk.isEmpty()==false || curr!=null)
        {
            if(curr!=null){ stk.push(curr); curr = curr.left;}
            else
            {
                TreeNode temp = stk.pop();
                B--;
                if(B == 0) return temp.val;
                curr = temp.right;
            }
        }
        return -1;
    }
}