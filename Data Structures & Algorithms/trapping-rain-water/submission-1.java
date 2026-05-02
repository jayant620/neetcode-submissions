class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int leftMax=height[l], rightMax = height[r];
        int sum=0;
        while(l<r){
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                sum += leftMax -height[l];
            } else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                sum += rightMax - height[r];
            }
        }
        return sum;
    }
}
