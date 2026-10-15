public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private TreeNode arrayToBBST(MyList<Integer> A, int start, int end)
    {
        if( start > end) return null;
        if( start == end ) return new TreeNode(A.get(start));
        
        int midIndex = (start + end)/2;
        TreeNode root = new TreeNode(A.get(midIndex));
        
        root.left = arrayToBBST(A, start, midIndex-1);
        root.right = arrayToBBST(A, midIndex+1, end);
        return root;
    }
    
    private TreeNode sortedArrayToBBST(MyList<Integer> A, int start, int end)
    {
        if(start > end ) return null;
        if(start == end ) return new TreeNode(A.get(start));
        
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(A.get(mid));
        
        root.left = sortedArrayToBBST(A, start, mid-1);
        root.right = sortedArrayToBBST(A, mid+1, end);
        
        return root;
    }
    
    public TreeNode sortedArrayToBST(MyList<Integer> A) {
        return sortedArrayToBBST(A, 0 , A.size()-1); 
        //return arrayToBBST(A, 0, A.size()-1);
    }
}