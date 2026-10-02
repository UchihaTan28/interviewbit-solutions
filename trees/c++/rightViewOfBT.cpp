vector<int> Solution::solve(TreeNode* A) {
    
    queue<TreeNode* >q;
    q.push(A);
    vector<int >ans;
    if(A==NULL)return ans;
    if(!A->left&&!A->right){ans.push_back(A->val);return ans;}
    while(!q.empty())
    {
        int n=q.size();
        vector<int >v;
        for(int i=0;i<n;i++)
        {
            TreeNode* temp=q.front();
            q.pop();
            v.push_back(temp->val);
            if(temp->left)q.push(temp->left);
            if(temp->right)q.push(temp->right);
        }
        ans.push_back(v.back());
    }
    return ans;
}