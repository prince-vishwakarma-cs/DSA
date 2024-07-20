class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        for (int i = 0, j = 0; i < ans.length && j < ans[0].length; i++, j++) {
            int x = Math.min(rowSum[i], colSum[j]);
            ans[i][j] = x;
            colSum[j] -= x;
            rowSum[i] -= x;
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                if (i != j) {
                    int x = Math.min(rowSum[i], colSum[j]);
                    ans[i][j] = x;
                    colSum[j] -= x;
                    rowSum[i] -= x;
                }
            }
        }
        return ans;
    }
}