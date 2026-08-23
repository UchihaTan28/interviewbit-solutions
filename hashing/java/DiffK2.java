public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int diffPossible(final int[] A, int B) {
        int n = A.length;
 
  // Use HashMap to store the numbers as keys and their indices as values
  HashMap<Integer, Integer> map = new HashMap<>();
  
  for (int i = 0; i < n; i++) {
         
   if (map.containsKey(A[i] - B) || map.containsKey(A[i] + B)) {

          // Return true if there exists a key for A[i]-B or A[i]+B
          return 1;
         }
   map.put(A[i], i);
     }

  // Return false if no relevant key is found
  return 0;
  }
  
}