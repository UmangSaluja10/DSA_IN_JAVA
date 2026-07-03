class WordDictionary {
    
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chars, int k, TrieNode node) {
        if (k == chars.length) {
            return node.isWord;
        }
        
        char c = chars[k];
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && match(chars, k + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            int index = c - 'a';
            return node.children[index] != null && match(chars, k + 1, node.children[index]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */