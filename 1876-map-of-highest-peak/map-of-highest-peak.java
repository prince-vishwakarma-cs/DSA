class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    isWater[i][j]=0;
                    q.add(new int[]{i,j});
                } else isWater[i][j]=-1;
            }
        }
        int[][] dirs=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] top=q.poll();
            int x=top[0];
            int y=top[1];
            for(int[] dir:dirs){
                int newx=x+dir[0];
                int newy=y+dir[1];
                if(newx>=0 && newy>=0 && newx<m && newy<n && isWater[newx][newy]==-1){
                    isWater[newx][newy]=isWater[x][y]+1;
                    q.add(new int[]{newx,newy});
                }
            }
        }
        return isWater;
    }
}