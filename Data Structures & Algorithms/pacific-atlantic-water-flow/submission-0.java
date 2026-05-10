class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacificReached = new boolean[rows][cols];
        boolean[][] atlanticReached = new boolean[rows][cols];
        // 1. Flood from the Top and Bottom Rows
        for(int c=0; c<cols; c++){
            dfs(heights, 0, c, 0, pacificReached);
            dfs(heights, rows-1, c, 0, atlanticReached);
        }
        // 2. Flood from the Left and Right Columns
        for(int r=0; r<rows; r++){
            dfs(heights, r, 0, 0, pacificReached);
            dfs(heights, r, cols-1, 0, atlanticReached);
        }

        //find intersection
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(pacificReached[r][c] && atlanticReached[r][c]){
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, int previousHeight, boolean[][] reached){
        if(r<0 || c<0 || r>=heights.length || c>=heights[0].length 
        || reached[r][c] || previousHeight > heights[r][c]){
            return;
        }

        reached[r][c] = true;

        dfs(heights, r+1, c, heights[r][c], reached);
        dfs(heights, r-1, c, heights[r][c], reached);
        dfs(heights, r, c+1, heights[r][c], reached);
        dfs(heights, r, c-1, heights[r][c], reached);
    }
}
