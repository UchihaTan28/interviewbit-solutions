/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a, fast = a;
        boolean flag=false;
        
        while(fast!=null && (fast.next)!= null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){flag=true; break;}
        }
        
        if(flag==false) return null;
        slow=a;
        
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}