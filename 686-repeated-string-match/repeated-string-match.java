class Solution {
    public int strStr(StringBuilder haystack, StringBuilder needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0)
            return 0;
        if (m > n)
            return -1;

        int[] pow = new int[n];
        int[] hash = new int[n];
        int mod = 1000000007;

        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (int) ((long) pow[i - 1] * 31 % mod);
        }

        hash[0] = haystack.charAt(0) - 'a' + 1;
        for (int i = 1; i < n; i++) {
            hash[i] = (hash[i - 1] + (int) ((long) pow[i] * (haystack.charAt(i) - 'a' + 1) % mod)) % mod;
        }

        int hash2 = 0;
        for (int i = 0; i < m; i++) {
            hash2 = (hash2 + (int) ((long) pow[i] * (needle.charAt(i) - 'a' + 1) % mod)) % mod;
        }

        for (int i = 0; i <= n - m; i++) {
            int currHash = (hash[i + m - 1] - (i > 0 ? hash[i - 1] : 0) + mod) % mod;
            if (currHash == (int) ((long) hash2 * pow[i] % mod)) {
                return i;
            }
        }

        return -1;
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sa = new StringBuilder();
        StringBuilder sb = new StringBuilder(b);
        int count = 0;

        // Keep appending `a` until the length of `sa` is sufficient
        while (sa.length() < b.length()) {
            sa.append(a);
            count++;
        }

        if (strStr(sa, sb) != -1) {
            return count;
        }
        sa.append(a);
        count++;

        if (strStr(sa, sb) != -1) {
            return count;
        }

        return -1;
    }
}
