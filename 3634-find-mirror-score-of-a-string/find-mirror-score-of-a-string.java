class Solution {
    public char mirror(char c) {
        return (char) ('a' + ('z' - c));
    }

    public long calculateScore(String s) {
        long ans = 0L;
        Stack<Integer>[] st = (Stack<Integer>[]) new Stack[26];
        for (int i = 0; i < 26; i++) {
            st[i] = new Stack<>();
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (st[index].isEmpty()) {
                st[mirror(s.charAt(i)) - 'a'].push(i);
            } else {
                ans += (long) i - (long) st[index].pop();
            }
        }
        return ans;
    }
}
