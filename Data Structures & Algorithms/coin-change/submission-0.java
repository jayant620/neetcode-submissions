class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        int res = dfs(amount, coins);
        return res==Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int rem, int[] coins){
        if(rem==0) return 0;
        if(rem <0) return Integer.MAX_VALUE;

        if(memo[rem] != 0) return memo[rem];

        int result = Integer.MAX_VALUE;
        for(int coin: coins){
            int sub = dfs(rem-coin, coins);

            if(sub != Integer.MAX_VALUE){
                result = Math.min(result, 1 + sub);
            }
        }
        memo[rem]=result;
        return result;
    }
}
