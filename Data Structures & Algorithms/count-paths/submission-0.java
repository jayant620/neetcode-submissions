class Solution {
    Integer[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new Integer[m][n];
        return dfs(0,0,m,n);
    }

    private int dfs(int r, int c, int m, int n){
        if(r==m-1 && c==n-1) return 1;

        if(r>=m || c>=n) return 0;
        if(memo[r][c] != null) return memo[r][c];

        memo[r][c] = dfs(r+1, c, m, n) + dfs(r, c+1, m, n);
        return memo[r][c];
    }
}
