class Solution {
    public int minimum(String word1,String word2,int i,int j,Integer[][] dp){
        int m =word1.length();
        int n =word2.length();
        if(i>=m) return n-j;
        if(j>=n) return m-i;
        if(dp[i][j]!=null) return dp[i][j];
        int min = Integer.MAX_VALUE;
        if(word1.charAt(i)==word2.charAt(j)){
            min=Math.min(min,minimum(word1,word2,i+1,j+1,dp));
        }
        min=Math.min(min,minimum(word1,word2,i,j+1,dp)+1);
        min=Math.min(min,minimum(word1,word2,i+1,j+1,dp)+1);
        min=Math.min(min,minimum(word1,word2,i+1,j,dp)+1);
        dp[i][j]=min;
        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int m =word1.length();
        int n =word2.length();
        Integer[][] dp =new Integer[m][n];
        return minimum(word1,word2,0,0,dp);
    }
}