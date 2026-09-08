vector<int> Solution::equal(vector<int> &A) {
    unordered_map<int,vector<pair<int,int>>>m;
    int n=A.size();

    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(((m[A[i]+A[j]]).size())==0)m[A[i]+A[j]].push_back(make_pair(i,j));
            else 
            {
                //if((*(m[A[i]+A[j]].begin())).first<i&&(*(m[A[i]+A[j]].begin())).second!=i&&(*(m[A[i]+A[j]].begin())).second!=j)
                if(m[A[i]+A[j]][0].first<i&&m[A[i]+A[j]][0].second!=i&&m[A[i]+A[j]][0].second!=j)
                m[A[i]+A[j]].push_back(make_pair(i,j));
            }
        }
    }
    
    vector<vector<pair<int,int>>>V;
    for(auto it:m){
        if(it.second.size()>=2){
           vector<pair<int,int>>v;
           //v.push_back(it.second[0].first);v.push_back(it.second[0].second);v.push_back(it.second[1].first);v.push_back(it.second[1].second);
           //sort(v.begin(),v.end());
           v.push_back(it.second[0]); v.push_back(it.second[1]);
           V.push_back(v);
        }
    }
   
    sort(V.begin(),V.end());
    vector<int >ans;
    if(V.size()>0){ans.push_back(V[0][0].first);
    ans.push_back(V[0][0].second);
    ans.push_back(V[0][1].first);
    ans.push_back(V[0][1].second);
    //sort(ans.begin(), ans.end());    
    }
    return ans;
}