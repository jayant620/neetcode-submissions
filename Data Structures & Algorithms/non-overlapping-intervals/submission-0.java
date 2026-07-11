class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int removed = 0;
        int previousEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start < previousEnd) {
                previousEnd = Math.min(previousEnd, end);
                removed++;
            } else {
                previousEnd = end;
            }
        }
        return removed;
    }
}
