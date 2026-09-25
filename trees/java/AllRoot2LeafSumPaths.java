public class Solution {
    private void paths(ArrayList<Integer> v, ArrayList<ArrayList<Integer>> V, TreeNode A, int sum)
    {
        if(A == null)return;
        v.add(A.val); sum-=A.val;
        
        if(A.left== null && A.right==null)
        {
            if(sum == 0)V.add(new ArrayList<>(v)); 
            //return;
        }
        
        paths(v, V, A.left, sum);
        paths(v, V, A.right, sum);
        v.remove(v.size()-1); //sum+=A.val;
    }
    
    private void allPaths(ArrayList<Integer> v, ArrayList<ArrayList<Integer>> V, TreeNode A, int B)
    {
        if(A == null) return;
        v.add(A.val);
        B-=A.val;
        if(A.left==null && A.right==null) 
        {
            if(B==0) V.add(new ArrayList<Integer>(v)); 
            //return;
        }
        
        if(A.left!=null) allPaths(v, V, A.left, B);
        if(A.right!=null) allPaths(v, V, A.right, B);
        v.remove(v.size()-1);
    }
    
    private ArrayList<ArrayList<Integer>> allSumPaths(TreeNode A, int B, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans)
    {
        B-= A.val;
        curr.add(A.val);
        if(A.left==null && A.right==null)
        {
            if(B==0) { ans.add(new ArrayList<Integer>(curr));}
        }
        
        ArrayList<ArrayList<Integer>> left = null, right = null;
        if(A.left!=null) left = allSumPaths(A.left, B, curr, ans);
        if(A.right!=null) right = allSumPaths(A.right, B, curr, ans);
        
        curr.remove(curr.size()-1);
        return ans;
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        
        ArrayList<Integer> curr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        return allSumPaths(A, B, curr, ans);
        
        /*ArrayList<Integer> v = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> V = new ArrayList<ArrayList<Integer>>();
        if(A ==null && B ==0) return V;
        
        allPaths(v, V, A, B);
        return V;*/
        
        /*ArrayList<Integer> v= new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> V= new ArrayList<ArrayList<Integer>>();
        paths(v, V, A, B);
        return V;*/
    }
}