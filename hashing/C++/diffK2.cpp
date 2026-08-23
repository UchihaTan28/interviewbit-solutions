int Solution::diffPossible(const vector<int> &A, int B) {
    unordered_map<int,int>m;
    
    int n=A.size();
    if(n==1)return 0;
    
    for(int j=0;j<n;j++)
    {
        if(m[A[j]-B]||m[A[j]+B])return 1;
        m[A[j]]++;
    }
    return 0;
   /* 
   for(int i=0;i<n;i++){
       m[A[i]]++;
   }
   unordered_map<int,int>::iterator it;
   
   if(B==0){for(it=m.begin();it!=m.end();it++)if(m[(it->first)]>1)return 1;
   return 0;}
   
       for(it=m.begin();it!=m.end();it++)if(m[(it->first)+B])return 1;
   
   return 0;*/
 
}