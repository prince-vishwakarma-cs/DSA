class Solution {
    int modulo = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        int n =s.length();
        long[] dp = new long[26];
        long[] temp=new long[26];
        long ans =0L;
        for(int i=0;i<26;i++){
            dp[i]=1;
        }
        for(int i=1;i<=t;i++){
            for(int j=0;j<26;j++){
                if(j==25){
            temp[j] = (dp[0]%modulo+dp[1]%modulo)%modulo;
            continue;
        }
        temp[j]= dp[j+1]%modulo;
            }
            for(int j=0;j<26;j++){
                dp[j]=temp[j];
            }
        }
        for(int i=0;i<n;i++){
            ans=(ans+dp[s.charAt(i)-'a'])%modulo;
        }
        return (int)ans;
    }
}