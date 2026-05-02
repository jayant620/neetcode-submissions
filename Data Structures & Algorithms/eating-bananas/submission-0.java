class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int max = Arrays.stream(piles).max().getAsInt();
        int r=max;
        int result = r;
        while(l<=r){
            int m = l+(r-l)/2;
            int total =0;
            for(int p: piles){
                int timeTaken = (int) Math.ceil((double)p/m);
                total += timeTaken;
            }
            if(total > h){
                l = m+1;
            } else{
                result = m;
                r = m-1;
            }
            
        }
        return result;
    }
}
