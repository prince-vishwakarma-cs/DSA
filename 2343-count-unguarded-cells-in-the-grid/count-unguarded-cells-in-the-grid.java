class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid=new int[m][n];
        for(int[] wall:walls){
            int x=wall[0];
            int y=wall[1];
            grid[x][y]=1;
        }
        for(int[] guard:guards){
            int x=guard[0];
            int y=guard[1];
            grid[x][y]=1;
        }
        for(int[] guard:guards){
            int x=guard[0];
            int y=guard[1];
            int newx=x-1;
            int newy=y;
            while(newx>-1 && grid[newx][newy]!=1){
                grid[newx--][newy]=-1;
            }
            newy=y-1;
            newx=x;
            while(newy>-1 && grid[newx][newy]!=1){
                grid[newx][newy--]=-1;
            }
            newy=y+1;
            newx=x;
            while(newy<n && grid[newx][newy]!=1){
                grid[newx][newy++]=-1;
            }
            newx=x+1;
            newy=y;
            while(newx<m && grid[newx][newy]!=1){
                grid[newx++][newy]=-1;
            }
        }
        int ans=0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==0) ans++;
                }
            }
            return ans;
    }
}