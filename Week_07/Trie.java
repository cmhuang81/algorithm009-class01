class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.contains(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(node.contains(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }
        return null != node && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(node.contains(c)) {
                node = node.get(c);
            } else {
                return false;
            }
        }
        return null != node;
    }
}

class TrieNode {
    private TrieNode[] links;
    private static final int R = 26;
    private boolean isEnd = false;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put (char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}