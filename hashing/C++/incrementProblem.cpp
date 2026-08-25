vector<int> Solution::solve(vector<int> &A) {
    unordered_map<int,priority_queue<int,vector<int>, greater<int>>>M;
    int n= A.size();
    for(int i=0;i<n;i++){
       if(M[A[i]].size()==0)M[A[i]].push(i);
       else 
       {   int index =M[A[i]].top();
           A[index]++;
           M[A[i]+1].push(index);
           M[A[i]].pop();
           M[A[i]].push(i);
       }   
    }
    return A;
}