#include<bits/stdc++.h>
struct hashFunction 
{
  size_t operator()(const vector<int> 
                    &myVector) const 
  {
    std::hash<int> hasher;
    size_t answer = 0;
      
    for (int i : myVector) 
    {
      answer ^= hasher(i) + 0x9e3779b9 + 
                (answer << 6) + (answer >> 2);
    }
    return answer;
  }
};
vector<vector<int> > Solution::fourSum(vector<int> &A, int B) {
    
    vector<vector<int> > ans;
    //unordered_set<vector<int>, hashFunction>s;
    set<vector<int>>s;
    //sort(A.begin(), A.end());
    int n = A.size();
    
    unordered_map<int, vector<pair<int,int>>> M;
    
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            M[A[i]+A[j]].push_back(make_pair(i,j));
        }
    }
    
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            for(int a= 0; a<M[B-A[i]-A[j]].size();a++){
                if(M[B-A[i]-A[j]][a].first==i||M[B-A[i]-A[j]][a].second==j || M[B-A[i]-A[j]][a].first==j||M[B-A[i]-A[j]][a].second==i ){}
                else {
                    vector<int>v = {A[i], A[j], A[M[B-A[i]-A[j]][a].first], A[M[B-A[i]-A[j]][a].second]};
                    sort(v.begin(),v.end());
                    s.insert(v);
                }
            }
            
        }
    }
    
    for(auto i:s)ans.push_back(i);
    
    sort(ans.begin(),ans.end());
    return ans;
}