class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length+1][amount+1];
        return dfs(0, amount, coins);
    }
    private int dfs(int i, int remaining, int[] coins){
        if(remaining==0) return 1;
        if(remaining<0) return 0;
        if(i>=coins.length) return 0;

        if(dp[i][remaining] != null) return dp[i][remaining];

        int take = dfs(i, remaining-coins[i], coins);
        int skip = dfs(i+1, remaining, coins);

        dp[i][remaining] = take + skip;
        return dp[i][remaining];
    }
}
