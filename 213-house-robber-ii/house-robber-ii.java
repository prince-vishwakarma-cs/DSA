class Solution {
    public int robber(int[] nums,int can,int i,Integer[][] dp,int last){
        if(i>=last) return 0;
        int max=0;
        if(dp[i][can]!=null) return dp[i][can];
        if(can==1){
            int ans=robber(nums,0,i+1,dp,last)+nums[i];
            int ans2=robber(nums,1,i+1,dp,last);
            max=Math.max(ans,ans2);
        }
        else{
            int ans=robber(nums,1,i+1,dp,last);
            max=ans;
        }
        dp[i][can]=max;
        return max;
    }
    public int rob(int[] nums) {
    if(nums.length==1) return nums[0];
    Integer[][] dp = new Integer[nums.length][2];
    Integer[][] dp2 = new Integer[nums.length][2];
    return Math.max(robber(nums, 1, 0, dp, nums.length - 1), robber(nums, 1, 1, dp2, nums.length));
}
}


