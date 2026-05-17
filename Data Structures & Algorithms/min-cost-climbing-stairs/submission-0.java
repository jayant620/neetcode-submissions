class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(0,cost), dfs(1,cost));
    }

    private int dfs(int i, int[] cost){
        if(i>=cost.length) return 0;

        if(map.containsKey(i)) return map.get(i);

        int result = cost[i] + Math.min(dfs(i+1, cost), dfs(i+2, cost));
        map.put(i, result);
        return result;
    }
}
