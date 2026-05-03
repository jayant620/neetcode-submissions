class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, target, new ArrayList<>(), 0, result);
        return result;
    }

    private void dfs(int i, int[] nums, int target, List<Integer> currentPath, int currentSum, List<List<Integer>> result){
        if(currentSum==target){
            result.add(new ArrayList<>(currentPath));
            return;
        }

        if(currentSum > target || i>=nums.length){
            return;
        }

        currentPath.add(nums[i]);
        dfs(i, nums, target, currentPath, currentSum+nums[i], result);
        currentPath.remove(currentPath.size()-1);
        dfs(i+1, nums, target, currentPath, currentSum, result);
    }
}
