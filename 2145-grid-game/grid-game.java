class Solution {
    public long gridGame(int[][] grid) {
        int m = grid[0].length;
        long[] topPrefix = new long[m];
        long[] bottomPrefix = new long[m];

        topPrefix[0] = grid[0][0];
        bottomPrefix[0] = grid[1][0];
        for (int i = 1; i < m; i++) {
            topPrefix[i] = topPrefix[i - 1] + grid[0][i];
            bottomPrefix[i] = bottomPrefix[i - 1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            long scoreTop = topPrefix[m - 1] - topPrefix[i];
            long scoreBottom = (i > 0 ? bottomPrefix[i - 1] : 0);
            long secondRobotMax = Math.max(scoreTop, scoreBottom);
            result = Math.min(result, secondRobotMax);
        }
        return result;
    }
}
