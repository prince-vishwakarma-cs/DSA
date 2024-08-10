class Solution {
    public boolean can(String word1, String word2) {
        if (word2.length() != word1.length() + 1) return false;
        
        int i = 0, j = 0;
        boolean used = false;
        
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
                j++;
            } else {
                if (used) return false;
                used = true;
                j++;
            }
        }
        
        return true;
    }
    
    public int lis(String[] words, int i, int last, Integer[][] dp) {
        if (i >= words.length) return 0;
        if (dp[i][last + 1] != null) return dp[i][last + 1];
        
        int ans = 0;
        if (last == -1 || can(words[last], words[i])) {
            ans = Math.max(lis(words, i + 1, i, dp) + 1, ans);
        }
        ans = Math.max(lis(words, i + 1, last, dp), ans);
        dp[i][last + 1] = ans;
        return dp[i][last + 1];
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Integer[][] dp = new Integer[words.length][words.length + 1];
        return lis(words, 0, -1, dp);
    }
}
