class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        return dfs(0, s);
    }

    private int dfs(int i, String s){
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(map.containsKey(i)) return map.get(i);//dp

        int ways = dfs(i+1, s);

        if(i+1 < s.length()){
            int num = Integer.parseInt(s.substring(i, i+2));
            if(num>=10 && num<=26){
                ways += dfs(i+2, s);
            } 
        }
        map.put(i, ways);
        return ways;
    }
}
