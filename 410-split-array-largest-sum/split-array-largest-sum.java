class Solution {
    public int solve(int[] nums,int k,int start,int end,Integer[][] dp){
        if(k==1) return nums[end]-(start>0 ? nums[start-1]: 0);
        int min=Integer.MAX_VALUE;
        if(dp[start][k]!=null) return dp[start][k];
         for(int i=start;i<end;i++){
            int sum=nums[i]-(start>0 ? nums[start-1]: 0);
            min=Math.min(min,Math.max(solve(nums,k-1,i+1,end,dp),sum));
        }
        return dp[start][k]=min;
    }
    public int splitArray(int[] nums, int k) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        Integer[][] dp=new Integer[nums.length][k+1];
        return solve(nums,k,0,nums.length-1,dp);
    }
}