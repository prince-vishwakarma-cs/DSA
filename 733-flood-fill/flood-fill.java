class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[image.length][image[0].length];
        int rang=image[sr][sc];
        q.add(new int[]{sr,sc});
        visited[sr][sc]=true;
        while(!q.isEmpty()){
            int r=q.peek()[0];
            int c=q.peek()[1];
            q.poll();
            if(c<image[0].length-1 && image[r][c+1]==rang && !visited[r][c+1]){
                visited[r][c+1]=true;
                q.add(new int[]{r,c+1});
            }
            if(r>0 && image[r-1][c]==rang && !visited[r-1][c]){
                visited[r-1][c]=true;
                q.add(new int[]{r-1,c});
            }
            if(r<image.length-1 && image[r+1][c]==rang && !visited[r+1][c]){
                visited[r+1][c]=true;
                q.add(new int[]{r+1,c});
            }
            if(c>0 && image[r][c-1]==rang && !visited[r][c-1]){
                visited[r][c-1]=true;
                q.add(new int[]{r,c-1});
            }
            
        }
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(visited[i][j]) image[i][j]=color;
            }
        }
        return image;
    }
}