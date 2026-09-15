void inorder2(TreeNode* A, int B, int *counter ,int *ans)
{
   if(A)
   {
       inorder2(A->left, B, counter, ans);
       if(*counter==B)*ans=A->val;
       (*counter)++;
       inorder2(A->right,B,counter,ans);
   }
}
void inorder3(TreeNode* A, int *B,int *ans)
{
   if(A)
   {
       inorder3(A->left, B, ans);
       if(*B==0)*ans=A->val;
       (*B)--;
       if(*B>=0)inorder3(A->right,B,ans);
   }
}

 void inorderTraversal(TreeNode* node, int k, int &count, int &result) {
        if (node == nullptr) {
            return;
        }

        inorderTraversal(node->left, k, count, result);

        count++;
        if (count == k) {
            result = node->val;
            return;
        }

        inorderTraversal(node->right, k, count, result);
    }


int kthSmallest(TreeNode* root, int& k) {
    if (root == nullptr)
        return -1; // Return error value if the tree is empty

    // First recur on the left subtree
    int result = kthSmallest(root->left, k);
    if (result != -1)
        return result;

    // If kth element not found in left subtree, check current node
    k--; // Decrement k as we are considering the current node
    if (k == 0)
        return root->val; // Current node is the kth smallest

    // If not found in left subtree and current node, recur on right subtree
    return kthSmallest(root->right, k);
}

int Solution::kthsmallest(TreeNode* A, int B) {
    
    //return kthSmallest(A, B);
/*int count = 0;
int result = -1;
inorderTraversal(A, B, count, result);
        return result; */

        
    
int i=0;
//int ar[100000];
//inorder(A,ar);
int ans=0,counter=1;
inorder2(A, B, &counter, &ans);
B--;
//inorder3(A, &B, &ans);
return ans;
    //return ar[B-1];
}