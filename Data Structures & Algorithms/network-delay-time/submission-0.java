class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //build the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int t = time[2];

            graph.get(u).add(new int[]{v,t});
        }

        // 2. Initialize the Min-Heap (Priority Queue)
        // Stores: [totalTimeSoFar, currentNode]
        // Sorted by totalTimeSoFar (index 0)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        // Start at node K at time 0
        minHeap.offer(new int[]{0, k});

        // 3. Track visited nodes
        Set<Integer> visited = new HashSet<>();
        int maxTime=0;
        // 4. Run Dijkstra's Algorithm
        while(!minHeap.isEmpty()){
            int[] current = minHeap.poll();
            int currentTime = current[0];
            int currentNode = current[1];

            if(visited.contains(currentNode)) continue;
            // Mark as visited.
            visited.add(currentNode);

            maxTime = Math.max(maxTime, currentTime);
            // Only push unvisited neighbors into the queue
            for(int[] neighbor: graph.get(currentNode)){
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];
                if(!visited.contains(nextNode)){
                    // The time to reach the neighbor is our current time + the travel time
                    minHeap.offer(new int[]{currentTime+travelTime, nextNode});
                }
            }
        }
        return visited.size()==n ? maxTime : -1;
    }
}
