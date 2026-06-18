/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A, int B) 
    {
        ListNode slow= A, fast=A;
        int mid=0;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            mid++;
        }
        int req=mid-B;
        if(req<0) return -1;
        
        slow= A;
        while(req--!=0)
        {
            slow=slow.next;
        }
        return slow.val;               
    }
}