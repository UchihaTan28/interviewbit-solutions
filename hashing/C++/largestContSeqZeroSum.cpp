vector<int> Solution::lszero(vector<int> &A) {
   /* vector <int> sum,B;
    unordered_map<int,int> m1,m2;
int max=0,max1=0,max2=0,n=A.size();
    unordered_map<int,int>:: iterator it;
m2[0]=-1;
    
    int i,j;
    sum.push_back(A[0]);
    
    for(i=1;i<n;i++)
    {
        sum.push_back(A[i]+sum.back());
    }
    
    for(i=0;i<n;i++)
    {
        if(!m1[sum[i]])m1[sum[i]]=i;//cout<<m1[sum[i]]<<"...";
    }
    //cout<<"\n";
     
    for(i=n-1;i>=0;i--)
    {
        if(!m2[sum[i]])m2[sum[i]]=i;//cout<<m2[sum[i]]<<",,,";
    }
    
     
    for(i=0;i<n;i++)
    {
        if(m2[sum[i]]-m1[sum[i]]>max){max=m2[sum[i]]-m1[sum[i]];max1=m1[sum[i]];max2=m2[sum[i]];}//cout<<m1[sum[i]]<<"&&"<<m2[sum[i]];}
    }
 // cout<<max1<<" "<<max2<<" ";
 i=0;
  if(m2[0]+1>max){while(i++<=m2[0])B.push_back(A[max]);return B;}
  
   for(i=max1-1;i<=max2;i++)B.push_back(A[i]);
   
    return B;
   */ 
  /*  int n=A.size();
    long int s=0;
    bool flag=0;
    vector<long int > sum;
    for(int i=0;i<n;i++)
    {
        s+=A[i];
        sum.push_back(s);}
    
    map<long int, vector<int>> m;
    
    for(int i=0;i<n;i++)
    {
        m[sum[i]].push_back(i);
    }
    
    map<long int, vector<int>>::iterator it;
    
    int small,big;
    small=big=n-1;
    int max=INT_MIN;
    for(it=m.begin();it!=m.end();it++)
    {
        if((it->second).size()>1)
        { flag=1;
            if((it->second).back()-(it->second)[0]>=max)
            {
                max=(it->second).back()-(it->second)[0];
                small=(it->second)[0]; big=(it->second).back();
            }
            else if((it->second).back()-(it->second)[0]==max)
            {
                max=(it->second).back()-(it->second)[0];
                if((it->second)[0]<small)
                {small=(it->second)[0]; big=(it->second).back();}
            }
        }
    }
    vector<int>ans;
    for(int i=n-1;i>=0;i--)
    {
        if(sum[i]==0)
        {
            flag=1;
            if(i+1>=big-small){small=-1;big=i;}
        }
    }
    
    if(!flag)return ans;
    
    for(int i=small+1;i<=big;i++)ans.push_back(A[i]);
    return ans;
  */
  
  std::unordered_map<int, int> prefixSumMap;
    int maxLen = 0, start = 0, sum = 0;
    std::vector<int> result;

    for (int i = 0; i < A.size(); i++) {
        sum += A[i];

        if (sum == 0) {
            if (i + 1 > maxLen) {
                maxLen = i + 1;
                start = 0;
            }
        } else if (prefixSumMap.find(sum) != prefixSumMap.end()) {
            if (i - prefixSumMap[sum] > maxLen) {
                maxLen = i - prefixSumMap[sum];
                start = prefixSumMap[sum] + 1;
            }
        } else {
            prefixSumMap[sum] = i;
        }
    }

    for (int i = start; i < start + maxLen; i++) {
        result.push_back(A[i]);
    }

    return result;
}