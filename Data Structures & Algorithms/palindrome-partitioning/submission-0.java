class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int startIndex, String s, List<String> currentPath, List<List<String>> result){
        if(startIndex == s.length()){
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for(int i=startIndex; i<s.length();i++){
            String currentSlice = s.substring(startIndex, i+1);
            
            if(isPalindrome(currentSlice)){
                currentPath.add(currentSlice);
                dfs(i+1, s, currentPath, result);
                currentPath.remove(currentPath.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
