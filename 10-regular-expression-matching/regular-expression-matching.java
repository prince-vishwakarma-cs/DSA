class Solution {
    public boolean solve(String s, String p, int i, int j, Boolean[][] dp) {
        if (i >= s.length() && j >= p.length()) return true;
        if (j >= p.length()) return false;
        if (dp[i][j] != null) return dp[i][j];

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            dp[i][j] = solve(s, p, i, j + 2, dp) || (match && solve(s, p, i + 1, j, dp));
        } else {
            dp[i][j] = match && solve(s, p, i + 1, j + 1, dp);
        }

        return dp[i][j];
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s, p, 0, 0, dp);
    }
}
