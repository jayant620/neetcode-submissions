class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int n:stones) maxHeap.offer(n);
        while(maxHeap.size()>2){
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();
            if(max1 > max2) maxHeap.offer(max1-max2);
            if(max2 > max1) maxHeap.offer(max2-max1);
        }
        int max1 =0;
        if(!maxHeap.isEmpty()){
            max1 = maxHeap.poll();
        }
        int max2=0;
        if(!maxHeap.isEmpty()){
            max2 = maxHeap.poll();
        }
        if(max1 > max2) return max1-max2;
        if(max2 > max1) return max2-max1;
        return 0;
    }
}
