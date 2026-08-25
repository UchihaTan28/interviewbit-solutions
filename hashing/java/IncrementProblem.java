public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n=A.size();
        HashMap<Integer, PriorityQueue<Integer>> M= new HashMap<Integer, PriorityQueue<Integer>>();
        
        for(int i=0;i<n;i++)
        {
            if(M.containsKey(A.get(i))==true)
            {
                int temp=M.get(A.get(i)).remove();
                A.set(temp, A.get(i)+1);
                //if(M.containsKey(A.get(i)+1)==false){M.put(A.get(i)+1, new PriorityQueue<Integer>());}
                //M.get(A.get(i)+1).add(temp);   slower
                if(M.containsKey(A.get(i)+1)==true)M.get(A.get(i)+1).add(temp);
                else {M.put(A.get(i)+1, new PriorityQueue<Integer>());M.get(A.get(i)+1).add(temp);}
                //faster
            }
            else M.put(A.get(i), new PriorityQueue<Integer>());
            M.get(A.get(i)).add(i);
        }
        return A;
    }
}