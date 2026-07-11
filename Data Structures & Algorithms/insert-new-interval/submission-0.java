class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int[] interval: intervals){
            if(newInterval[1]<interval[0]){ // new comes before currnt
                result.add(newInterval);
                newInterval=interval;
            } else if(interval[1] < newInterval[0]){ // new comes after current
                result.add(interval);
            } else{//merge
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
