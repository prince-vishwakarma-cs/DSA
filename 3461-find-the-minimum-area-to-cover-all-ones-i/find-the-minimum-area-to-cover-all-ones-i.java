class Solution {
    public int minimumArea(int[][] grid) {
        int minRow=grid.length;
        int maxRow=0;
        int minCol=grid[0].length;
        int maxCol=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(i<minRow) minRow=i;
                    if(i>maxRow) maxRow=i;
                    if(j<minCol)minCol=j;
                    if(j>maxCol) maxCol=j;
                }
            }
        }
        return (maxRow-minRow+1)*(maxCol-minCol+1);
    }
}