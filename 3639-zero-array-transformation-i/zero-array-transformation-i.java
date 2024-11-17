class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] rangeCount = new int[n + 1]; // Extra space for prefix calculation

        // Mark the start and end of each query range
        for (int[] q : queries) {
            rangeCount[q[0]]++;           // Increment at the start of the range
            if (q[1] + 1 < n) rangeCount[q[1] + 1]--; // Decrement after the range
        }

        // Compute the prefix sum to get the count of queries affecting each index
        int activeQueries = 0;
        for (int i = 0; i < n; i++) {
            activeQueries += rangeCount[i];
            if (activeQueries >= nums[i]) {
                nums[i] = 0; // Set to zero if condition is met
            }
            if (nums[i] != 0) return false; // Early return if condition fails
        }
        return true;
    }
}
