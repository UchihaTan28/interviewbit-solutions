public class Solution {
    private long sumRTL(TreeNode A, long sum)
    {
        if(A.left==null && A.right==null) return (sum*10+ A.val)%1003;

        long left = 0L, right = 0L;
        if(A.left!=null) left = sumRTL(A.left, (sum*10 + A.val)%1003);
        if(A.right!=null) right = sumRTL(A.right, (sum*10 + A.val)%1003);
        
        return (left + right)%1003;
    }
    public int sumNumbers(TreeNode A) {
        return (int)sumRTL(A, 0L);
    }
}