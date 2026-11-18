TreeNode* Solution::flatten(TreeNode* A) {
    if(A==NULL)
return NULL;
TreeNode* left = flatten(A->left);
TreeNode* right= flatten(A->right);
TreeNode* temp = A->right;
A->right = A->left;
A->left = NULL;
TreeNode* temp2 = A;
while(temp2->right)
{
temp2=temp2->right;
}
temp2->right = temp;
return A;
}