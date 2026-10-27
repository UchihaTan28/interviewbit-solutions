public class Solution {
    class TrieNode
    {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean endOfWord;
        TrieNode(){ endOfWord = false;}    
    }
    
    void insert(TrieNode root, ArrayList<String> A)
    {
        for(String word: A)
        {
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++)
            {
                Character ch = new Character(word.charAt(i)); //1
                if(curr.children.containsKey(ch) == false)
                curr.children.put(ch, new TrieNode());
                
                curr = curr.children.get(ch);
            }
            curr.endOfWord = true;
        }
    }
    
    void traverse(TrieNode curr, HashMap<String, String> storage, String s, String maintained)
    {
        if(curr.endOfWord == true) storage.put(s, maintained);
        for(Map.Entry<Character, TrieNode> m: curr.children.entrySet())
        {
            s+=m.getKey();
            if(curr.children.size() == 1) {
                //if(curr.endOfWord == true) storage.put(s, maintained); //remove
            }
            else 
            {
                maintained = s;
                //if(curr.endOfWord == true) storage.put(s, maintained);  
            }
            traverse(m.getValue(), storage, s ,maintained);
            s = s.substring(0, s.length()-1);
        }
        return;
    }
    
    public ArrayList<String> prefix(ArrayList<String> A) {
        HashMap<String, String> storage = new HashMap<String, String>();
        //for(String a: A) storage.put(a, "");
        
        ArrayList<String> ans = new ArrayList<String>();
        TrieNode root = new TrieNode();
        insert(root, A);
        traverse(root, storage, new String(""), new String(""));
        
        for(String a: A) ans.add(storage.get(a));
        return ans;
    }
}