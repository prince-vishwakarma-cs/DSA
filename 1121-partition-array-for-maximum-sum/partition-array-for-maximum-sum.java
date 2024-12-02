class Solution {
    public int solve(int[] arr,int k,int i,int[] dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int max=0;
        int val=0;
        for(int s=i;s>=Math.max(i-k+1,0);s--){
            val=Math.max(val,arr[s]);
            max=Math.max(max,(i-s+1)*val+solve(arr,k,s-1,dp));
        }
        return dp[i]=max;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return solve(arr,k,arr.length-1,dp);
    }
}