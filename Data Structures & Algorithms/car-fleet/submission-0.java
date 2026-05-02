class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] car = new double[n][2];
        for(int i=0;i<n;i++){
            car[i][0] = position[i];
            car[i][1] = (double)(target - position[i]) / (double) speed[i];
        }
        Arrays.sort(car, (a,b) -> Double.compare(b[0],a[0]));
        double currMaxTime =0;
        int fleet = 0;
        for(int i=0;i<n;i++){
            double time = car[i][1];
            if(time >currMaxTime){
                currMaxTime = time;
                fleet++;
            }
        }
        return fleet;
    }
}
