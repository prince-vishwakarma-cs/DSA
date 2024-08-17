class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1;
        int[][] direction = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int[][] ans = new int[m][n];
        for (int[] arr : ans) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        pq.add(new int[]{1, 0, 0});
        ans[0][0] = 1;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[1];
            int j = top[2];
            int d = top[0];

            for (int[] dir : direction) {
                int newi = i + dir[0];
                int newj = j + dir[1];
                if (newi < m && newi >= 0 && newj >= 0 && newj < n && grid[newi][newj] == 0) {
                    if (ans[newi][newj] > d + 1) {
                        ans[newi][newj] = d + 1;
                        pq.add(new int[]{d + 1, newi, newj});
                    }
                }
            }
        }
        return ans[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : ans[m - 1][n - 1];
    }
}
