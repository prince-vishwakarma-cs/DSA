class Solution {
    public int solution(int[] prices, int fee, int canBuy, int i, Integer[][] dp) {
        if (i >= prices.length) return 0;
        if (dp[i][canBuy] != null) return dp[i][canBuy];

        int max = 0;

        if (canBuy == 1) {
            int buy = solution(prices, fee, 0, i + 1, dp) - prices[i];
            int skip = solution(prices, fee, 1, i + 1, dp);
            max = Math.max(buy, skip);
        } else {
            int sell = solution(prices, fee, 1, i + 1, dp) + prices[i] - fee;
            int hold = solution(prices, fee, 0, i + 1, dp);
            max = Math.max(sell, hold);
        }
        dp[i][canBuy] = max;

        return max;
    }

    public int maxProfit(int[] prices, int fee) {
        Integer[][] dp = new Integer[prices.length][2];
        return solution(prices, fee, 1, 0, dp);
    }
}