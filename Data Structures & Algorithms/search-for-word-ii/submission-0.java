class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node){
        if(r<0 || c<0 || r>=board.length || c>= board[0].length){
            return;
        }
        // visited OR prefix not found
        char ch = board[r][c];
        if(ch=='#' || node.children[ch - 'a']==null){
            return;
        }

        node = node.children[ch - 'a'];
        if(node.word != null){
            result.add(node.word);
            node.word=null; //avoid duplicates
        }

        board[r][c] = '#';//mark visited
        dfs(board, r+1, c, node);
        dfs(board, r-1, c, node);
        dfs(board, r, c+1, node);
        dfs(board, r, c-1, node);

        board[r][c] = ch; //unmark visited

    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode curr = root;
            for(char ch: word.toCharArray()){
                int index = ch - 'a';
                if(curr.children[index]== null){
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.word = word;
        }
        return root;
    }
}
