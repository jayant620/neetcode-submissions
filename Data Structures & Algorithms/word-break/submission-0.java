class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()+1];
        return dfs(0, s, wordDict);
    }

    private boolean dfs(int i,String s, List<String> dict){
        if(i==s.length()) return true;

        if(memo[i] != null) return memo[i];

        for(String word: dict){
            if(s.startsWith(word, i)){
                if(dfs(i+word.length(), s, dict)){
                    memo[i] = true;
                    return true;
                }
            }
        }
        memo[i] = false;
        return false;
    }
}
