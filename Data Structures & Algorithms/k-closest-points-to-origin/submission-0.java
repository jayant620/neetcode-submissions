class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        for(int[] point: points){
            int dist = point[0] * point[0] + point[1] * point[1];
            maxHeap.offer(new int[]{dist, point[0], point[1]});
            if(maxHeap.size()>k) maxHeap.poll();
        }

        int[][] result = new int[k][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            int[] val = maxHeap.poll();
            result[i][0] = val[1];
            result[i][1] = val[2];
            i++;
        }
        return result;
    }
}
