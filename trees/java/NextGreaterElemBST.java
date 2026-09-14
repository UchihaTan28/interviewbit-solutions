public TreeNode getSuccessor(TreeNode A, int b) {
        if(A == null) return null;
        //if(A.left==null && A.right==null) return A;
        
        TreeNode left = null, right = null;
        
        if(b < A.val){left = getSuccessor(A.left, b); return left==null? A: left;}
        //if(left!=null) return left;
        
	else right = getSuccessor(A.right, b);
        return right;
        
        //wrong
        /*TreeNode curr = A, ans = null, prev = A;
        while(curr!=null)
        {
            if( b > curr.val && b < prev.val ) ans = prev;
            else if( b >= prev.val && b < curr.val) ans = curr;
        
            prev = curr;
            if( b < curr.val ) curr = curr.left;
            else curr = curr.right;
        }
        
        if(ans != null) return ans;
        if(b < prev.val) return prev;
        return null;
	*/
        
    }