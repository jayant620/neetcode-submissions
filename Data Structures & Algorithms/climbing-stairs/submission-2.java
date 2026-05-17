class Solution {
    Map<Integer, Integer> map;
    public int climbStairs(int n) {
        map = new HashMap<>();
        return dfs(0, n);
    }
    private int dfs(int i, int n){
        if(i==n) return 1;
        if(i>n) return 0;
        if(map.containsKey(i)) return map.get(i);
        int result = dfs(i+1, n) + dfs(i+2, n);
        map.put(i, result);
        return result;
    }
}
