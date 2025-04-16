class Solution {
    public long countGood(int[] nums, int k) {
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
    long global = 0;
        long curr = 0;
        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            int n = map.get(nums[j]);
            curr += (n - 1);
            while (curr >= k) {
                global += nums.length - j;
                int freq = map.get(nums[i]);
                curr -= (freq - 1);
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) < 1) {
                    map.remove(nums[i]);
                }
                i++;
            }
        }
        return global;
    }
}
