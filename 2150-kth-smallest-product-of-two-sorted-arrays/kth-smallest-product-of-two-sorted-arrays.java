class Solution {
    // \U0001f680 Let's find that k-th smallest product! \U0001f680
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // Step 1: Find the minimum and maximum possible products to set our search range. \U0001f4cf
        long min1 = nums1[0]; // Smallest number in the first list. It's like the cheapest appetizer.
        long max1 = nums1[nums1.length - 1]; // Largest number in the first list. The most expensive appetizer.
        long min2 = nums2[0]; // Smallest number in the second list. The cheapest main course.
        long max2 = nums2[nums2.length - 1]; // Largest number in the second list. The most expensive main course.

        // Step 2: Determine the overall smallest and largest possible products. \U0001f9ee
        // We calculate all possible combinations to make sure we cover all scenarios.
        long left = Math.min(Math.min(min1 * min2, min1 * max2), Math.min(max1 * min2, max1 * max2)); 
        long right = Math.max(Math.max(min1 * min2, min1 * max2), Math.max(max1 * min2, max1 * max2));

        // Step 3: Binary Search time! \U0001f389 We're searching for the k-th smallest product between 'left' and 'right'.
        while (left < right) { // Keep searching as long as there's a range to explore.
            long mid = left + (right - left) / 2; // Calculate the middle point. Like guessing the average price on the menu.

            // Check how many products are less than or equal to our 'mid' value. \U0001f914
            if (count_smaller_or_equal(mid, nums1, nums2) < k) {
                // If the count is less than 'k', our 'mid' is too small. Let's look at higher values. \U0001f4c8
                left = mid + 1;
            } else {
                // If the count is equal to or greater than 'k', our 'mid' is too big or just right. \U0001f4c9
                right = mid;
            }
        }
        return left; // 'left' is our k-th smallest product! \U0001f3c6
    }

    // Helper function to count how many products are less than or equal to a given 'mid' value. \U0001f9d0
    public long count_smaller_or_equal(long mid, int[] nums1, int[] nums2) {
        long count = 0; // Initialize the counter.

        // Iterate through each number in the first list (nums1). \U0001f6b6‍♀️
        for (int i = 0; i < nums1.length; i++) {
            // Special case: if the number from nums1 is zero. 0️⃣
            if (nums1[i] == 0) {
                if (mid >= 0) {
                    count += nums2.length; // If 'mid' is non-negative, then all products with 0 are <= 'mid'.
                }
            } 
            // If the number from nums1 is positive. ➕
            else if (nums1[i] > 0) {
                // Binary search in nums2 to find how many numbers, when multiplied, result in a product <= 'mid'. \U0001f50e
                int left = 0;
                int right = nums2.length - 1;
                while (left <= right) {
                    int middle = left + (right - left) / 2;
                    // Compare the product with 'mid', using double to avoid overflow. ⚠️
                    if ((double) mid / nums1[i] >= nums2[middle]) {
                        left = middle + 1; // Increase 'left' to search for higher values.
                    } else {
                        right = middle - 1; // Decrease 'right' to search for lower values.
                    }
                }
                count += left; // Add the number of elements <= 'mid / nums1[i]' to the total count.
            } 
            // If the number from nums1 is negative. ➖
            else {
                // Binary search in nums2, but now we're looking for values >= 'mid / nums1[i]'. \U0001f504
                int left = 0;
                int right = nums2.length - 1;
                while (left <= right) {
                    int middle = left + (right - left) / 2;
                    // Compare the product with 'mid', using double to avoid overflow. ⚠️
                    if ((double) mid / nums1[i] <= nums2[middle]) {
                        right = middle - 1; // Decrease 'right' to search for lower values.
                    } else {
                        left = middle + 1; // Increase 'left' to search for higher values.
                    }
                }
                count += nums2.length - left; // Add the number of elements >= 'mid / nums1[i]' to the total count.
            }
        }
        return count; // Return the total count of products <= 'mid'. \U0001f4af
    }
}