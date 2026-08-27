public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        
        int n=A.size();
        ArrayList<Integer> pre= new ArrayList<Integer>();
        HashMap<Integer, Integer> M= new HashMap<Integer, Integer>();
        
        int odds=0; int ans=0;
        M.put(0,1);
        for(int i=0;i<n;i++)
        {
            if(A.get(i)%2==1)odds++;
            ans+=M.getOrDefault(odds-B, 0);
            M.put(odds, M.getOrDefault(odds, 0)+1);
            //ans+=(M.containsKey(odds-B)==false?0:M.get(odds-B));
            //M.put(odds, ((M.containsKey(odds)==false)?1:M.get(odds)+1));
        }
        return ans;




        
        /*for(int i=0;i<n;i++)
        {
            if(A.get(i)%2==1)odds++;
            pre.add(odds);
        }
        
        for(int i=0;i<n;i++)
        {
            if(M.containsKey(pre.get(i))==false)M.put(pre.get(i),1);
            else M.put(pre.get(i), M.get(pre.get(i))+1);
        }
        if(M.containsKey(0)==false)M.put(0,1);
        if(pre.get(n-1)<B)return 0;
        if(B==0)
        {
            if(pre.get(n-1)==0)return (M.get(0)*(M.get(0)+1))/2;
            for(int i=0;i<=pre.get(n-1);i++)
          {
            int val=M.get(i);
            if(val>1)ans+=(val*(val-1))/2;
          } return ans+(pre.get(0)==0?1:0);
        } 
        
        for(int i=0;i<=pre.get(n-1)-B;i++)
        {
            int first= B==1?1:M.get(i);
            int second= M.get(i+B);
            ans+=first*second;
        } 
        return ans+(pre.get(0)==0?M.get(B):0);*/
        /*int temp1=-1;
        int n=A.size();
        int i=temp1+1, ans=0;
        
        if(B==0)
        { int temp=0;
            for(int t=0;t<n;t++)
            {
                while(t<n&&A.get(t)%2==0){t++;temp++;}
                ans+=Math.pow(2, temp)-1;
                temp=0;
            }
            return ans;
        }
        
        while(i<n&&(A.get(i)%2==0))i++;
        int j=i; int odds=0;
        // System.out.println("0");
        while(j<n&&odds!=B)
        {
             //System.out.println("0.5");
            if(A.get(j)%2==1)odds++; j++;
        }
        int temp2=j;//if(j<n&&A.get(j)%2==0)
        //if(j!=i)
        j--;//1
        if(odds<B)return 0;
        if(j>=n){ return 1;}
        while(temp2<n&&A.get(temp2)%2==0)temp2++;
        ans+=(i-temp1)*(temp2-j);
        
        //System.out.println("1");
        j=temp2; temp1=i;
        while(temp2<n)
        {
            temp2++; i=temp1+1;
            //System.out.println("2");
            while(i<n&&A.get(i)%2==0)i++;
            while(temp2<n&&A.get(temp2)%2==0)temp2++;
            ans+=(i-temp1)*(temp2-j);
            j=temp2; temp1=i;
        }   
    return ans;*/
    }
}