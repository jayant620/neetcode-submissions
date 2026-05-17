class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int case1 = houserobber1(nums, 0, nums.length-2);
        int case2 = houserobber1(nums, 1, nums.length-1);

        return Math.max(case1, case2);
    }

    private int houserobber1(int[] nums, int start, int end){
        int twoHouseBack = 0;
        int oneHouseBack = 0;
        for(int i=start;i<=end;i++){
            int current = Math.max(nums[i]+twoHouseBack, oneHouseBack);
            twoHouseBack = oneHouseBack;
            oneHouseBack = current;
        }
        return oneHouseBack;
    }
}
