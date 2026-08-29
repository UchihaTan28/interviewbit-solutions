public class Solution {

        public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
         ArrayList<ArrayList<Integer>> res = new ArrayList<>();
         
         HashMap<String, ArrayList<Integer>> m = new HashMap<>();
        for(int i = 0;i<A.size();i++) 
        {
            String s = A.get(i);
             s = sortString(s);
             if(!m.containsKey(s)) {
                 m.put(s, new ArrayList<Integer>()); 
             }
             m.get(s).add(i+1);
        }
        
        for(ArrayList<Integer> x : m.values()) {
            res.add(x);
        }
        
        return res;
    }
    
    public static String sortString(String inputString)
    {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();
 
        // Sorting temp array using
        Arrays.sort(tempArray);
 
        // Returning new sorted string
        return new String(tempArray);
    }
}

        /*int n=A.size();
        HashMap<String, ArrayList<Integer>> M= new HashMap<>();
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            String s= A.get(i);
            //Collections.sort(s);
            char tempArray[]= s.toCharArray();
            Arrays.sort(tempArray);
            s= new String(tempArray);
            if(M.containsKey(s)==false)M.put(s, new ArrayList<Integer>());
            M.get(s).add(i+1);
        }
        
        for(int i=0;i<n;i++)
        {
            String s= A.get(i);
            //Collections.sort(s);
            char tempArray[]= s.toCharArray();
            Arrays.sort(tempArray);
            s= new String(tempArray);
            if(M.containsKey(s)==true)
            {
                ans.add(M.get(s));
                M.remove(s);
            }
        }
        return ans;
    }*/