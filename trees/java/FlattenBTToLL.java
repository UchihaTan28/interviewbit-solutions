/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode flattenHelper(TreeNode a)
    {
        if(a == null)return null;
        if(a.left == null && a.right ==null) return a;
        
        TreeNode returnedLeft = flattenHelper(a.left);
        TreeNode returnedRight = flattenHelper(a.right);
        
        TreeNode temp = a.right;
        if(returnedLeft!=null)
        {
            returnedLeft.right = temp;
            a.right = a.left;
        }
        
        a.left = null;
        return returnedRight!=null? returnedRight:returnedLeft;
    }
    
    private TreeNode helper(TreeNode A)
    {
        if(A == null) return null;
        if(A.left == null && A.right == null) return A;
        
        TreeNode returnedLeft = helper(A.left);
        TreeNode returnedRight = helper(A.right);
        
        TreeNode tempRight = A.right;
        if(A.left!=null) 
        {   
            returnedLeft.right = tempRight;
            A.right = A.left;
            A.left = null;
        }
        return returnedRight!=null? returnedRight : returnedLeft;
    }
    
    private TreeNode flatten2(TreeNode A)
    {
        if(A == null) return null;
        if(A.left == null && A.right == null) return A;
        
        TreeNode leftEnd = flatten2(A.left);
        TreeNode right = flatten2(A.right);
        
        if(leftEnd != null)
        {leftEnd.right = A.right;
        A.right = A.left;}
        A.left = null;
        
        return right == null? leftEnd: right;
    }
    
    public TreeNode flatten(TreeNode a) {
        TreeNode end = flatten2(a);
        return a;
        /*TreeNode ret = helper(a);
        return a;*/
        /*TreeNode ret= flattenHelper(a);
        return a;*/
    }
}