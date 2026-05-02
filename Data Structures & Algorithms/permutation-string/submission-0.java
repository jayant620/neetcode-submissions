class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i=0;i<s1.length();i++){
            char c = s1.charAt(i);
            count1[c - 'a']++;
        }

        int left=0;
        for(int right=0;right<s2.length();right++){
            char c = s2.charAt(right);
            count2[c-'a']++;
            if(right-left+1 > s1.length()){
                char lc = s2.charAt(left);
                count2[lc - 'a']--;
                left++;
            }
            if(Arrays.equals(count1,count2)){
                return true;
            }
        }
        return false;
    }
}
