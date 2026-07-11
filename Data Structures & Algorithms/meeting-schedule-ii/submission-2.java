/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxRooms=0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            while (!minHeap.isEmpty() && minHeap.peek() <= current.start) {
                minHeap.poll();
            }
            minHeap.offer(current.end);
            maxRooms = Math.max(minHeap.size(), maxRooms);
        }
        return maxRooms;
    }
}
