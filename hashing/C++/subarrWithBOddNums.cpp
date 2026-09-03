vector<int>v;
    //return 0;
    int n=A.size(), odds=0,ans=0;
    for(int i=0;i<n;i++){
        if(A[i]%2)v.push_back(++odds);
        else v.push_back(odds);
        if(v[i]==B)ans++;
    }
    //if(n==1)return v[0]==B?1:0;
    if(odds==0&&B==0)return (n*(n+1))/2;
    int i=1,j=0;
    //if(v[0]==B)ans++;
    while(i<n&&j<n){
        if(v[i]-v[j]==B){
            int jtemp=v[j], itemp=v[i], jvals=0,ivals=0; 
            while(v[j]==jtemp&&j<n){jvals++;j++;}
            while(v[i]==itemp&&i<n){ivals++;i++;}
            ans+=jvals*ivals;
        }
       else if(v[i]-v[j]<B)i++;
       else if(v[i]-v[j]>B)j++;
       if(i==j)i++;
    }
    return ans;