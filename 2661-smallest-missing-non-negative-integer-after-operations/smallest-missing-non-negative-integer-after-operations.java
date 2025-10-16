class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            int r = ((num % value) + value) % value;
            freq.put(r, freq.getOrDefault(r, 0) + 1);
        }

        int mex = 0;
        while (true) {
            int r = mex % value;
            if (freq.getOrDefault(r, 0) > 0) {
                freq.put(r, freq.get(r) - 1);
                mex++;
            } else {
                return mex;
            }
        }
    }
}
