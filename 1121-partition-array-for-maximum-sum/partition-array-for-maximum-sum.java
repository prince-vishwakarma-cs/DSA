class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp = new int[k+1];
        for (int i = 0; i < n; i++) {
            int max = 0;
            int val = 0;
            for (int s = i; s >= Math.max(i - k + 1, 0); s--) {
                val = Math.max(val, arr[s]);
                max = Math.max(max, (i - s + 1) * val + (s > 0 ? dp[(s - 1)%k] : 0));
            }
            dp[i%k]=max;
        }
        return dp[(arr.length - 1)%k];
    }
}