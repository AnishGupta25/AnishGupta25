public class feb2 {
    class Trie {
    
        class Node{
            Node[] child;
            boolean isEnd;
            Node(){
                child = new Node[26];
                isEnd = false;
            }
        }
        
        Node root;
    
        public Trie() {
            root = new Node();
        }
        
        public void insert(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(cur.child[ch - 'a'] == null) cur.child[ch - 'a'] = new Node();
                cur = cur.child[ch - 'a'];
            }
            cur.isEnd = true;
        }
        
        public boolean search(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(cur.child[ch - 'a'] == null) return false;
                cur = cur.child[ch - 'a'];
            }
            return cur.isEnd;
        }
        
        public boolean startsWith(String prefix) {
            Node cur = root;
            for(int i = 0; i < prefix.length(); i++){
                char ch = prefix.charAt(i);
                if(cur.child[ch - 'a'] == null) return false;
                cur = cur.child[ch - 'a'];
            }
            return true;
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        int n = s.length();
        int m = p.length();
        if (n < m)
            return list;
        int[] pAlphas = new int[26];
        for (char c : p.toCharArray()) {
            pAlphas[c - 'a']++;
        }
        int[] sAlphas = new int[26];
        for (int i = 0; i < m; i++) {
            sAlphas[s.charAt(i) - 'a']++;
        }
        if (compareAlphaList(pAlphas, sAlphas))
            list.add(0);
        for (int i = m; i < n; i++) {
            sAlphas[s.charAt(i - m) - 'a']--;

            char c = s.charAt(i);
            sAlphas[c - 'a']++;
            if (compareAlphaList(sAlphas, pAlphas))
                list.add(i - m + 1);
        }
        return list;
    }

    private boolean compareAlphaList(int[] a, int[] b) {
        for (int i = 0; i < 26; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }
    
}
