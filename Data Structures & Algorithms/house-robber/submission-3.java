class Solution {
    public int rob(int[] nums) {
        int prevOne=0;
        int prevTwo=0;

        for(int i=0;i<nums.length;i++){
            int current = Math.max(nums[i]+prevTwo, prevOne);
            prevTwo = prevOne;
            prevOne = current;
        }
        return prevOne;
    }
}
