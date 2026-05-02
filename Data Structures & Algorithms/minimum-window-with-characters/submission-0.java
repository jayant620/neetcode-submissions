class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length()<t.length()){
            return "";
        }

        int[] map = new int[128];
        for(char c : t.toCharArray()){
            map[c]++;
        }
        int left=0,right=0;
        int counter = t.length();
        int minLen = Integer.MAX_VALUE;
        int minStart=0;
        while(right<s.length()){
            char c = s.charAt(right);
            if(map[c] > 0){
                counter--;
            }
            map[c]--;
            right++;
            while(counter==0){
                char lc = s.charAt(left);
                if(right-left<minLen){
                    minLen = right-left;
                    minStart = left;
                }
                map[lc]++;
                if(map[lc]>0){
                    counter++;
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
    }
}
