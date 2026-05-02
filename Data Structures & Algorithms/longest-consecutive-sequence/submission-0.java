class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int max =0;
        for(int num: set){
            if(set.contains(num-1)) continue;
            int localNum = num;
            int localMax = 0;
            while(set.contains(localNum)){
                localMax++;
                localNum++;
            }
            max = Math.max(localMax,max);
        }
        return max;
    }
}
