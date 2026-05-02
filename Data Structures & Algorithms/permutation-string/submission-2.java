class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        if(s1.length() > s2.length()) return false;

        for(int i=0;i<s1.length();i++){
            char c1 = s1.charAt(i);
            count1[c1 - 'a']++;

            char c2 = s2.charAt(i);
            count2[c2 - 'a']++;

        }
        int match =0;
        for(int i=0;i<26;i++){
            if(count1[i]==count2[i]) match++;
        }

        int left =0;

        for(int right=s1.length();right<s2.length();right++){
            if(match==26) return true;

            char rc = s2.charAt(right);
            int ridx = rc-'a';
            count2[ridx]++;
            if(count2[ridx] == count1[ridx]) match++;
            else if(count2[ridx] == count1[ridx] + 1) match--;

            char lc = s2.charAt(left);
            int lidx = lc-'a';
            count2[lidx]--;
            if(count2[lidx] == count1[lidx]) match++;
            else if(count2[lidx] == count1[lidx] - 1) match--;
            left++;
        }

        return match==26;
    }

}
