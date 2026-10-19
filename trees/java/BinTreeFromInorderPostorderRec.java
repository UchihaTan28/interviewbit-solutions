public class Solution {
    private int ptr = -1;
    private TreeNode buildTreeUtil(ArrayList<Integer> A, ArrayList<Integer> B, int start, int end)
    {
        if(start > end || ptr < 0) return null;
        //if(start == end) {ptr--; return new TreeNode(A.get(start));}
        
        TreeNode root = new TreeNode(B.get(ptr));
        int inIndex = A.indexOf(B.get(ptr--));
        
        root.right = buildTreeUtil(A, B, inIndex + 1, end);
        root.left = buildTreeUtil(A, B, start, inIndex - 1);
        
        return root;
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        ptr = A.size()-1;
        return buildTreeUtil(A, B, 0 , A.size()-1);
    }
}