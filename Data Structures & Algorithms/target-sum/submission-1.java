class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, 0, nums, target);
    }

    private int dfs(int i, int sum, int[] nums, int target){
        if(i==nums.length){
            if(sum==target){
                return 1;
            }else {
                return 0;
            }
        }
        String key = i + "," + sum;
        if(map.get(key)!= null) return map.get(key);

        int way = dfs(i+1, sum+nums[i], nums, target) + dfs(i+1, sum-nums[i], nums, target);
        map.put(key, way);
        return way;
    }
}
