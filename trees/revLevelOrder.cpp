vector<int> Solution::solve(TreeNode* A) {
    
    
    vector<int >ans;
    if(A==NULL)return {};
    if(A->left==NULL&&A->right==NULL){ans.push_back(A->val);return ans;}
    queue<TreeNode*>q;
    q.push(A);
    
    while(!q.empty())
    {
        vector<int > v;
        int n=q.size();
        for(int i=1;i<=n;i++)
        {
           TreeNode* temp=q.front();q.pop();
           v.push_back(temp->val);
           if(temp->right)q.push(temp->right);
           if(temp->left)q.push(temp->left);
        }
        //reverse(v.begin(),v.end());
        for(int i=0;i<v.size();i++)ans.push_back(v[i]);
    }
    reverse(ans.begin(),ans.end());
    return ans;
    
    /*std::vector<int>result;
    if (A == NULL) return result;

    std::queue<TreeNode*>q;
    q.push(A);

     while (!q.empty()) {
        int size = q.size();
        vector<int> level;

        for (int i = 0; i < size; i++) {
            TreeNode *node = q.front();
            q.pop();

            level.push_back(node->val);

            if (node->left != NULL) {
                q.push(node->left);
            }
            if (node->right != NULL) {
                q.push(node->right);
            }
        }

        result.insert(result.begin(), level.begin(), level.end());
    }
    return result;*/
}
