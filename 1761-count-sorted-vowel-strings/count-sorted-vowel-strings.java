class Solution {
    char[] ch={' ','a','e','i','o','u'};

    public int howmany(int n,int s,Integer[][] dp){
        if(n==0) return 1;
        if(dp[n][s]!=null) return dp[n][s];
        int ans=0;
        for(int i=1;i<6;i++){
            if(s==' ' || ch[s]<=ch[i]) ans+=howmany(n-1,i,dp);
        }
        dp[n][s]=ans;
        return ans;
    }
    public int countVowelStrings(int n) {
        Integer [][] dp=new Integer[n+1][6];
        return howmany(n,0,dp);
    }
}