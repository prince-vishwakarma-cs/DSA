class Solution {
    public int robber(int[] nums,int can,int i,Integer[][] dp){
        if(i>=nums.length) return 0;
        int max=0;
        if(dp[i][can]!=null) return dp[i][can];
        if(can==1){
            int ans=robber(nums,0,i+1,dp)+nums[i];
            int ans2=robber(nums,1,i+1,dp);
            max=Math.max(ans,ans2);
        }
        else{
            int ans=robber(nums,1,i+1,dp);
            max=ans;
        }
        dp[i][can]=max;
        return max;
    }
    public int rob(int[] nums) {
        Integer[][] dp=new Integer[nums.length+1][2];
        return robber(nums,1,0,dp);
    }
}