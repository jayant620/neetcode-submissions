class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int i, int[] nums, List<Integer> currentPath, List<List<Integer>> result){
        if(i>=nums.length){
            result.add(new ArrayList<>(currentPath));
            return;
        }
        currentPath.add(nums[i]);
        dfs(i+1, nums, currentPath, result);

        currentPath.remove(currentPath.size()-1);

        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        dfs(i+1, nums, currentPath, result);
    }
}
