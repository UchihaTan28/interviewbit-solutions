public class Solution {
    private TreeNode initial = null;
    int[] ans = new int[0];
    HashSet<TreeNode> vis = new HashSet<TreeNode>();
    private HashMap<TreeNode, ArrayList<TreeNode>> adj = new HashMap<TreeNode, ArrayList<TreeNode>>();
    
    private void constructAdjByPre(TreeNode A, int B)
    {
        if(A == null) return;
        
        if(!adj.containsKey(A)){adj.put(A, new ArrayList<TreeNode>());}
        if(A.left!=null && !adj.containsKey(A.left)){adj.put(A.left, new ArrayList<TreeNode>());}
        if(A.right!=null && !adj.containsKey(A.right)){adj.put(A.right, new ArrayList<TreeNode>());}
        
        if(A.left != null){adj.get(A).add(A.left); adj.get(A.left).add(A);}
        if(A.right != null){adj.get(A).add(A.right); adj.get(A.right).add(A);}
        
        if(A.val == B) initial = A;
        constructAdjByPre(A.left, B);
        constructAdjByPre(A.right, B);
        
    }
    private void bfs(TreeNode root, int currentDist, int C)
    {
        if(root == null || vis.contains(root)) return;
        vis.add(root);
        if(currentDist == C) { ans = Arrays.copyOf(ans, ans.length + 1); ans[ans.length - 1] = root.val; return;}
        
        for(TreeNode child: adj.get(root))
        {
            bfs(child, currentDist + 1, C);
        }
        return;
    }
    
    public int[] distanceK(TreeNode A, int B, int C) {
        constructAdjByPre(A, B);
        bfs(initial, 0, C);
        return ans;
    }
}