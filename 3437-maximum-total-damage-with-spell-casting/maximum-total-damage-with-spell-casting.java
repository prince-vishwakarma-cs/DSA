class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> freqMap = new HashMap<>();
        for (int p : power) {
            freqMap.put(p, freqMap.getOrDefault(p, 0L) + 1);
        }

        List<Integer> uniquePowers = new ArrayList<>(freqMap.keySet());
        Collections.sort(uniquePowers);

        int n = uniquePowers.size();
        long[] dp = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int powerVal = uniquePowers.get(i);
            long damage = powerVal * freqMap.get(powerVal);

            dp[i + 1] = dp[i];
            int j = i - 1;
            while (j >= 0 && uniquePowers.get(j) >= powerVal - 2) {
                j--;
            }

            dp[i + 1] = Math.max(dp[i + 1], (j >= 0 ? dp[j + 1] : 0) + damage);
        }

        return dp[n];
    }
}