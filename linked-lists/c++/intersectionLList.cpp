/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
int length(ListNode *A){
    int c=0;
    if(A==NULL)return 0;
    while(A!=NULL){A=A->next;c++;}
    return c;
} 
ListNode* Solution::getIntersectionNode(ListNode* A, ListNode* B) {
 ListNode* temp1=A;
    ListNode* temp2=B;
    while(temp1!=temp2){
        if(temp1==NULL){
            temp1=B;
        }
        else{
            temp1=temp1->next;
        }
        if(temp2==NULL){
            temp2=A;
        }
        else{
            temp2=temp2->next;
        }
    }
    return temp2;

}