import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void bfs(int[][] image, int[][] visited, int k, int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        visited[sr][sc] = k;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            
            // Check right
            if (c < image[0].length - 1 && image[r][c + 1] == 1 && visited[r][c + 1] == 0) {
                visited[r][c + 1] = k;
                q.add(new int[]{r, c + 1});
            }
            // Check up
            if (r > 0 && image[r - 1][c] == 1 && visited[r - 1][c] == 0) {
                visited[r - 1][c] = k;
                q.add(new int[]{r - 1, c});
            }
            // Check down
            if (r < image.length - 1 && image[r + 1][c] == 1 && visited[r + 1][c] == 0) {
                visited[r + 1][c] = k;
                q.add(new int[]{r + 1, c});
            }
            // Check left
            if (c > 0 && image[r][c - 1] == 1 && visited[r][c - 1] == 0) {
                visited[r][c - 1] = k;
                q.add(new int[]{r, c - 1});
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        
        // Marking boundary-connected lands
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1 && visited[i][0] == 0) {
                bfs(grid, visited, 1, i, 0);
            }
            if (grid[i][grid[0].length - 1] == 1 && visited[i][grid[0].length - 1] == 0) {
                bfs(grid, visited, 1, i, grid[0].length - 1);
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1 && visited[0][i] == 0) {
                bfs(grid, visited, 1, 0, i);
            }
            if (grid[grid.length - 1][i] == 1 && visited[grid.length - 1][i] == 0) {
                bfs(grid, visited, 1, grid.length - 1, i);
            }
        }

        // Count and mark enclaves
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    bfs(grid, visited, 2, i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 2) {
                    count++;
                }
            }
        }

        return count;
    }
}
