class Solution{
    public String shortestCommonSupersequence(String s1, String s2) {
    char lcs[] = lcs(s1,s2).toCharArray();
    int i=0,j=0;
    StringBuilder sb = new StringBuilder();
    for(char c:lcs){
        while(s1.charAt(i)!=c) sb.append(s1.charAt(i++));
        while(s2.charAt(j)!=c) sb.append(s2.charAt(j++));
        sb.append(c);
        i++;
        j++;
    }
    sb.append(s1.substring(i)).append(s2.substring(j));
    return sb.toString();
}


String lcs(String s1,String s2){
    int m = s1.length(),n=s2.length();
    int dp[][] = new int[m+1][n+1];
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j]=1+dp[i-1][j-1];
            }else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        }
    }
    StringBuilder sb = new StringBuilder();
    int i=m,j=n;
    while(i>0 && j>0){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            sb.append(s1.charAt(i-1));
            i--;
            j--;
        }else if(dp[i-1][j]>dp[i][j-1]) i--;
        else j--;
    }
    return sb.reverse().toString();
}
}