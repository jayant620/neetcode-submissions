class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(dfs(board, word, r, c, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int wordIndex){
        // SUCCESS BASE CASE: We successfully matched every letter in the word!
        if(wordIndex == word.length()){
            return true;
        }
        // FAILURE BASE CASES: 
        // 1. Out of bounds vertically
        // 2. Out of bounds horizontally
        // 3. Current letter doesn't match the target letter (or it's our '#' marker)
        if(row<0 || col <0 || row >= board.length || col >= board[0].length
        || board[row][col] != word.charAt(wordIndex)){
            return false;
        }
        // --- THE BACKTRACKING ENGINE ---

        // CHOOSE: Mark the current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(board, word, row + 1, col, wordIndex+1)
                     || dfs(board, word, row - 1, col, wordIndex+1)
                     || dfs(board, word, row, col+1, wordIndex+1)
                     || dfs(board, word, row, col+1, wordIndex+1)
                     || dfs(board, word, row, col-1, wordIndex+1);
        // UN-CHOOSE: Restore the original letter so other branches can use it later
        board[row][col] = temp;

        return found;
    }
}
