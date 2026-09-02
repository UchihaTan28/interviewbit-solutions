vector<int> Solution::twoSum(const vector<int> &A, int B) {
   vector<int>ans;
    unordered_map<int,int>m;
    int i=0, n =A.size();
    
    for( i=0;i<n;i++)
    {
        if(m[B-A[i]])break;
        if(!m[A[i]])m[A[i]]=i+1;
    }
    if(i != n) ans= { m[B-A[i]],i+1};
    return ans;
}