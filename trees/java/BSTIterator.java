public class Solution {
    /*private Queue<Integer> inorder = null;
    private void inorderTraversal(TreeNode root)
    {
        if(root == null) return;
        
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }*/
    
    //private TreeNode nextCandidate = null;
    private Stack<TreeNode> spine = new Stack<>();
    
    // other sol can be create an initial node and point its right to root. 
    // But the extra condition to avoid this one to be returned will be required
    public Solution(TreeNode root) {
        while(root!=null)
        {
            spine.push(root);
            root = root.left;
        }
        
        /*this.inorder = new LinkedList<>();
        inorderTraversal(root);*/
    }
    
    public boolean hasNext() {
        return !(spine.isEmpty());
    }
    
    // the key is that next can have O(h) as worst TC
    public int next() {
        if(hasNext())
        {
            TreeNode ans = spine.peek(); spine.pop();
            TreeNode curr = ans.right;
            while(curr!=null)
            {
                spine.push(curr);
                curr = curr.left;
            }
            return ans.val;
        }
        return -1;
        
        //messed it up
        /*if(this.nextCandidate!=null) 
        { 
            int ans = this.nextCandidate.val; 
            this.nextCandidate = 
            //if(this.nextCandidate.right!=null) {spine.push(this.nextCandidate.right); this.nextCandidate = null; }
            //else {this.nextCandidate = spin}
            return ans;
        }
        
        if(spine.isEmpty() == false)
        {
            TreeNode curr = spine.peek();
            while(curr.left!=null)
            {
                spine.push(curr);
                curr = curr.left;
            }
            TreeNode ans = curr;
            spine.pop(); // = curr
            if(spine.isEmpty()==false && spine.peek().left == curr) 
            {this.nextCandidate = spine.peek(); spine.pop(); curr = this.nextCandidate;}
            
            if(curr.right!=null) spine.push(curr.right);
            return ans.val;
        }*/
        
        /*if(this.hasNext() == true )
        {int front = inorder.remove(); return front;} 
        return -1;*/
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */