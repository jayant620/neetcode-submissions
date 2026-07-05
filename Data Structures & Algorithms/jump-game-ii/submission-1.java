class Solution {
    Integer[] dp;
    public int jump(int[] nums) {
        dp = new Integer[nums.length];
        return dfs(0, nums);
    }

    private int dfs(int i, int[] nums){
        if(i>=nums.length-1){
            return 0;
        }
        if(dp[i] != null) return dp[i];

        int ans = Integer.MAX_VALUE;

        for(int jump=1;jump<=nums[i];jump++){
            int sub = dfs(i+jump, nums);
            if(sub != Integer.MAX_VALUE){
                ans = Math.min(ans, 1+sub);
            }
        }
        dp[i] = ans;
        return dp[i];
    }
}
