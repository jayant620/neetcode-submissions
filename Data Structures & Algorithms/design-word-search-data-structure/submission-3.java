class WordDictionary {

    class TrieNode{
        TrieNode[] children;
        boolean isWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord=false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index]==null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isWord=true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    private boolean dfs(int index, String word, TrieNode node){
        if(index==word.length()){
            return node.isWord;
        }
        char ch = word.charAt(index);
        if(ch != '.'){
            int childIndex = ch - 'a';
            if(node.children[childIndex]==null){
                return false;
            } else{
                return dfs(index+1, word, node.children[childIndex]);
            }
        } else { //wildcard
            for(TrieNode child: node.children){
                if(child != null && dfs(index+1, word, child)){
                    return true;
                }
            }
            return false;
        }
    }
}
