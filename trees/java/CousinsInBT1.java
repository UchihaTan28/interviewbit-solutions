public class Solution {
    public int[] solve(TreeNode A, int B) {
        Queue<TreeNode> q = new LinkedList<>();
        int[] ans = new int[0];
        q.add(A);
        TreeNode parent = null;
        boolean isParentLevel = false, isCousinLevel = false;
        
        while(q.isEmpty() == false)
        {
            int n = q.size();
            for(int i=0; i < n; i++)
            {
                TreeNode temp = q.remove();
                
                if(parent != null && isParentLevel == false)
                {
                    isCousinLevel = true;
                    if(!(parent.left == temp || parent.right == temp)) 
                    {ans = Arrays.copyOf(ans, ans.length + 1); ans[ans.length - 1] = temp.val;}
                }
                
                if(temp.left != null) {q.add(temp.left); if(temp.left.val == B) {parent = temp; isParentLevel = true;}}
                if(temp.right != null) {q.add(temp.right); if(temp.right.val == B) {parent = temp; isParentLevel = true; }}
            }
            isParentLevel = false;
            if(ans.length != 0 || isCousinLevel == true) break; 
        }
        return ans;
    }
}