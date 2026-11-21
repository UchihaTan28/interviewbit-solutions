public class Solution {
    public int[] preorderTraversal(TreeNode A) {
        Deque<TreeNode> stk = new ArrayDeque<>();
        //ArrayList<Integer> ans = new ArrayList<>();
        int[] ans = new int[1000000];
        stk.push(A);
        int i=0;
        
        while(stk.isEmpty() == false)
        {
            TreeNode curr = stk.pop();
            //ans.add(curr.val);
            ans[i++] = curr.val;
            if(curr.right!=null) stk.push(curr.right);
            if(curr.left!=null) stk.push(curr.left);
        }
        return Arrays.copyOf(ans, i);
        // Arrays.copyOf(ans, ans.size());  => size() is only used on collections
        //return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}