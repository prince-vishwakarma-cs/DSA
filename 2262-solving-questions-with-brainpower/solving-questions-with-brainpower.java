class Solution {
    public void solution(int[][] arr,long[] dp){
        for(int i=arr.length-1;i>=0;i--){
            long max = 0;
            long nidx_take = i+1+arr[i][1] < arr.length ? dp[i+1+arr[i][1]]:0L;
            long nidx_not = i+1 < arr.length ? dp[i+1] : 0L;
            max = Math.max(max,(long)arr[i][0]+nidx_take);
            max= Math.max(max,nidx_not);
            dp[i]=max;
        }
    }
    public long mostPoints(int[][] questions) {
        long[] dp =new long[questions.length];
        solution(questions,dp);
        return dp[0];
    }
}