class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int j = 0;
        for (int n : nums)
            j = Math.max(j, n);
        int i = 1;
        while (i < j) {
            int k = 0;
            int mid = i + (j - i) / 2;
            for (int n : nums) {
                if (n > mid) {
                    int s = n + mid - 1;
                    k += (s / mid) - 1;
                }
            }
            if (k <= maxOperations)
                j = mid;
            else
                i = mid + 1;
        }
        return j;
    }
}