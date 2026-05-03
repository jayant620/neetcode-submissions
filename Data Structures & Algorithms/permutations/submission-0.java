class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> currentPath, List<List<Integer>> result){
        if(currentPath.size()==nums.length){
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i] == true) continue;

            used[i] = true;
            currentPath.add(nums[i]);

            dfs(nums, used, currentPath, result);

            used[i] = false;
            currentPath.remove(currentPath.size()-1);
        }
    }
}
