public class Solution {
    private HashSet<Integer> vis = new HashSet<Integer>();
    private int ans = 0;

    void constructTree(HashMap<Integer, ArrayList<Integer>> tree, ArrayList<ArrayList<Integer>> B) {
        for (ArrayList<Integer> pair : B) {
            int u = pair.get(0);
            int v = pair.get(1);

            if (!tree.containsKey(u)) tree.put(u, new ArrayList<Integer>());
            if (!tree.containsKey(v)) tree.put(v, new ArrayList<Integer>());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }
    }

    int dfs(HashMap<Integer, ArrayList<Integer>> tree, int node) {
        vis.add(node);

        int size = 1; // count current node

        for (int child : tree.get(node)) {
            if (!vis.contains(child)) {
                int childSize = dfs(tree, child);

                if (childSize % 2 == 0) {
                    ans++;   // remove edge between node and child
                } else {
                    size += childSize;
                }
            }
        }

        return size;
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<Integer, ArrayList<Integer>>();
        constructTree(tree, B);

        dfs(tree, 1);   // tree is connected, start anywhere

        return ans;
    }
}