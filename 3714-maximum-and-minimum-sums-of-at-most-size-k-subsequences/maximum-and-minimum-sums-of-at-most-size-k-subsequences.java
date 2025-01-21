class Solution {
    static final int mod = (int) 1e9 + 7;
    static long[] fact;
    static long[] inv;
    
    static void precomputeFactorials(int n) {
        fact = new long[n + 1];
        inv = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % mod;
        }
        inv[n] = power(fact[n], mod - 2, mod);
        for (int i = n - 1; i >= 0; i--) {
            inv[i] = (inv[i + 1] * (i + 1)) % mod;
        }
    }
    
    static long power(long a, long b, int m) {
        long val = 1;
        a = a % m;
        while (b > 0) {
            if ((b & 1) == 1) val = (val * a) % m;
            b = b >> 1;
            a = (a * a) % m;
        }
        return val;
    }
    
    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (fact[n] * inv[r] % mod * inv[n - r]) % mod;
    }

    public int minMaxSums(int[] nums, int k) {
    int n = nums.length;
    precomputeFactorials(n);
    Arrays.sort(nums);
    long ans = 0;

    for (int i = 1; i <= k; i++) {
        for (int j = 0; j <= n - i; j++) {
            ans = (ans + (long)nums[j] * nCr(n - j - 1, i - 1)) % mod;
        }
        
        for (int j = n - 1; j >= i - 1; j--) {
            ans = (ans + (long)nums[j] * nCr(j, i - 1)) % mod;
        }
    }
    
    return (int)ans;
}
}
