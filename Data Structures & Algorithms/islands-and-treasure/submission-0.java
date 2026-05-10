class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        // Standard trick to cleanly loop through 4 directions
        int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for(int[] dir: direction){
                int nextRow = r + dir[0];
                int nextCol = c + dir[1];

                if(nextRow<0 || nextRow>=grid.length || nextCol<0 || 
                nextCol>=grid[0].length || grid[nextRow][nextCol] != Integer.MAX_VALUE){
                    continue;
                }
                // If it is valid land, the shortest distance to it is exactly 
                // 1 step further than the cell we are currently standing on.
                grid[nextRow][nextCol] = grid[r][c] + 1;

                // Add this new land to the queue so the ripple continues outward!
                queue.offer(new int[]{nextRow, nextCol});
            }
        }
    }
}
