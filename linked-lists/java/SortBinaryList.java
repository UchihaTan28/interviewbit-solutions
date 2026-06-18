/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        ListNode curr = A;
        ListNode zeroList = new ListNode(0), oneList = new ListNode(1);
        
        ListNode zl = zeroList, ol = oneList;
        while(curr!=null)
        {
            ListNode temp = curr.next;
            if(curr.val == 0)
            {
                zl.next = curr;
                zl = zl.next;
            }
            else
            {
                ol.next = curr;
                ol = ol.next;
            }
            curr.next = null;
            curr = temp;
        }
        zl.next = oneList.next;
        return zeroList.next;
    }
}