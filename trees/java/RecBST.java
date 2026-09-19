public class Solution {
    public int[] recoverTree(TreeNode A) {
        ArrayList<Integer> ansList = new ArrayList<>();
        //root.add(A); root.add(null);
        
        //Stack<ArrayList<TreeNode>> stk = new Stack<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = A, prev = null;
        
        while(stk.isEmpty() == false || curr != null)
        {
            if( curr != null )
            { stk.push(curr); curr = curr.left;}
            else
            {
                TreeNode temp = stk.pop();
                if( prev!=null && (prev.val > temp.val) ) { ansList.add(prev.val); ansList.add(temp.val);}
                
                prev = temp;
                curr = temp.right;
            }
        }
        int[] ans = new int[2];
        if(ansList.size() == 4){ ans[0]= ansList.get(3); ans[1] = ansList.get(0);}
        else { ans[0]= ansList.get(1); ans[1] = ansList.get(0); } 
        
        return ans;
    }
}