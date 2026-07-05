class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        dp =new Boolean[nums.length];
        return dfs(0, nums);
    }

    private boolean dfs(int i, int[] nums){
        if(i>=nums.length-1){
            return true;
        }
        if(dp[i] != null) return dp[i];
        for(int jump=1;jump<=nums[i];jump++){
            if(dfs(i+jump, nums)){
                dp[i] = true;
                return dp[i];
            }
        }
        dp[i]= false;
        return dp[i];
    }
}
