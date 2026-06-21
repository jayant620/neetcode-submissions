class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2 != 0) return false;
        memo = new Boolean[nums.length+1][sum/2 + 1];
        return dfs(0,sum/2, nums);
    }

    private boolean dfs(int i, int remaining, int[] nums){
        if(remaining==0){
            return true;
        }
        if(remaining<0){
            return false;
        }
        if(i==nums.length){
            return false;
        }
        if(memo[i][remaining] != null) return memo[i][remaining];

        memo[i][remaining] = dfs(i+1, remaining-nums[i], nums) || dfs(i+1, remaining, nums);

        return memo[i][remaining];
    }
}
