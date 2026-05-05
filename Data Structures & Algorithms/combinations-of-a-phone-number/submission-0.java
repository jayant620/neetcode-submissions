class Solution {
    private String[] keypad = {" ", " ",
    "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        dfs(0, digits, new StringBuilder(), result);
        return result;
    }

    private void dfs(int index, String digits, StringBuilder curString, List<String> result){
        if(index == digits.length()){
            result.add(curString.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = keypad[digit];
        for(char c: letters.toCharArray()){
            curString.append(c);
            dfs(index+1, digits, curString, result);
            curString.deleteCharAt(curString.length()-1);
        }
    }
}
