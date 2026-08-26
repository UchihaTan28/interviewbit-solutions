vector<int> Solution::findSubstring(string A, const vector<string> &B) {
    unordered_map<string,int> m;
  if(B.empty())return {};
  vector<int> v;
  int l=B[0].length();
  //string s="abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa";
 // cout<<s.length();
 // return {};
    int count=0,i;

    for(i=0;i<A.length();i++)
    {
            for(int j=0;j<B.size();j++)m[B[j]]++;
    
        
        string str=A.substr(i,l);
        int save=i;
        while(m[str]&&count<B.size())
        {
            count++;
            i+=l; 
            m[str]--;
            str=A.substr(i,l);
        }
        
        if(count==B.size())v.push_back(save);
        
        count=0;
        i=save;
        m.clear();
        
    }
    return v;
}