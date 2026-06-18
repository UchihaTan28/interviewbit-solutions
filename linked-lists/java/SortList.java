/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    private ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // split into 2 halves
        if (prev != null) prev.next = null;

        return slow;   // head of second half
    }

    private ListNode merge(ListNode A, ListNode B, ListNode tempEndNext)
    {
        if(A == null) { 
            /*ListNode curr = B;
            while(curr.next != null) curr = curr.next;
            curr.next = tempEndNext;*/
            return B;
        }
        if(B == null) { return A; }

        if(A.val < B.val) {
            A.next = merge(A.next, B, tempEndNext);
            return A;
        }
        else {
            B.next = merge(A, B.next, tempEndNext);
            return B;
        }
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMidNode(head);

        ListNode first = mergeSort(head);
        ListNode second = mergeSort(mid);

        return merge(first, second, null);
    }

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) return A;
        return mergeSort(A);
    }
}