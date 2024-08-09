class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2 && !visited[i][j]) q.add(new int[] { i, j });
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            boolean anychange=false;
            for (int p = 0; p < size; p++) {
                int[] k = q.poll();
                int i=k[0],j=k[1];
                visited[i][j] = true;
                if (i-1 >= 0 && grid[i-1][j] == 1 && !visited[i-1][j]) {
                    q.add(new int[] {i-1,j});
                    grid[i-1][j] = 2;
                    anychange=true;
                }
                if (i+1 < m && grid[i+1][j] == 1 && !visited[i+1][j]) {
                    q.add(new int[] {i+1,j});
                    grid[i+1][j] = 2;
                    anychange=true;
                }
                if (j-1 >= 0 && grid[i][j-1] == 1 && !visited[i][j-1]) {
                    q.add(new int[] {i,j-1});
                    grid[i][j-1] = 2;
                    anychange=true;
                }
                if (j+1 < n && grid[i][j+1] == 1 && !visited[i][j+1]) {
                    q.add(new int[] {i,j+1});
                    grid[i][j+1] = 2;
                    anychange=true;
                }
            }
           if(anychange) ans++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j])
                    return -1;
            }
        }
        return ans;
    }
}