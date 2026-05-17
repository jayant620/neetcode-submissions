class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        return dfs(0,nums);
    }

    private int dfs(int i, int[] nums){
        if(i>=nums.length){
            return 0;
        }
        if(map.containsKey(i)) return map.get(i);
        int rob = nums[i] + dfs(i+2, nums);
        int skip = dfs(i+1, nums);
        int result = Math.max(rob, skip);

        map.put(i, result);
        return result;
    }
}
