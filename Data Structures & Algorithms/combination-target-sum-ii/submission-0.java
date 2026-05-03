class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int i, int[] candidates, int target, int sum, List<Integer> currentPath, List<List<Integer>> result){
        if(sum==target){
            result.add(new ArrayList<>(currentPath));
            return;
        }
        if(sum > target || i>=candidates.length){
            return;
        }
        currentPath.add(candidates[i]);//include
        dfs(i+1, candidates, target, sum + candidates[i], currentPath, result);

        currentPath.remove(currentPath.size()-1);//exclude
        while(i+1<candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        dfs(i+1, candidates,target, sum, currentPath, result);
    }
}
