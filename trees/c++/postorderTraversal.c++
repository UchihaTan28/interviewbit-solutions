vector<int> Solution::postorderTraversal(TreeNode* root) {
    
    vector<int> res;
    stack<TreeNode*> mystack;
    TreeNode *prev=NULL;

    if(!root) return res;
    mystack.push(root);

    while(!mystack.empty()){
        TreeNode *curr = mystack.top();

        if( (!curr->left && !curr->right) || (prev && (prev==curr->left || prev==curr->right)) ){
            res.push_back(curr->val);
            mystack.pop();
            prev=curr;
        }
        else{
            if(curr->right) mystack.push(curr->right);
            if(curr->left) mystack.push(curr->left);
        }
    }
    return res;
}