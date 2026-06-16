/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
// 5-6 ways to reverse ll
public class Solution {
    /*ListNode reverse(ListNode curr, ListNode head, int diff)
    {
        if(curr.next==null || diff < 1) {head.next = curr.next; return curr;}
        
        ListNode rev = reverse(curr.next, head, diff-1);
        curr.next.next = curr;
        curr.next = null;
        return rev;
    }*/ // be cautious of this version of reverse, because head's next gets modified initially
    
    //tail recurse
    private ListNode reverse(ListNode curr, ListNode rev, ListNode head, int diff)
    {
        if(curr==null || diff < 0) {head.next = curr; return rev;}
        
        ListNode temp = curr.next;
        curr.next = rev;
        rev = curr;
        return reverse(temp, rev, head, --diff);
    }
    
    public ListNode reverseBetween(ListNode A, int B, int C) {
        //B--; C--;
        int tempB= B;
        if(A.next==null) return A;
        ListNode initial = new ListNode(0);
        initial.next = A;
        ListNode curr = initial;
        
        while(tempB-- > 1 && curr!=null) curr = curr.next;
        
        ListNode rev= null;
        rev = reverse(curr.next, rev, curr.next, C - B);
        
        if(B == 1) return rev;
        curr.next = rev;
        return A;
    }
}