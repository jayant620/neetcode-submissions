class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, result, new StringBuilder(), 0, 0);
        return result;
    }

    private void dfs(int n, List<String> result,StringBuilder sb, int openCount, int closeCount){
        // 1. BASE CASE: The string is complete (contains exactly n pairs)
        if(sb.length() == 2*n){
            result.add(sb.toString());
            return;
        }
        // --- THE DECISION TREE ---

        // Decision A: Add an OPEN parenthesis
        if(openCount < n){
            sb.append("("); // CHOOSE
            dfs(n, result, sb, openCount+1, closeCount); //explore
            sb.deleteCharAt(sb.length()-1); //unchoose
        }
        // Decision B: Add a CLOSE parenthesis
        if(closeCount < openCount){
            sb.append(")"); // CHOOSE
            dfs(n, result, sb, openCount, closeCount+1); //explore
            sb.deleteCharAt(sb.length()-1); // unchoose
        }
    }
}
