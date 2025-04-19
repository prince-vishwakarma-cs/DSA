class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        int i = 0;
        while (i < nums.length && 2 * nums[i] <= upper) {
            int p = i + 1;
            int q = nums.length - 1;
            while (p < nums.length && nums[p] + nums[i] < lower) {
                p++;
            }
            int s = p;
            while (p <= q) {
                int mid = p + (q - p) / 2;
                if (nums[i] + nums[mid] <= upper) {
                    p = mid + 1;
                } else {
                    q = mid - 1;
                }
            }
            if (q >= s) {
                ans += (long) (q - s + 1);
            }
            i++;
        }
        return ans;
    }
}
