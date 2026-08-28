string Solution::fractionToDecimal(int a, int b) {
    
    unordered_map<long long int,long long int>m;
    signed long long int actualA=a,actualB=b;
   long long int A=abs(actualA);long long int B=abs(actualB);
    
 //   if((A/B)>=INT_MAX)return to_string(A);
    
    string str=to_string(A/B)+".";
    if(A%B==0)
    {   
        if(actualA>=0&&actualB>=0||actualA<=0&&actualB<=0){
            
            //if((to_string(A/B))[0]=='-')(to_string(A/B)).erase((to_string(A/B)).begin());
            return to_string(A/B);
            
        }
        else {return "-"+to_string(A/B);}
    }
    long long int quotient=(A%B)*10;
    
    long long int i=1;
    string rep=""; 
    while(quotient&&(m[quotient]==0))
    {   
        
        rep+=to_string(quotient/B);
        m[quotient]=i;
        quotient=(quotient%B)*10;
        i++;
    }
    
    if(!quotient)
    {
        if(actualA>=0&&actualB>=0||actualA<=0&&actualB<=0){return str+rep;}
        else return "-"+str+rep;
        
    }
    
    //string nonrep=rep.substr(rep.begin(),i);
    rep.insert(m[quotient]-1,"(");
    
    if(actualA>=0&&actualB>=0||actualA<=0&&actualB<=0)return str+rep+")";
    else return "-"+str+rep+")";
      
}