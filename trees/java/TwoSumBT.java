public class Solution {
    public int t2Sum(TreeNode A, int B) {
        Stack<TreeNode> leftySpine = new Stack<>(), rightySpine = new Stack<>();
        
        TreeNode currLeft = A, currRight = A;
        while(currLeft!=null) {leftySpine.push(currLeft); currLeft = currLeft.left;}
        while(currRight!=null) {rightySpine.push(currRight); currRight = currRight.right;}
        
        while(leftySpine.isEmpty() == false && rightySpine.isEmpty() == false && leftySpine.peek().val < rightySpine.peek().val)
        {
            if(leftySpine.peek() == rightySpine.peek() && currLeft != null) return 0;
            currLeft = leftySpine.peek(); currRight = rightySpine.peek();
            
            if(currLeft.val + currRight.val == B) return 1;
            else if(currLeft.val + currRight.val > B)
            {
                rightySpine.pop(); // currRight
                TreeNode temp = currRight.left;
                while( temp!=null) {rightySpine.push(temp); temp = temp.right; }
            }
            else
            {
                leftySpine.pop(); // currLeft
                TreeNode temp = currLeft.right;
                while( temp!=null) {leftySpine.push(temp); temp = temp.left; }
            }
        }
        return 0;
    }
}