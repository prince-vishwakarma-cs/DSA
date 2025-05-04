class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100]; // 1 <= a, b <= 9, so max key = 9*10 + 9 = 99
        int res = 0;
        for (int[] d : dominoes) {
            int key = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            res += count[key];
            count[key]++;
        }
        return res;
    }
}
