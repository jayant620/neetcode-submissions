class Solution {
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];
        return dfs(0, 1, prices);
    }

    private int dfs(int i, int buying, int[] prices){
        if(i>=prices.length) return 0;

        if(memo[i][buying] != null) return memo[i][buying];
        int ans;
        if(buying==1){
            int buy = -prices[i] + dfs(i+1, 0, prices);
            int skip = dfs(i+1, 1, prices);
            ans = Math.max(buy, skip);
        } else{
            int sell = prices[i] + dfs(i+2, 1, prices);
            int hold = dfs(i+1, 0, prices);
            ans = Math.max(sell, hold);
        }
        memo[i][buying] = ans;
        return ans;
    }
}
