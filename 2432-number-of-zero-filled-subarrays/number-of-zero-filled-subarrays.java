class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0, curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                curr++;
            } else {
                count += (curr * (curr + 1) / 2);
                curr = 0;
            }
        }
        count += (curr * (curr + 1) / 2);

        return count;
    }
}