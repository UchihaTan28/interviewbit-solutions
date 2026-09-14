public class Solution {
    public int solve(int[] A) {
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(A[0]);
        int minLeft = Integer.MIN_VALUE, n = A.length;
        int root = Integer.MAX_VALUE;
        
        for(int i=1; i < n; i++)
        {
            int top = stk.peek();
            if(A[i] == top || A[i] <= minLeft) return 0;
            
            if( A[i] < top ){ }
            else
            {
                while(stk.isEmpty() == false && A[i] > stk.peek())
                {
                    root = stk.pop();
                }
                minLeft = root;
            }   
            stk.push(A[i]);
        }
        return 1;
    }
}