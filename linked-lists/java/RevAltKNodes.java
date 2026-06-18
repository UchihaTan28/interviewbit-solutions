/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    /*ListNode reverse(ListNode curr, ListNode rev, int B, ListNode old)
    {
        if(curr==null || B==0) {old.next = rev; return curr;}
        ListNode temp= curr.next;
        curr.next=rev;
        rev=curr; 
        return reverse(temp, rev, B-1, old); // (5 4 2) (6 5 1) (7 6 0)
                                            //(11 10 2) (12 11 1) (null 12 0)
    }*/
    
    ListNode reverse(ListNode curr, ListNode rev, int B, ListNode old)
    {
        if(curr==null || B==0) {old.next = rev; return curr;}
        ListNode temp= curr.next;
        curr.next=rev;
        rev=curr; 
        return reverse(temp, rev, B-1, old); // (5 4 2) (6 5 1) (7 6 0)
                                            //(11 10 2) (12 11 1) (null 12 0)
    }
    
    public ListNode solve(ListNode A, int B) 
    {
        ListNode curr = A, old= new ListNode(0); boolean flag = false;
        old.next = curr;
        ListNode ans = old;
        
        while(curr!=null)
        {
            ListNode rev= null, temp=curr;  
            ListNode ahead = reverse(curr, rev, B, old);  //( null 3 3node)  (10 null 3 9)
            temp.next = ahead;
            curr= ahead;
            //if()
            
            for(int i=1; i<=B-1 && curr!=null; i++)
            curr=curr.next;
            
            old=curr; if(curr!=null)curr=curr.next;
            /*for(int i=1; i<=B-1 && curr!=null; i++)
            curr=curr.next;
        
            if(curr==null) return A;
            
            ListNode rev= null, temp=curr.next;  
            ListNode ahead = reverse(curr.next, rev, B, curr);  //(4 null 3 3node)  (10 null 3 9)
            temp.next = ahead;
            curr= ahead;*/
             
        } 
        return ans.next;
    }
}

//0 1<-2<-3 4->5->6 7 8 9

//1->2->3 4<-5<-6 7->8->9 10<-11<-12

// 



/*Node reverse(curr, rev)
{
    if(curr== null) return rev;
    temp= curr.next;
    curr.next=rev;
    rev=curr; 
    return reverse(temp, rev);
}
//1 2 3 4

Node reverse()
{
    if(curr.next==null) return curr;
    temp= reverse(curr.next);
    temp.next= curr;
    curr.next=null;
    //curr.next.next=curr;
    //curr=curr.next;
    return curr;
}

1)

while(curr)
{
    for(i=1 ;i<=B-1; i++)
    {
        
    }
    
    curr.next= reverse(curr.next);
    
}


2) */