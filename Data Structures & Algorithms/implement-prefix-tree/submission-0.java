class PrefixTree {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode(){
            this.children=new TrieNode[26];
            isWord=false;
        }
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }
        curr.isWord=true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index]==null){
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch: prefix.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index]==null){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}
