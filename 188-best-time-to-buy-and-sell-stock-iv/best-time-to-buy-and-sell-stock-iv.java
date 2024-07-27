class Solution {
    public int maximum(int[] arr,int i,int canBuy,int k,Integer[][][] dp){
        if(i>=arr.length || k==0) return 0;

if(dp[i][canBuy][k] !=null ) return dp[i][canBuy][k];
int max=0;
if(canBuy==1){
    int buy=maximum(arr,i+1,0,k,dp)-arr[i];
    int nobuy=maximum(arr,i+1,1,k,dp);
    max=Math.max(buy,nobuy);
} else{
    int sell=maximum(arr,i+1,1,k-1,dp)+arr[i];
    int nosell=maximum(arr,i+1,0,k,dp);
    max=Math.max(sell,nosell);
}
dp[i][canBuy][k] = max;
return max;
    }
    public int maxProfit(int k, int[] prices){
        Integer[][][] dp=new Integer[prices.length][2][k+1];
        return Math.max(0,maximum(prices,0,1,k,dp));
    }
}