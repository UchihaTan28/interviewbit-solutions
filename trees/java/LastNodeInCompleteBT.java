public class Solution {
    private int maxDepth(TreeNode A)
    {
        int ans =0;
        while(A!=null){ ans++; A = A.left;}
        return ans;
    }
    
    private boolean doesLeftMostSpineExists(TreeNode A, int N)
    {
        while(A!=null){ A = A.left; N--;}
        return N == 0? true: false; 
    }
    
    private int lastNodeUtil(TreeNode A, int N)
    {
        if(A.left == null && A.right == null) 
        {return N == 1? A.val: -1;}
        
        boolean right = false, left = false;
        right = doesLeftMostSpineExists(A.right, N - 1);
        if(right) return lastNodeUtil(A.right, N - 1);
        
        return lastNodeUtil(A.left, N - 1);
    }
    
    public int lastNode(TreeNode A) {
        int N = maxDepth(A);
        return lastNodeUtil(A, N);
    }
}