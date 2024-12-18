class Solution {
    public long solve(String s, int i, long num) {
        if (i == s.length() || !Character.isDigit(s.charAt(i))) return num;
        
        num = num * 10 + (s.charAt(i) - '0');
        
        if (num > (long) Integer.MAX_VALUE + 1) return (long) Integer.MAX_VALUE + 1;

        return solve(s, i + 1, num);
    }
    
    public int myAtoi(String s) {
        int n = s.length();
        boolean neg = false;
        int i = 0;
        while (i < n && s.charAt(i) == ' ') i++;

        if (i < n && s.charAt(i) == '-') {
            neg = true;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }
        long num = solve(s, i, 0L);
        if (neg) {
            num = -num;
            if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        } else {
            if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        
        return (int) num;
    }
}
