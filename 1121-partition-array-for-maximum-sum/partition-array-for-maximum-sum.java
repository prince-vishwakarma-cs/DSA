class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 0;
            int val = 0;
            for (int s = i; s >= Math.max(i - k + 1, 0); s--) {
                val = Math.max(val, arr[s]);
                dp[i] = Math.max(dp[i], (i - s + 1) * val + (s > 0 ? dp[s - 1] : 0));
            }
        }
        return dp[arr.length - 1];
    }
}