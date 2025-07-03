class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == 'z') sb2.append('a');
                else sb2.append((char) (sb.charAt(i) + 1));
            }
            sb.append(sb2);
        }
        return sb.charAt(k - 1);
    }
}
