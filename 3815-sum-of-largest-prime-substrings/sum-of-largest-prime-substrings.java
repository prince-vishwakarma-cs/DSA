class Solution {
    public long sumOfLargestPrimes(String s) {
        int n = s.length();
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                long val = Long.parseLong(sub);
                if (isPrime(val))
                    set.add(val);
            }
        }
        long ans = 0;
        List<Long> lt = new ArrayList<>(set);
        lt.sort((a, b) -> Long.compare(b, a));
        int m = lt.size();
        for (int i = 0; i < Math.min(3, m); i++) {
            ans += lt.get(i);
        }
        return ans;
    }

    public boolean isPrime(long n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;

    for (long i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    }

    return true;
}

}