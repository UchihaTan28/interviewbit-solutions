public class Solution {
    public int[] solve(TreeNode A, int B) {
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(A);
        TreeNode parent = null;
        
        while(q.isEmpty() == false)
        {
            int n = q.size();
            if(parent != null) break;
            
            for(int i = 0; i < n; i++)
            {
                TreeNode temp = q.remove();
                if(temp.left !=null && temp.left.val == B || temp.right != null && temp.right.val == B) {parent = temp; continue;}
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
        //System.out.println(q.remove().val + q.remove().val);
        
        //always use n for safety as q shrinks 
        int n = q.size();
        int[] ans = new int[n];
        for(int i=0; i< n; i++) {ans[i] = q.element().val; q.remove();}
        
        return ans;
    }
}