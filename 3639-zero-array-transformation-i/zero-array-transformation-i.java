class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] rangeCount = new int[n + 1];
        for (int[] q : queries) {
            rangeCount[q[0]]++;
            if (q[1] + 1 < n) rangeCount[q[1] + 1]--;
        }

        int activeQueries = 0;
        for (int i = 0; i < n; i++) {
            activeQueries += rangeCount[i];
            if (activeQueries >= nums[i]) {
                nums[i] = 0;
            }
            if (nums[i] != 0) return false;
        }
        return true;
    }
}
