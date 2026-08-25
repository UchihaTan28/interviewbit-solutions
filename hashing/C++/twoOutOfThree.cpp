vector<int>ans;
    map<int,int>m;
    unordered_set<int>s;
    for(int i=0;i <A.size();i++)m[A[i]]=1;
    
    for(int i=0;i <B.size();i++)s.insert(B[i]);
    
    for(auto it: s)m[it]++; 
    
    s.clear();
    for(int i=0;i <C.size();i++)s.insert(C[i]);
    
    for(auto it: s)m[it]++; 
    
    for(auto it : m)
    {
        if(it.second >=2)ans.push_back(it.first);
    }
    return ans;
