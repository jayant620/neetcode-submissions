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
        for (int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (!minHeap.isEmpty() && minHeap.peek() <= current.start) {
                minHeap.poll();
            }
            minHeap.offer(current.end);
        }
        return minHeap.size();
    }
}
