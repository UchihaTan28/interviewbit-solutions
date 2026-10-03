public class Solution {
    public int maxArea(int[] A) {
        int n = A.length;
        int i=0, j= n-1;
        int maxWater = 0;
        
        while(i<j)
        {
            maxWater = Math.max(maxWater, (j-i)* Math.min(A[i], A[j]));
            if(A[i] < A[j]) i++;
            else j--;
        }
        return maxWater;
    }
}
