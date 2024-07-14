class Solution {
    public void bfs(int[][] maze, boolean[][] visited, int[] interval, int[] i) {
        Queue<int[]> q = new LinkedList<>();
        q.add(interval);
        visited[interval[0]][interval[1]] = true;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int r = t[0];
            int c = t[1];
            int s=0;
            if(t[0] > 0 && maze[t[0] - 1][t[1]] == 1) s++;
            if (t[0] < maze.length - 1 && maze[t[0] + 1][t[1]] == 1) s++;
            if (t[1] > 0 && maze[t[0]][t[1] - 1] == 1) s++;
            if (t[1] < maze[0].length - 1 && maze[t[0]][t[1] + 1] == 1) s++;
            i[0]+=(4-s);
            if (t[0] > 0 && maze[t[0] - 1][t[1]] == 1 && !visited[t[0] - 1][t[1]]) {
                q.add(new int[] { t[0] - 1, t[1] });
                visited[t[0] - 1][t[1]] = true;
            }
            if (t[0] < maze.length - 1 && maze[t[0] + 1][t[1]] == 1 && !visited[t[0] + 1][t[1]]) {
                q.add(new int[] { t[0] + 1, t[1] });
                visited[t[0] + 1][t[1]] = true;
            }
            if (t[1] > 0 && maze[t[0]][t[1] - 1] == 1 && !visited[t[0]][t[1] - 1]) {
                q.add(new int[] { t[0], t[1] - 1 });
                visited[t[0]][t[1] - 1] = true;
            }
            if (t[1] < maze[0].length - 1 && maze[t[0]][t[1] + 1] == 1 && !visited[t[0]][t[1] + 1]) {
                q.add(new int[] { t[0], t[1] + 1 });
                visited[t[0]][t[1] + 1] = true;
            }
        }
    }

    public int islandPerimeter(int[][] grid) {
        boolean[][] visited =new boolean[grid.length][grid[0].length];
        int[] s=new int[1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    bfs(grid,visited,new int[]{i,j},s);
                }
            }
        }
        return s[0];
    }
}