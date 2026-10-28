public class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private void insert(TrieNode root, int num) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null)
                curr.children[bit] = new TrieNode();
            curr = curr.children[bit];
        }
    }

    private int findMaxXor(TrieNode root, int num) {
        TrieNode curr = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = bit ^ 1;
            if (curr.children[opposite] != null) {
                xor |= (1 << i);
                curr = curr.children[opposite];
            } else {
                curr = curr.children[bit];
            }
        }
        return xor;
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        TrieNode root = new TrieNode();
        for (int num : A) insert(root, num);

        int max = 0;
        for (int num : B) {
            max = Math.max(max, findMaxXor(root, num));
        }
        return max;
    }
}