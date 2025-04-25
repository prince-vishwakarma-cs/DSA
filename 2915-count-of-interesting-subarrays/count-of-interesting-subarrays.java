class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> countMap = new HashMap<>();
        countMap.put(0, 1L); // base case
        long result = 0;
        int prefix = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                prefix++;
            }
            int rem = (prefix - k + modulo) % modulo;
            result += countMap.getOrDefault(rem, 0L);

            int currentMod = prefix % modulo;
            countMap.put(currentMod, countMap.getOrDefault(currentMod, 0L) + 1);
        }
        return result;
    }
}
