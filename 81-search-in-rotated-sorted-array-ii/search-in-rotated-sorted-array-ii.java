class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        
        while (i <= j) {
            int mid = (i + j) >> 1;

            if (nums[mid] == target) return true;

            // Handle duplicates
            if (nums[mid] == nums[j]) {
                j--;  // shrink the window
            }
            // Right half is sorted
            else if (nums[mid] < nums[j]) {
                if (target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            // Left half is sorted
            else {
                if (target >= nums[i] && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return false;
    }
}
