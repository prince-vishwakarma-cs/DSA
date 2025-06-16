class Solution {
    public int maximumDifference(int[] nums) {
        // Initialize maxDifference to -1 (meaning no profit yet!). Think of it as your initial bank balance. \U0001f3e6
        int maxDifference = -1;
        // Initialize minSoFar with the first element. This is our "lowest buying price" so far. \U0001f4b0
        int minSoFar = nums[0];

        // Start looking from the second day (index 1), 'cause you need a buying day first! \U0001f5d3️
        for (int i = 1; i < nums.length; i++) {
            // If today's price is higher than our lowest buying price... \U0001f680
            if (nums[i] > minSoFar) {
                // Calculate the profit and see if it's the best we've seen so far! \U0001f929
                maxDifference = Math.max(maxDifference, nums[i] - minSoFar);
            }
            // Update our lowest buying price to be the lowest price we've seen up to today. \U0001f4c9
            minSoFar = Math.min(minSoFar, nums[i]);
        }

        // Return the best profit we could make. If it's still -1, no profit was possible. \U0001f62d
        return maxDifference;
    }
}