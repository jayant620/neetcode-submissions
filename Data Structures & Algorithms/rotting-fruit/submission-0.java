class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                } else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int minute=0;
        while(!queue.isEmpty() && freshCount>0){
            int size = queue.size();

            for(int i=0;i<size;i++){
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for(int[] dir: direction){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr<0 || nc<0 || nr>=grid.length || nc>= grid[0].length 
                    || grid[nr][nc] != 1){
                        continue;
                    }
                    grid[nr][nc] = 2; // Mark as rotten so we don't visit it again
                    freshCount--;
                    queue.offer(new int[]{nr,nc});
                }
            }
            minute++; // a full minute passed
        }

        return freshCount==0 ? minute : -1;
    }
}
