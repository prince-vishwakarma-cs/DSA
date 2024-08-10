class Solution {
    public int lis(int[] nums, int i, int last, Integer[][] dp) {
        if (i >= nums.length)
            return 0;
        if (dp[i][last + 1] != null)
            return dp[i][last + 1];
        int ans = 0;
        if (last==-1 || nums[last]<nums[i]) {
            ans = Math.max(lis(nums, i + 1, i, dp) + 1,ans);
        }
            ans = Math.max(lis(nums, i + 1, last, dp),ans);
        dp[i][last + 1] = ans;
        return dp[i][last + 1];
    }

    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length + 1];
        return lis(nums, 0, -1, dp);
    }
}
