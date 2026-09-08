vector<vector<int> > Solution::anagrams(const vector<string> &A) {

   unordered_map<string, vector<int> > m;
   vector<string> B;
   vector<vector<int>> v;
   int i=0;
   string temp="";
   
   for(i=0;i<A.size();i++)
   { temp="";
       temp.append(A[i]);
       sort(temp.begin(),temp.end());
       B.push_back(temp);
       
       
   }
   
   
   for(i=0;i<B.size();i++)
   m[B[i]].push_back(i+1);
   
   for(auto it:m)
   {
       v.push_back(it.second);
   }
   return v;
}