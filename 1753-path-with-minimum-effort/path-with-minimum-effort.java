class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] direction = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int[][] ans = new int[m][n];
        for (int[] arr : ans) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        pq.add(new int[]{0,0, 0});
        ans[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[1];
            int j = top[2];
            int d=top[0];
            for (int[] dir : direction) {
                int newi = i + dir[0];
                int newj = j + dir[1];
                if (newi < m && newi >= 0 && newj >= 0 && newj < n) {
                    int newef=Math.max(Math.abs(heights[newi][newj]-heights[i][j]),d);
                    if (ans[newi][newj] > newef) {
                        ans[newi][newj] =newef;
                        pq.add(new int[]{newef,newi, newj});
                    }
                }
            }
        }
        return ans[m - 1][n - 1];
    }
}
