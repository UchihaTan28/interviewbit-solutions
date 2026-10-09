public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        boolean flag = true;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        Stack<TreeNode> S = new Stack<>();
        s1.push(A);
        
        while(s1.isEmpty() == false || s2.isEmpty() == false)
        {
            S = (flag == true)? s1 : s2;
            ArrayList<Integer> curr =  new ArrayList<>();
            
            int n = S.size();
            for(int i = 0; i < n; i++)
            {
                TreeNode temp = S.pop();
                curr.add(temp.val);    
                if(flag)
                {
                    if(temp.left != null) s2.push(temp.left);
                    if(temp.right != null) s2.push(temp.right);
                }
                else
                {
                    if(temp.right != null) s1.push(temp.right);
                    if(temp.left != null) s1.push(temp.left);
                }
            }
            flag = !flag;
            ans.add(curr);
        }
        return ans;
    }
}