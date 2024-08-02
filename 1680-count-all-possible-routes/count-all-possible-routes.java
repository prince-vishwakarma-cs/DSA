class Solution {
    public int sol(int[] arr,int st,int f,int end,Integer[][] dp){
        if(f<0) return 0;
        if(dp[st][f]!=null) return dp[st][f];
        long ans = st==end ? 1 : 0;
        for(int i=0;i<arr.length;i++){
            if(i!=st) ans+=(sol(arr,i,f-Math.abs(arr[i]-arr[st]),end,dp)%1000000007);
        }
        dp[st][f]=(int)(ans%1000000007);
        return dp[st][f];
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        Integer[][] dp=new Integer[locations.length][fuel+1];
        return sol(locations,start,fuel,finish,dp);
    }
}