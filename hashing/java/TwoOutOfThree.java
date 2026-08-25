public class Solution {
    public int[] solve(int[] A, int[] B, int[] C) {
        
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        HashSet<Integer> setC = new HashSet<>();
        HashSet<Integer> common = new HashSet<>();

        // Populate the sets with unique elements from each array
        for (int num : A) setA.add(num);
        for (int num : B) setB.add(num);
        for (int num : C) setC.add(num);

        // Check for elements common to at least two sets
        for (int num : setA) {
            if (setB.contains(num) || setC.contains(num)) {
                common.add(num);
            }
        }
        for (int num : setB) {
            if (setC.contains(num)) {
                common.add(num); // No need to check setA again
            }
        }

        // Sort the common elements
        ArrayList<Integer> sortedCommon = new ArrayList<>(common);
        Collections.sort(sortedCommon);
        
        /*HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        HashSet<Integer> setC = new HashSet<>();
        ArrayList<Integer> common = new ArrayList<>();
 
        // Store elements of array A in the setA
        for (int i : A) setA.add(i);
        for (int i : B) setB.add(i);
        for (int i : C) setC.add(i);
        
        
        // Check for elements common to at least 2 arrays
        for (int num: setA) {
            if(setB.contains(num) || setC.contains(num)){
                common.add(num);
            }
        }
       
        // No need to check setA again
        for (int num : setB) {
            if(setC.contains(num)){
                common.add(num);
           }
        }
     
        Collections.sort(common);*/
        
        int[] a= new int[sortedCommon.size()];
        //System.out.println(result.get(0));
        for(int i=0;i<sortedCommon.size();i++){a[i]=sortedCommon.get(i);}
        return a;/*
        
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        HashSet<Integer> setC = new HashSet<>();
        ArrayList<Integer> common = new ArrayList<>();
 
        // Store elements of array A in the setA
        for (int i : A) {
            setA.add(i);
        }
        
        // Store elements of array B in the setB and check for common elements
        for (int i : B) {
            setB.add(i);
            if(setA.contains(i)){
                common.add(i);
            }
        }
       
        // Store elements of array C in the setC and check for common elements
        for (int i : C) {
            setC.add(i);
            if(setB.contains(i)){
                common.add(i);
            }else if(setA.contains(i)){
                common.add(i);
            }
        }
        
        // Add elements that are present in setC and not in setA and setB.
        for(int item:setC){
           if(!setA.contains(item) && !setB.contains(item) ){
                common.add(item);
            } 
        }
       
        
        Collections.sort(common);
        //return common; 
         // Sort the list
         int[] a= new int[common.size()];
        //System.out.println(result.get(0));
        for(int i=0;i<common.size();i++){a[i]=common.get(i);}
        return a;*/
    }
}