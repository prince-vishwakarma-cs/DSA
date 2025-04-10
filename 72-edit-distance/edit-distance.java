class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[m][i] = n - i;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][n] = m - i;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int min = Integer.MAX_VALUE;
                if (word1.charAt(i) == word2.charAt(j)) {
                    min = Math.min(min, dp[i + 1][j + 1]);
                }
                min = Math.min(min, dp[i][j + 1] + 1);
                min = Math.min(min, dp[i + 1][j + 1] + 1);
                min = Math.min(min, dp[i + 1][j] + 1);
                dp[i][j] = min;
            }
        }
        return dp[0][0];
    }
}