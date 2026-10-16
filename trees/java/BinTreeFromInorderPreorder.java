public class Solution {
    private int preIndex = 0;
    private int indexOf(int[] B, int val)
    {
        int i=0;
        while(B[i] != val) i++;
        
        return i;
    }
    private TreeNode buildTree(int[] A, int[] B, int start, int end)
    {
        if(start > end || preIndex == A.length) return null;
        if( start == end ) {preIndex++; return new TreeNode(A[preIndex-1]);}
        
        TreeNode curr = new TreeNode(A[preIndex]);
        int inIndex = indexOf(B, A[preIndex]);
        preIndex++;
        
        curr.left = buildTree(A, B, start, inIndex - 1 );
        curr.right = buildTree(A, B, inIndex + 1, end);
        
        return curr;
    }
    public TreeNode buildTree(int[] A, int[] B) {
        return buildTree(A, B, 0, A.length - 1);
    }
}