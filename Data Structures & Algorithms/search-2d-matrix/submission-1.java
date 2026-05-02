class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l=0;
        int r=rows*cols-1;

        while(l<=r){
            int m = l+(r-l)/2;
            int mr = m/cols;
            int mc = m%cols;
            if(matrix[mr][mc]==target) return true;
            if(matrix[mr][mc]< target) l = m+1;
            else r = m-1;
        }
        return false;
    }
}
