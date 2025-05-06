class Solution {
    public int[] buildArray(int[] nums) {
    int n = nums.length;

    // Encode two values in one index
    for (int i = 0; i < n; i++) {
        nums[i] = nums[i] + n * (nums[nums[i]] % n);
    }

    // Extract the new value
    for (int i = 0; i < n; i++) {
        nums[i] = nums[i] / n;
    }

    return nums;
}

}