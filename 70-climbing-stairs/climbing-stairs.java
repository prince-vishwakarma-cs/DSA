class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int prev=1;
        int prevprev=1;
        for(int i=2;i<=n;i++){
            int ans=prev+prevprev;
            prevprev=prev;
            prev=ans;
        }
        return prev;
    }
}