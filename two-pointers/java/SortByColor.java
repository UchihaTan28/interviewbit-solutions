public class Solution {
    public void swap(ArrayList<Integer> A, int i, int j)
    { int a=A.get(i), b=A.get(j);
        //a=a+b; b=a-b; a=a-b;
        A.set(i, b); A.set(j, a);
    }
    //{a=a+b;b=a-b;a=a-b;}
    public void sortColors(ArrayList<Integer> a) {
        int n=a.size();
        int low=0, mid=0, high= n-1;
        //swap(a, a.get(0), a.get(1));
        //System.out.println(a);
        while(mid<=high)
        {
            if(a.get(mid)==2){ swap(a, mid,high); high--;}
            else if(a.get(mid) == 0) {swap(a, mid, low); low++; mid++;}
            else mid++;
        }
        //return a;
    }
}