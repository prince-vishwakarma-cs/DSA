class Solution {

    public static long pow(long base, long exponent, long mod) {

        long result = 1;

        base = base % mod;

        while (exponent > 0) {

            if ((exponent % 2) == 1) {

                result = (result * base) % mod;

            }

            exponent = exponent >> 1;

            base = (base * base) % mod;

        }

        return result;

    }

    public int countGoodNumbers(long n) {

        long mod = 1000000007;

        long m = n / 2;

        long k = n - m;

        long p = pow(4, m, mod);

        long q = pow(5, k, mod);

        long ans = (p * q) % mod;

        return (int) ans;

    }

}

        
    
