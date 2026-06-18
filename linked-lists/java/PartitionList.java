/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {
        ListNode smallerValsList = new ListNode(0), currA = A, head = A;
        ListNode currSVL = smallerValsList;
        
        while(head!=null && head.val < B)
        {
            ListNode temp = head.next;
            head.next = null;
            currSVL.next = head;
            head = temp;
            currSVL = currSVL.next;
        }
        currA = head;
        while(currA!=null && currA.next!=null)
        {
            if(currA.next.val < B)
            {
                ListNode temp = currA.next.next;
                currSVL.next = currA.next;
                currA.next = temp;
                if(currSVL!=null)currSVL = currSVL.next;
                currSVL.next = null;
            }
            else currA= currA.next;
        }
        /*if(currA.val < B)
        {
            currSVL.next = currA;
        }*/
        
        smallerValsList = smallerValsList.next;
        if(smallerValsList==null) return A;
        currSVL.next = head;
        return smallerValsList;
    }
}

// 4 3 2 5 2
// 0 1 1

// 4 3 5 3
// 0 2