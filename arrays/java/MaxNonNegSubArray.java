public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        long maxsum=0, sum =0;
        int j=0, l=0,r=0;
        int n = A.size();
        for(int i=0;i<n;i++)
        {
            sum+=A.get(i);
            if(A.get(i)<0){sum=0;j=i+1;}
            else{
                if(maxsum<sum||maxsum==sum&&r-l<i-j){maxsum=sum; r=i;l=j;}
                //if(maxsum==sum&&r-l<i-j)
            }
        }
        if(A.get(r)<0)return ans;
        for(int i=l;i<=r;i++)ans.add(A.get(i));
        return ans;
        
        /*ArrayList<Integer> ans= new ArrayList<Integer>();
        
        int i=0,j=0,l=0,r=0, n=A.size();
        long maxsum=Integer.MIN_VALUE, sum=0;
        
        for(j=0; j<n;j++)
        {
            sum+=A.get(j);
            if(A.get(j)<0){sum=0;i=j+1;}
            else{
                //if(sum==maxsum&&r-l<j-i){l=i;r=j;} 
                if(sum==maxsum&&r-l<j-i||sum>maxsum){
                    r=j; l=i;maxsum=sum;
                }
            }
        }
        if(A.get(r)<0)return ans;
        for(i=l;i<=r;i++)ans.add(A.get(i));
        return ans;*/
    }
}