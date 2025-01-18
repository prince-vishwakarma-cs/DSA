class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        ans[0][0] = 0;
        pq.add(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[0];
            int y = top[1];
            int weight = top[2];

            if (weight > ans[x][y]) continue;

            if (x > 0) {
                int nw = weight;
                if (grid[x][y] != 4) nw += 1;
                if (ans[x - 1][y] > nw) {
                    ans[x - 1][y] = nw;
                    pq.add(new int[] { x - 1, y, nw });
                }
            }

            if (y > 0) {
                int nw = weight;
                if (grid[x][y] != 2) nw += 1;
                if (ans[x][y - 1] > nw) {
                    ans[x][y - 1] = nw;
                    pq.add(new int[] { x, y - 1, nw });
                }
            }

            if (y < n - 1) {
                int nw = weight;
                if (grid[x][y] != 1) nw += 1;
                if (ans[x][y + 1] > nw) {
                    ans[x][y + 1] = nw;
                    pq.add(new int[] { x, y + 1, nw });
                }
            }

            if (x < m - 1) {
                int nw = weight;
                if (grid[x][y] != 3) nw += 1;
                if (ans[x + 1][y] > nw) {
                    ans[x + 1][y] = nw;
                    pq.add(new int[] { x + 1, y, nw });
                }
            }
        }

        return ans[m - 1][n - 1];
    }
}