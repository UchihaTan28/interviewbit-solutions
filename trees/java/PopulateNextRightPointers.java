public class Solution {
    public void connect(TreeLinkNode root) {
        
        TreeLinkNode curr = root; 
        while(curr != null)
        {
            TreeLinkNode dummy = new TreeLinkNode(-1);
            TreeLinkNode tail = dummy;
            while(curr != null)
            {
                if(curr.left != null) 
                {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                if(curr.right != null) 
                {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }   
    }
}