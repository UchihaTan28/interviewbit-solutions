/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    /*public ListNode reverse(ListNode curr)
    {
        if(curr.next==null) {/*curr.next=prev; prev.next = curr; return curr;}
        
        ListNode returned = reverse(curr.next, prev);
        ListNode temp = prev.next;
        returned.next = prev.next;
        prev.next= returned;
        prev = temp;
        
        //curr.next = returned;
        return curr;    
    }*/
    
    private ListNode reverse(ListNode curr)
    {
        if(curr.next==null) return curr;
        ListNode temp= reverse(curr.next);
        curr.next.next= curr;
        curr.next=null;
        return temp;
    }
    
    public ListNode reorderList(ListNode A) {
        ListNode slow= A, fast=A;
        if(A.next==null) return A;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next; 
        }
        
        ListNode B = null;
        if(fast==null) B = reverse(slow);
        else B = reverse(slow.next);
        
        ListNode currA= A, currB=B;
        while(currB!=null)
        {
            ListNode temp = currB.next;
            currB.next = currA.next;
            currA.next = currB;
            currA = currB.next;
            currB = temp;    
        }
        if(currA!=null)currA.next=null;
        return A;
    }
}

//1 2 3
// 6 5 4
//123456