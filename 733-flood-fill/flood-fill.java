class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        boolean [][] visited = new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});
        int dir[][] ={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] k=q.poll();
            visited[k[0]][k[1]]=true;
            for(int p=0;p<dir.length;p++){
                int i=k[0]+dir[p][0];
                int j=k[1]+dir[p][1];
                if(i>=0 && j>=0 && i<image.length && j<image[0].length && !visited[i][j] && image[i][j]==image[k[0]][k[1]]){
                    q.add(new int[]{i,j});
                }
            }
        }
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(visited[i][j]) image[i][j] = color;
            }
        }
        return image;
    }
}