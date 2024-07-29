class Solution {
    public int numOfWays(int n) {
        long c2 = 6;
        long c3= 6;
        long mod=1000000007;
        for(int i=2;i<=n;i++){
            long temp=c2;
            c2=( 2*c3 + 3*c2) % mod;
            c3=(2*temp + 2*c3) % mod;
        }
        return (int)((c2+c3)%mod);
    }
}