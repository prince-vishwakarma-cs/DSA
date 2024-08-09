class Solution {
    public int min(String word1, String word2,int i,int j,Integer[][] dp){
        if(i>=word1.length()) return word2.length()-j;
        if(j>=word2.length()) return word1.length()-i;
        int ans=0;
        if(dp[i][j]!=null) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)){
            ans=min(word1,word2,i+1,j+1,dp);
        }else{
            int ans1=min(word1,word2,i+1,j,dp)+1;
            int ans2=min(word1,word2,i,j+1,dp)+1;
            ans=Math.min(ans1,ans2);
        }
        dp[i][j]=ans;
        return ans;
    }
    public int minDistance(String word1, String word2) {
        Integer[][] dp=new Integer[word1.length()+1][word2.length()+1];
        return min(word1,word2,0,0,dp);
    }
}