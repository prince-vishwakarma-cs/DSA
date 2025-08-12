public class Solution {
    private static final int MOD = 1000000007;

    public int numberOfWays(int n, int x) {
        int maxNum = (int) Math.pow(n, 1.0 / x) + 1;
        int[][] dp = new int[maxNum + 1][n + 1];

        for (int i = 0; i <= maxNum; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= maxNum; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < Math.pow(i, x)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - (int)Math.pow(i, x)]) % MOD;
                }
            }
        }
        return dp[maxNum][n];
    }
}