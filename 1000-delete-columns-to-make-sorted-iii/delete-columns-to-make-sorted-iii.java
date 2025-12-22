class Solution {
    public int minDeletionSize(String[] strs) {
        int len  = 0;
        int n =strs.length;
        int m= strs[0].length();
        int []dp = new int[m];
        Arrays.fill(dp,1);
        int fans = 1;
        for(int col = 0;col<m;col++){  
            int ans = 0;
            for(int i=0;i<col;i++){  
                boolean flag =true;
                for(int ind = 0;ind<n;ind++){
                    if(strs[ind].charAt(i)>strs[ind].charAt(col)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans = Math.max(ans,dp[i]);
                }
            }
            dp[col] = Math.max(dp[col],ans+1);
                fans = Math.max(fans,ans+1);
        }
        return m-fans;
    }
}