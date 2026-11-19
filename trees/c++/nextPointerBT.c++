void Solution::connect(TreeLinkNode* A) {
      queue<TreeLinkNode*>q;
    q.push(A);
    TreeLinkNode* prev=NULL;
    while(!q.empty())
    {
        int n=q.size();
        for(int i=0;i<n;i++)
        {
            TreeLinkNode* temp=q.front();
            q.pop();
            
            if(q.empty()||/*prev&&prev->right==NULL||*/i==n-1)temp->next=NULL;
            else temp->next=q.front();
            
            if(temp->left)q.push(temp->left);
            if(temp->right)q.push(temp->right);
            prev=temp;
        }
    }
}