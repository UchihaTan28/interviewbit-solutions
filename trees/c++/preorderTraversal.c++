vector<int> Solution::preorderTraversal(TreeNode* A) {
    
    vector<int> ans;
    stack<TreeNode*>s;
    s.push(A);
    
    while(!s.empty())
    {
        TreeNode* temp=s.top();
        s.pop();
        ans.push_back(temp->val);
        if(temp->right)s.push(temp->right);
        if(temp->left)s.push(temp->left);
        
    }
    return ans;
}