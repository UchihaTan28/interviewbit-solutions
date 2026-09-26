public class Solution {
    public ArrayList<Integer> findPath(TreeNode root, int B) {
       // Base case: If the root is null (empty tree) or 
       if (root == null || root.val == B) {
           ArrayList<Integer> path = new ArrayList<>();
           if (root != null) path.add(root.val);
           return path;
       }

       ArrayList<Integer> leftPath = findPath(root.left, B);
       ArrayList<Integer> rightPath = findPath(root.right, B);
       if (leftPath != null) { leftPath.add(0, root.val); return leftPath;}
       else if (rightPath != null) {rightPath.add(0, root.val);return rightPath;}
       return null;
   } 
    
    private ArrayList<Integer> solveUtil(TreeNode root, int B, ArrayList<Integer> ans)
   {
       ans.add(root.val);
       if(root.val == B){ return ans;}
       ArrayList<Integer> left = null, right = null;
       
       if(root.left!=null) left = solveUtil(root.left, B, ans);
       if(left!=null) return left;
       
       if(root.right!=null) right = solveUtil(root.right, B, ans);
       if(right!=null) return right;
       
       ans.remove(ans.size()-1);
       return null;
   }
    private ArrayList<Integer> solveUtil2(TreeNode root, int B, ArrayList<Integer> arr)
    {
        if(root == null) return null;
        arr.add(root.val);
        if(root.val == B) return arr;
        
        ArrayList<Integer> left = null, right= null; 
        left = solveUtil2(root.left, B, arr);
        if(left!=null) return left;
        
        right = solveUtil2(root.right, B, arr);
        if(right!=null) return right;
        
        arr.remove(arr.size()-1);
        return null;
    }

    private ArrayList<Integer> solveUtil(TreeNode A, int B)
    {
        if(A == null) return null;
        curr.add(A.val);
        
        if(A.val == B) return curr;
        
        ArrayList<Integer> left = null, right = null;
        left = solveUtil(A.left, B);
        if(left!=null) return left;
        
        right = solveUtil(A.right, B);
        if(right!=null) return right;
        
        curr.remove(curr.size() - 1);
        return null;
    }
    
     
    public ArrayList<Integer> solve(TreeNode A, int B) {   
        return solveUtil(A, B);
        
        //ArrayList<Integer> arr = new ArrayList<Integer>();
        //return solveUtil2(A, B, arr);
        
        /*ArrayList<Integer> ans = new ArrayList<Integer>();
        return solveUtil(A, B, ans);*/
        
        //BinaryTree tree = new BinaryTree();
        /*ArrayList<Integer> path = this.findPath(A, B);
        return path;*/
    }
}