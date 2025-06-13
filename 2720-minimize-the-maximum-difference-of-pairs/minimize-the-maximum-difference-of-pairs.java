class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2, pairs = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    pairs++;
                    i++;
                }
            }
            if (pairs >= p) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}