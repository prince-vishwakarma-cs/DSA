class Solution {
    public boolean canBeEqual(int[] t, int[] a) {
        int f[] = new int[1001];
        for (int x : t) f[x]++;
        for (int x : a) f[x]--;
        for (int x : f) if (x != 0) return false;
        return true;
    }
}