class Solution {
    public int countOrders(int n) {
        if (n==1) return 1;
        long mod=1000000007;
        long ans=1;
        int sp=0;
        for(int i=2;i<=n;i++){
            sp=((i-1)*2)+1;
            ans=((ans%mod)*(((sp*(sp+1))/2)%mod))%mod;
        }
        return (int)(ans%mod);
    }
}