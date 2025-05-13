class Solution {
    int modulo = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        int n =s.length();
        long[][] dp = new long[26][t+1];
        long ans =0L;
        for(int i=0;i<26;i++){
            dp[i][0]=1;
        } 
        for(int i=1;i<=t;i++){
            for(int j=0;j<26;j++){
                if(j==25){
            dp[j][i] = (dp[0][i-1]%modulo+dp[1][i-1]%modulo)%modulo;
            continue;
        }
        dp[j][i]= dp[j+1][i-1]%modulo;
            }
        }
        for(int i=0;i<n;i++){
            ans=(ans+dp[s.charAt(i)-'a'][t])%modulo;
        }
        return (int)ans;
    }
}