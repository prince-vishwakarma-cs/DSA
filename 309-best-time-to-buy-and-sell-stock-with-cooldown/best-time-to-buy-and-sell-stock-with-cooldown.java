class Solution {
    public int sol(int[] prices,int i,int mode,Integer[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][mode]!=null) return dp[i][mode];
        int ans=0;
        if(mode==0){
            int ans1= sol(prices,i+1,1,dp)-prices[i];  // kharida
            int ans2= sol(prices,i+1,0,dp);  // nahii kharida
            ans=Math.max(Math.max(ans1,ans2),ans);
        }
        else if(mode==1){
            int ans1 = sol(prices,i+1,2,dp)+prices[i]; // bech diya
            int ans2 = sol(prices,i+1,1,dp); // hahi becha
            ans=Math.max(Math.max(ans1,ans2),ans);
        }else{
            int ans1=sol(prices,i+1,0,dp);
            ans=Math.max(ans1,ans);
        }
        dp[i][mode]=ans;
        return dp[i][mode];
    }
    public int maxProfit(int[] prices) {
        Integer[][] dp =new Integer[prices.length][3];
        return sol(prices,0,0,dp);
    }
}