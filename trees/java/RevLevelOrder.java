public class Solution {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> V= new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(A == null) return ans;
        q.add(A);
        
        while(q.isEmpty() == false)
        {
            int n = q.size();
            ArrayList<Integer> levelArr = new ArrayList<Integer>();
            for(int i=0; i< n; i++)
            {
                TreeNode front = q.remove();
                levelArr.add(front.val);
                if(front.left != null) q.add(front.left);
                if(front.right != null) q.add(front.right);
            }
            V.add(levelArr);
        }
        Collections.reverse(V);
        
        for(ArrayList<Integer> levelArr: V)
        {
            for(Integer ele: levelArr) ans.add(ele);
        }
        return ans;
    }
}