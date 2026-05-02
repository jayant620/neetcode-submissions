class MedianFinder {

    PriorityQueue<Integer> maxHeapLeft;
    PriorityQueue<Integer> minHeapRight;

    public MedianFinder() {
        maxHeapLeft = new PriorityQueue<>(Collections.reverseOrder());
        minHeapRight = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeapLeft.offer(num);

        minHeapRight.offer(maxHeapLeft.poll());

        if(minHeapRight.size() > maxHeapLeft.size()){
            maxHeapLeft.offer(minHeapRight.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeapLeft.size() != minHeapRight.size()){
            return maxHeapLeft.peek();
        }

        return (maxHeapLeft.peek() + minHeapRight.peek()) / 2.0;
    }
}
