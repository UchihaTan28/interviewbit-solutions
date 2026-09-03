unordered_map<char,int> m;
    int j=0,i=0, n =A.size(), ans=0;
    
    for(int i=0;i<n;i++){
        if(!m[A[i]]){}
        else j=max(j,m[A[i]]); 
        
        m[A[i]]=i+1;
        ans= max(ans, i-j+1);
    } 
    return ans; 